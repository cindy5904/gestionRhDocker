package com.example.demo.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;



@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class EmployeDtoPost {
    private String nom;
    private String numeroIdentification;
    private String adresse;
    private String telephone;
    private String email;
    private String dateNaissance;
    private String debutContrat;
    private String finContrat;
    private String poste;
    private String motDePasse;
    private boolean admin;
    private double salaire;
    private String observation;

}
