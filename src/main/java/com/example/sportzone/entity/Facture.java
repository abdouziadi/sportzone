package com.example.sportzone.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
@Getter
@Setter
@Entity
public class Facture {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Double montantHT;
    private Double tva;
    private Double montantTotal;
    private String description;

    @ManyToOne
    @JoinColumn(name = "abonnement_id")
    private Abonnement abonnement;
}

