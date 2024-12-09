package com.example.sportzone.RestController;

import com.example.sportzone.Services.ProprietairesalleService;
import com.example.sportzone.entity.Proprietairesalle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/proprietairesalle")
public class ProprietairesalleRestController {

    @Autowired
    private ProprietairesalleService proprietairesalleService;

    @PostMapping("/save")
    public Proprietairesalle createProprietairesalle(@RequestBody Proprietairesalle proprietairesalle) {
        return proprietairesalleService.createProprietairesalle(proprietairesalle);
    }

    @GetMapping("/all")
    public List<Proprietairesalle> getAllProprietairesalle() {
        return proprietairesalleService.getAllProprietairesalle();
    }

    @GetMapping("/getOne/{id}")
    public Proprietairesalle getProprietairesalleById(@PathVariable long id) {
        return proprietairesalleService.getProprietairesalleById(id).orElse(null);
    }

    @PutMapping("/update/{id}")
    public Proprietairesalle updateProprietairesalle(@PathVariable long id, @RequestBody Proprietairesalle proprietairesalle) {
        Proprietairesalle existingProprietairesalle = proprietairesalleService.getProprietairesalleById(id).orElse(null);

        if (existingProprietairesalle != null) {
            proprietairesalle.setId(id);
            return proprietairesalleService.updateProprietairesalle(proprietairesalle);
        } else {
            throw new RuntimeException("Proprietairesalle not found");
        }
    }

    @DeleteMapping("/delete/{id}")
    public void deleteProprietairesalle(@PathVariable long id) {
        proprietairesalleService.deleteProprietairesalle(id);
    }
}
