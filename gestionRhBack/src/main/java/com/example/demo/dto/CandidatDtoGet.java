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
public class CandidatDtoGet {
    private int id;
    private String nom;
    private String numeroIdentification;
    private String adresse;
    private String telephone;
    private String email;
    private LocalDate dateNaissance;
    private double evaluation;
    private String observation;
    private String competence;
    private String domaineTechnique;
    private LocalDate dateEntretien;
}
