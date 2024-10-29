package com.example.sportzone.Services;

import com.example.sportzone.Repository.AbonnementRepository;
import com.example.sportzone.entity.Abonnement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class AbonnementService {

    @Autowired
    private AbonnementRepository abonnementRepository;

    @Transactional
    public Abonnement createAbonnement(Abonnement abonnement) {
        return abonnementRepository.save(abonnement);
    }

    public List<Abonnement> getAllAbonnements() {
        return abonnementRepository.findAll();
    }

    public Optional<Abonnement> getAbonnementById(int id) {
        return abonnementRepository.findById(id);
    }

    @Transactional
    public Abonnement updateAbonnement(Abonnement abonnement) {
        return abonnementRepository.save(abonnement);
    }

    @Transactional
    public void deleteAbonnement(int id) {
        if (abonnementRepository.existsById(id)) {
            abonnementRepository.deleteById(id);
        } else {
            throw new RuntimeException("Abonnement not found with id: " + id);
        }
    }
}
