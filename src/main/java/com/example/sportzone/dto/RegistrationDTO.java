package com.example.sportzone.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RegistrationDTO {
    private String nom;
    private String prenom;
    private String email;
    private String password;
    private String adresse;
    private String userType; // Can be CLIENT or PROPRIETAIRESALLE
}
