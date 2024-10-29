package com.example.sportzone.entity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.BatchSize;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class Utilisateur{
    @Id
    @GeneratedValue (strategy = GenerationType.TABLE)
    private Long id;

    private String nom;
    private String prenom;
    private String email;
    private String password;
    private String adresse;

}

