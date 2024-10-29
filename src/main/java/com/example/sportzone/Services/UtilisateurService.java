package com.example.sportzone.Services;

import com.example.sportzone.Repository.UtilisateurRepository;
import com.example.sportzone.entity.Utilisateur;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class UtilisateurService {

    @Autowired
    private UtilisateurRepository utilisateurRepository;

    @Transactional
    public Utilisateur createUtilisateur(Utilisateur utilisateur) {
        return utilisateurRepository.save(utilisateur);
    }

    public List<Utilisateur> getAllUtilisateurs() {
        return utilisateurRepository.findAll();
    }

    public Optional<Utilisateur> getUtilisateurById(int id) {
        return utilisateurRepository.findById(id);
    }

    @Transactional
    public Utilisateur updateUtilisateur(Utilisateur utilisateur) {
        return utilisateurRepository.save(utilisateur);
    }

    @Transactional
    public void deleteUtilisateur(int id) {
        if (utilisateurRepository.existsById(id)) {
            utilisateurRepository.deleteById(id);
        } else {
            throw new RuntimeException("Utilisateur not found with id: " + id);
        }
    }
}
