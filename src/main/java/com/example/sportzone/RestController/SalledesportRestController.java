package com.example.sportzone.RestController;

import com.example.sportzone.Services.SalledesportService;
import com.example.sportzone.entity.Salledesport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/salledesport")
public class SalledesportRestController {

    @Autowired
    private SalledesportService salledesportService;

    @PostMapping("/save")
    public Salledesport createSalledesport(@RequestBody Salledesport salledesport) {
        return salledesportService.createSalledesport(salledesport);
    }

    @GetMapping("/all")
    public List<Salledesport> getAllSallesdesport() {
        return salledesportService.getAllSalledesport();
    }

    @GetMapping("/getOne/{id}")
    public Salledesport getSalledesportById(@PathVariable long id) {
        return salledesportService.getSalledesportById(id).orElse(null);
    }

    @PutMapping("/update/{id}")
    public Salledesport updateSalledesport(@PathVariable long id, @RequestBody Salledesport salledesport) {
        Salledesport existingSalledesport = salledesportService.getSalledesportById(id).orElse(null);

        if (existingSalledesport != null) {
            salledesport.setId(id);
            return salledesportService.updateSalledesport(salledesport);
        } else {
            throw new RuntimeException("Salledesport not found");
        }
    }

    @DeleteMapping("/delete/{id}")
    public void deleteSalledesport(@PathVariable long id) {
        salledesportService.deleteSalledesport(id);
    }
}
