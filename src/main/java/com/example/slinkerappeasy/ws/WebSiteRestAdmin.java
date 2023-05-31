package com.example.slinkerappeasy.ws;


import com.example.slinkerappeasy.Bean.WebSite;
import com.example.slinkerappeasy.Service.impl.admin.WebSiteAdminServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@RestController
@RequestMapping("/api/admin/webSite/")
public class WebSiteRestAdmin {

    @PostMapping("")
    public int save(@RequestBody WebSite webSite) {
        return webSiteAdminService.save(webSite);
    }
@DeleteMapping("id/{id}")
    @Transactional
    public void deleteAssociatedLists(@PathVariable Long id) {
        webSiteAdminService.deleteAssociatedLists(id);
    }
@PutMapping("")
    public int update(@RequestBody WebSite webSite) {
        return webSiteAdminService.update(webSite);
    }
@GetMapping("statutWebSite/id/{id}")
    public List<WebSite> findByStatutWebSiteId(@PathVariable Long id) {
        return webSiteAdminService.findByStatutWebSiteId(id);
    }
@DeleteMapping("statutWebSite/id/{id}")
    public int deleteByStatutWebSiteId(@PathVariable Long id) {
        return webSiteAdminService.deleteByStatutWebSiteId(id);
    }
@GetMapping("client/id/{id}")
    public List<WebSite> findByClientId(@PathVariable Long id) {
        return webSiteAdminService.findByClientsId(id);
    }
@DeleteMapping("client/id/{id}")
    public int deleteByClientId(@PathVariable Long id) {
        return webSiteAdminService.deleteByClientsId(id);
    }
@GetMapping("id/{id}")
    public WebSite findById(@PathVariable Long id) {
        return webSiteAdminService.findById(id);
    }

    @Autowired
    public WebSiteAdminServiceImpl webSiteAdminService;
}