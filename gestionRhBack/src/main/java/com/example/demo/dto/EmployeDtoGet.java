package com.example.demo.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDate;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class EmployeDtoGet {
    private int id;
    private String nom;
    private String numeroIdentification;
    private String adresse;
    private String telephone;
    private String email;
    private LocalDate dateNaissance;
    private LocalDate debutContrat;
    private LocalDate finContrat;
    private String poste;
    private String motDePasse;
    private boolean admin;
    private double salaire;
    private String observation;
}
