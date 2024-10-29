package com.example.sportzone.entity;

import jakarta.persistence.*;


@Entity
public class ServiceEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nom;
    private String description;

    @ManyToOne
    @JoinColumn(name = "abbonement_id")
    private Abonnement abonnement;

}
