package com.example.demo.service;

import com.example.demo.dto.EmployeDtoGet;
import com.example.demo.dto.EmployeDtoPost;
import com.example.demo.entity.Employe;
import com.example.demo.exception.NotFoundException;
import com.example.demo.repository.EmployeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class EmployeService implements BaseService<EmployeDtoPost, EmployeDtoGet>  {

    @Autowired
    private EmployeRepository employeRepository;
    private final DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
    @Override
    public EmployeDtoGet create(EmployeDtoPost employeDtoPost) {
        Employe employe = Employe.builder()
                .nom(employeDtoPost.getNom())
                .numeroIdentification(employeDtoPost.getNumeroIdentification())
                .adresse(employeDtoPost.getAdresse())
                .telephone(employeDtoPost.getTelephone())
                .email(employeDtoPost.getEmail())
                .dateNaissance(LocalDate.parse(employeDtoPost.getDateNaissance(), dateFormatter))
                .debutContrat(LocalDate.parse(employeDtoPost.getDebutContrat(), dateFormatter))
                .finContrat(LocalDate.parse(employeDtoPost.getFinContrat(), dateFormatter))
                .poste(employeDtoPost.getPoste())
                .motDePasse(employeDtoPost.getMotDePasse())
                .admin(employeDtoPost.isAdmin())
                .salaire(employeDtoPost.getSalaire())
                .observation(employeDtoPost.getObservation())
                .build();
        employeRepository.save(employe);

        return employeToEmployeDtoGet(employe);
    }

    @Override
    public EmployeDtoGet update(int id, EmployeDtoPost employeDtoPost) {
        Employe employe =getById(id);
        employe.setNom(employeDtoPost.getNom());
        employe.setNumeroIdentification(employeDtoPost.getNumeroIdentification());
        employe.setAdresse(employeDtoPost.getAdresse());
        employe.setTelephone(employeDtoPost.getTelephone());
        employe.setEmail(employeDtoPost.getEmail());
        employe.setDateNaissance(LocalDate.parse(employeDtoPost.getDateNaissance(), dateFormatter));
        employe.setDebutContrat(LocalDate.parse(employeDtoPost.getDebutContrat(), dateFormatter));
        employe.setFinContrat(LocalDate.parse(employeDtoPost.getFinContrat(), dateFormatter));
        employe.setPoste(employeDtoPost.getPoste());
        employe.setMotDePasse(employeDtoPost.getMotDePasse());
        employe.setAdmin(employeDtoPost.isAdmin());
        employe.setSalaire(employeDtoPost.getSalaire());
        employe.setObservation(employeDtoPost.getObservation());
        employeRepository.save(employe);
        return employeToEmployeDtoGet(employe);

    }

    @Override
    public boolean delete(int id) {
        Employe employe = getById(id);
        employeRepository.delete(employe);
        return true;
    }

    @Override
    public EmployeDtoGet findById(int id) {
        return employeToEmployeDtoGet(getById(id));
    }

    @Override
    public List<EmployeDtoGet> findAll() {
        return employeListToemployeDtoList((List<Employe>) employeRepository.findAll());
    }

    private Employe getById (int id){
        return employeRepository.findById(id).orElseThrow(NotFoundException::new);
    }

    private EmployeDtoGet employeToEmployeDtoGet (Employe employe){
        return EmployeDtoGet.builder()
                .id(employe.getId())
                .nom(employe.getNom())
                .numeroIdentification(employe.getNumeroIdentification())
                .adresse(employe.getAdresse())
                .telephone(employe.getTelephone())
                .email(employe.getEmail())
                .dateNaissance(employe.getDateNaissance())
                .debutContrat(employe.getDebutContrat())
                .finContrat(employe.getFinContrat())
                .poste(employe.getPoste())
                .motDePasse(employe.getMotDePasse())
                .admin(employe.isAdmin())
                .salaire(employe.getSalaire())
                .observation(employe.getObservation())
                .build();
    }

    private List<EmployeDtoGet> employeListToemployeDtoList(List<Employe> employeList){
        return employeList.stream().map(this::employeToEmployeDtoGet).collect(Collectors.toList());
    }
}
