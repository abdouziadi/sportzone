package com.example.sportzone.entity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Client extends Utilisateur {

    @OneToMany(mappedBy = "client", cascade = CascadeType.ALL)
    private List<Abonnement> abonnements;
}
