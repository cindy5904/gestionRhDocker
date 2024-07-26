package com.example.demo.repository;

import com.example.demo.entity.Employe;
import org.springframework.data.repository.CrudRepository;

public interface EmployeRepository extends CrudRepository<Employe, Integer> {
}
