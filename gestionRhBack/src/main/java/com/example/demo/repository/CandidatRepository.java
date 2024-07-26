package com.example.demo.repository;

import com.example.demo.entity.Candidat;
import org.springframework.data.repository.CrudRepository;

public interface CandidatRepository extends CrudRepository<Candidat, Integer> {
}
