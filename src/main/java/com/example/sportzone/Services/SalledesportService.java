package com.example.sportzone.Services;

import com.example.sportzone.Repository.SalledesportRepository;
import com.example.sportzone.entity.Salledesport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class SalledesportService {

    @Autowired
    private SalledesportRepository salledesportRepository;

    @Transactional
    public Salledesport createSalledesport(Salledesport salledesport) {
        return salledesportRepository.save(salledesport);
    }

    public List<Salledesport> getAllSalledesport() {
        return salledesportRepository.findAll();
    }

    public Optional<Salledesport> getSalledesportById(int id) {
        return salledesportRepository.findById(id);
    }

    @Transactional
    public Salledesport updateSalledesport(Salledesport salledesport) {
        return salledesportRepository.save(salledesport);
    }

    @Transactional
    public void deleteSalledesport(int id) {
        if (salledesportRepository.existsById(id)) {
            salledesportRepository.deleteById(id);
        } else {
            throw new RuntimeException("Salledesport not found with id: " + id);
        }
    }
}
