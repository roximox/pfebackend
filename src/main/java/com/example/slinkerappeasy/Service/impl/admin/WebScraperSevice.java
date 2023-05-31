package com.example.slinkerappeasy.Service.impl.admin;


import com.example.slinkerappeasy.Bean.Result;
import com.example.slinkerappeasy.Bean.WebSite;
import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Service
public class WebScraperSevice  {
    private Set<String> visitedLinks;
    private List<String> extractedLinks;
    private static final int THREAD_POOL_SIZE = 10;

    public List<String> scrapeLinksWebsite(Long id) {
        WebSite webSite = webSiteAdminService.findById(id);
        extractedLinks = new ArrayList<>();
        visitedLinks = new HashSet<>();
        try {
            ExecutorService executor = Executors.newFixedThreadPool(THREAD_POOL_SIZE);
            scrapePage(webSite.getUrl(), executor);
            executor.shutdown();
            while (!executor.isTerminated()) {
                // Attente de la fin de tous les threads
            }
        } catch (IOException e) {
            e.printStackTrace();
            // Gérer l'exception selon vos besoins
        }
        return extractedLinks;
    }

    private void scrapePage(String pageUrl, ExecutorService executor) throws IOException {
        if (!visitedLinks.contains(pageUrl)) {
            visitedLinks.add(pageUrl);
            Document document = Jsoup.connect(pageUrl).get();
            Elements links = document.select("a[href]");

            List<String> batchLinks = new ArrayList<>();

            for (Element link : links) {
                String href = link.absUrl("href");
                if (isValidLink(href) && !visitedLinks.contains(href)) {
                    batchLinks.add(href);
                }
            }

            synchronized (extractedLinks) {
                extractedLinks.addAll(batchLinks);
            }

            for (String link : batchLinks) {
                executor.execute(() -> {
                    try {
                        scrapePage(link, executor);
                    } catch (IOException e) {
                        // Gérer l'exception
                    }
                });
            }
        }
    }

    // Reste du code inchangé

    public List<String> scrapeAndFilterAmazonLinks(Long id) {
        List<String> links = scrapeLinksWebsite(id);
        Set<String> visitedLinks = new HashSet<>(); // Ensemble des liens visités
        List<String> amazonLinks = new ArrayList<>(); // Ensemble des liens Amazon identifiés

        ExecutorService executor = Executors.newFixedThreadPool(THREAD_POOL_SIZE);

        for (String link : links) {
            if (visitedLinks.contains(link)) {
                continue; // Si le lien a déjà été visité, passer à l'itération suivante
            }
            visitedLinks.add(link); // Ajouter le lien visité à l'ensemble des liens visités

            executor.execute(() -> {
                try {
                    Connection connection = Jsoup.connect(link);
                    Document document = connection.get();
                    Elements pageLinks = document.select("a[href]"); // Récupérer tous les liens de la page

                    List<String> batchLinks = new ArrayList<>();

                    for (Element pageLink : pageLinks) {
                        String linkUrl = pageLink.absUrl("href");
                        if (linkUrl.isEmpty() || visitedLinks.contains(linkUrl)) {
                            continue; // Si le lien est vide ou a déjà été visité, passer à l'itération suivante
                        }
                        if (linkUrl.contains("amazon") || linkUrl.contains("amzn")) {
                            batchLinks.add(linkUrl); // Si le lien pointe vers Amazon, l'ajouter à l'ensemble des liens Amazon identifiés
                        }
                    }

                    synchronized (amazonLinks) {
                        amazonLinks.addAll(batchLinks);
                    }
                } catch (IOException e) {
                    // Gérer l'exception
                }
            });
        }

        executor.shutdown();
        while (!executor.isTerminated()) {
            // Attente de la fin de tous les threads
        }

        return amazonLinks; // Convertir l'ensemble des liens Amazon identifiés en liste et la renvoyer
    }
    public List<Result> AmazonProducts(Long id) {
        List<String> amazonLinks = scrapeAndFilterAmazonLinks(id);
        List<Result> items = new ArrayList<>(); // Liste des objets ScrapingOperationItem

        ExecutorService executor = Executors.newFixedThreadPool(THREAD_POOL_SIZE);

        for (String link : amazonLinks) {
            executor.execute(() -> {
                try {
                    Connection connection = Jsoup.connect(link);
                    Document document = connection.get();
                    Element product = document.selectFirst(".a-container");
                    String title = product.select("#productTitle").text(); // Récupérer le titre du produit
                    String stock = product.select("#availability").text(); // Récupérer le stock du produit
                    String rating = product.select(".a-popover-content").text(); // Récupérer le rating du produit
                    String imageUrl = product.select("img").attr("src");
                    Result item = new Result();// Créer un objet ScrapingOperationItem avec les informations récupérées
                    item.setDescription(title);
                    item.setStock(stock);
                    item.setReview(rating);
                    item.setImage(imageUrl);
                    synchronized (items) {
                        items.add(item);
                    }
                } catch (IOException e) {
                    // Gérer l'exception
                }
            });
        }

        executor.shutdown();
        while (!executor.isTerminated()) {
            // Attente de la fin de tous les threads
        }

        return  items; // Renvoyer la liste des objets ScrapingOperationItem
    }

    private boolean isValidLink (String link){
        // Ajoutez ici des conditions supplémentaires pour ignorer les liens erronés
        return link != null && !link.isEmpty() && !link.startsWith("mailto:") && !link.contains("pinterest")&& !link.contains("instagram")&& !link.contains("youtube")&& !link.contains("tiktok")&& !link.contains("twiter")&& !link.contains("facebook")&& !link.contains("menu");
    }
    @Autowired
    private WebSiteAdminServiceImpl webSiteAdminService;
}