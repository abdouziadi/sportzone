package com.example.sportzone.entity;
import jakarta.persistence.*;
import java.util.List;

@Entity
public class Salledesport {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nomSalle;
    private String adresse;
    private String numTel;
    private String heureOuverture;
    private String heureFermeture;

    @ManyToOne
    @JoinColumn(name = "proprietaire_id")
    private Proprietairesalle proprietairesalle;  // Many gyms can belong to one owner

    @OneToMany(mappedBy = "salledesport", cascade = CascadeType.ALL)
    private List<Abonnement> abonnements;
}

