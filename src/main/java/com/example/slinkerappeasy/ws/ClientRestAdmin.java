package com.example.slinkerappeasy.ws;




import com.example.slinkerappeasy.Bean.Client;
import com.example.slinkerappeasy.Service.impl.admin.ClientAdminServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/admin/client/")
public class ClientRestAdmin  {
@GetMapping("statut/id/{id}")
    public List<Client> findByStatutClientId(@PathVariable Long id) {
        return clientAdminService.findByStatutClientId(id);
    }
@DeleteMapping("statut/id/{id}")
    public int deleteByStatutClientId(@PathVariable Long id) {
        return clientAdminService.deleteByStatutClientId(id);
    }
@GetMapping("id/{id}")
    public Client findById(@PathVariable Long id) {
        return clientAdminService.findById(id);
    }
@GetMapping("email/{email}/password/{password}")
    public Client findByEmailAndPassword(@PathVariable String email,@PathVariable String password) {
        return clientAdminService.findByEmailAndPassword(email, password);
    }
@GetMapping("")
    public List<Client> findAll() {
        return clientAdminService.findAll();
    }
@PostMapping("")
    public int create(@RequestBody Client t) {
        return clientAdminService.create(t);
    }
@DeleteMapping("website/id/{id}")
    public int deleteByWebSitesId(@PathVariable Long id) {
        return clientAdminService.deleteByWebSitesId(id);
    }

    @Autowired
    public ClientAdminServiceImpl clientAdminService;

}