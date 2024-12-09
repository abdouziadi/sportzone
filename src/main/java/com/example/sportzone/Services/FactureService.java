package com.example.sportzone.Services;

import com.example.sportzone.Repository.FactureRepository;
import com.example.sportzone.entity.Facture;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class FactureService {

    @Autowired
    private FactureRepository factureRepository;

    @Transactional
    public Facture createFacture(Facture facture) {
        return factureRepository.save(facture);
    }

    public List<Facture> getAllFactures() {
        return factureRepository.findAll();
    }

    public Optional<Facture> getFactureById(Long id) {
        return factureRepository.findById(id);
    }

    @Transactional
    public Facture updateFacture(Facture facture) {
        return factureRepository.save(facture);
    }

    @Transactional
    public void deleteFacture(Long id) {
        if (factureRepository.existsById(id)) {
            factureRepository.deleteById(id);
        } else {
            throw new RuntimeException("Facture not found with id: " + id);
        }
    }
}
