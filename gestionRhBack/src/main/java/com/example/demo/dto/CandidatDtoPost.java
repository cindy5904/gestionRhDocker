package com.example.demo.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CandidatDtoPost {
    private String nom;
    private String numeroIdentification;
    private String adresse;
    private String telephone;
    private String email;
    private String dateNaissance;
    private double evaluation;
    private String observation;
    private String competence;
    private String domaineTechnique;
    private String dateEntretien;
}
