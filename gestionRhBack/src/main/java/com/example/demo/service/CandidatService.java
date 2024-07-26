package com.example.demo.service;

import com.example.demo.dto.CandidatDtoGet;
import com.example.demo.dto.CandidatDtoPost;

import com.example.demo.entity.Candidat;

import com.example.demo.exception.NotFoundException;
import com.example.demo.repository.CandidatRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.stream.Collectors;
@Service
public class CandidatService implements BaseService<CandidatDtoPost, CandidatDtoGet> {

    @Autowired
    private CandidatRepository candidatRepository;
    private final DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
    @Override
    public CandidatDtoGet create(CandidatDtoPost candidatDtoPost) {
        Candidat candidat = Candidat.builder()
                .nom(candidatDtoPost.getNom())
                .numeroIdentification(candidatDtoPost.getNumeroIdentification())
                .adresse(candidatDtoPost.getAdresse())
                .telephone(candidatDtoPost.getTelephone())
                .email(candidatDtoPost.getEmail())
                .dateNaissance(LocalDate.parse(candidatDtoPost.getDateNaissance(), dateFormatter))
                .evaluation(candidatDtoPost.getEvaluation())
                .observation(candidatDtoPost.getObservation())
                .competence(candidatDtoPost.getCompetence())
                .domaineTechnique(candidatDtoPost.getDomaineTechnique())
                .dateEntretien(LocalDate.parse(candidatDtoPost.getDateEntretien(), dateFormatter))
                .build();
        candidatRepository.save(candidat);

        return candidatToCandidatDtoGet(candidat);
    }

    @Override
    public CandidatDtoGet update(int id, CandidatDtoPost candidatDtoPost) {
        Candidat candidat = getById(id);
        candidat.setNom(candidatDtoPost.getNom());
        candidat.setNumeroIdentification(candidatDtoPost.getNumeroIdentification());
        candidat.setAdresse(candidatDtoPost.getAdresse());
        candidat.setTelephone(candidatDtoPost.getTelephone());
        candidat.setEmail(candidatDtoPost.getEmail());
        candidat.setDateNaissance(LocalDate.parse(candidatDtoPost.getDateNaissance(), dateFormatter));
        candidat.setEvaluation(candidatDtoPost.getEvaluation());
        candidat.setObservation(candidatDtoPost.getObservation());
        candidat.setCompetence(candidatDtoPost.getCompetence());
        candidat.setDomaineTechnique(candidatDtoPost.getDomaineTechnique());
        candidat.setDateEntretien(LocalDate.parse(candidatDtoPost.getDateEntretien(),  dateFormatter));
        candidatRepository.save(candidat);

        return candidatToCandidatDtoGet(candidat);
    }

    @Override
    public boolean delete(int id) {
        Candidat candidat = getById(id);
        candidatRepository.delete(candidat);
        return true;
    }

    @Override
    public CandidatDtoGet findById(int id) {
        return candidatToCandidatDtoGet(getById(id));
    }

    @Override
    public List<CandidatDtoGet> findAll() {
        return candidatListTocandidatDtoList((List<Candidat>) candidatRepository.findAll());
    }
    private Candidat getById (int id){
        return candidatRepository.findById(id).orElseThrow(NotFoundException::new);
    }

    private CandidatDtoGet candidatToCandidatDtoGet (Candidat candidat){
        return CandidatDtoGet.builder()
                .id(candidat.getId())
                .nom(candidat.getNom())
                .numeroIdentification(candidat.getNumeroIdentification())
                .adresse(candidat.getAdresse())
                .telephone(candidat.getTelephone())
                .email(candidat.getEmail())
                .dateNaissance(candidat.getDateNaissance())
                .evaluation(candidat.getEvaluation())
                .observation(candidat.getObservation())
                .competence(candidat.getCompetence())
                .domaineTechnique(candidat.getDomaineTechnique())
                .dateEntretien(candidat.getDateEntretien())
                .build();
    }

    private List<CandidatDtoGet> candidatListTocandidatDtoList(List<Candidat> candidatList){
        return candidatList.stream().map(this:: candidatToCandidatDtoGet).collect(Collectors.toList());
    }
}
