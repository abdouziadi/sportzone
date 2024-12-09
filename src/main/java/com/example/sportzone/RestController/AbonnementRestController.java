package com.example.sportzone.RestController;

import com.example.sportzone.Services.AbonnementService;
import com.example.sportzone.entity.Abonnement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/abonnement")
public class AbonnementRestController {

    @Autowired
    private AbonnementService abonnementService;

    @PostMapping("/save")
    public Abonnement createAbonnement(@RequestBody Abonnement abonnement) {
        return abonnementService.createAbonnement(abonnement);
    }

   /* @GetMapping("/all")
    public List<Abonnement> getAllAbonnements() {
        return abonnementService.getAllAbonnements();
    }*/


    @GetMapping("/getOne/{id}")
    public Abonnement getAbonnementById(@PathVariable long id) {
        return abonnementService.getAbonnementById(id).orElse(null);
    }

    @PutMapping("/update/{id}")
    public Abonnement updateAbonnement(@PathVariable long id, @RequestBody Abonnement abonnement) {
        Abonnement ExistingAbonnement = abonnementService.getAbonnementById(id).orElse(null);

        if(ExistingAbonnement != null) {
            abonnement.setId(id);
            return abonnementService.updateAbonnement(abonnement);
        }else {
            throw  new RuntimeException("abonnement not found");
        }
    }

    @DeleteMapping("/delete/{id}")
    public void deleteAbonnement(@PathVariable long id) {
        abonnementService.deleteAbonnement(id);
    }
}



