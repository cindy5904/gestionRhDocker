package com.example.demo.controller;

import com.example.demo.dto.CandidatDtoGet;
import com.example.demo.dto.CandidatDtoPost;

import com.example.demo.service.CandidatService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin
@RestController
@RequestMapping("/candidat")
public class CandidatController {
    @Autowired
    private CandidatService candidatService;

    @GetMapping("/candidats")
    public ResponseEntity<List<CandidatDtoGet>> getALlCandidat (){
        return ResponseEntity.ok(candidatService.findAll());
    }
    @GetMapping("/candidats/{id}")
    public ResponseEntity<CandidatDtoGet> getCandidatById(@PathVariable("id") int id){
        return ResponseEntity.ok(candidatService.findById(id));
    }

    @PostMapping("/candidats/add")
    public ResponseEntity<CandidatDtoGet> addCandidat (@Validated @RequestBody CandidatDtoPost candidatDtoPost){
        return ResponseEntity.status(HttpStatus.CREATED).body(candidatService.create(candidatDtoPost));
    }

    @PutMapping("/candidats/{id}")
    public ResponseEntity<CandidatDtoGet> updateCandidat (@PathVariable("id") int id ,@Validated @RequestBody CandidatDtoPost candidatDtoPost){
        return ResponseEntity.ok(candidatService.update(id,candidatDtoPost));
    }

    @DeleteMapping("/candidats/{id}")
    public ResponseEntity<String> deletecandidat (@PathVariable("id") int id){
        candidatService.delete(id);
        return ResponseEntity.ok("candidat with id :"+id+" is delete");
    }
}
