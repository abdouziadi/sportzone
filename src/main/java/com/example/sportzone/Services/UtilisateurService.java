package com.example.sportzone.Services;

import com.example.sportzone.dto.RegistrationDTO;
import com.example.sportzone.entity.Client;
import com.example.sportzone.entity.Proprietairesalle;
import com.example.sportzone.entity.Utilisateur;
import com.example.sportzone.Repository.UtilisateurRepository; // Make sure this repository exists
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UtilisateurService {

    @Autowired
    private UtilisateurRepository utilisateurRepository;

    public void registerUser(RegistrationDTO registrationDTO) {
        Utilisateur utilisateur;

        if ("CLIENT".equalsIgnoreCase(registrationDTO.getUserType())) {
            utilisateur = new Client();
        } else if ("PROPRIETAIRESALLE".equalsIgnoreCase(registrationDTO.getUserType())) {
            utilisateur = new Proprietairesalle();
        } else {
            throw new IllegalArgumentException("Invalid user type");
        }

        utilisateur.setNom(registrationDTO.getNom());
        utilisateur.setPrenom(registrationDTO.getPrenom());
        utilisateur.setEmail(registrationDTO.getEmail());
        utilisateur.setPassword(registrationDTO.getPassword());
        utilisateur.setAdresse(registrationDTO.getAdresse());

        utilisateurRepository.save(utilisateur);
    }

    public List<Utilisateur> getAllUsers() {
        return utilisateurRepository.findAll();
    }

    public Utilisateur getUserById(Long id) {
        return utilisateurRepository.findById(id).orElseThrow(() -> new RuntimeException("User not found"));
    }

    public void deleteUser(Long id) {
        utilisateurRepository.deleteById(id);
    }
}
