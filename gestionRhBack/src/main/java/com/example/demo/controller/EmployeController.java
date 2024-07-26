package com.example.demo.controller;
import com.example.demo.dto.EmployeDtoGet;
import com.example.demo.dto.EmployeDtoPost;
import com.example.demo.service.EmployeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import java.util.List;
@CrossOrigin
@RestController
@RequestMapping("/employe")
public class EmployeController {
    @Autowired
    private EmployeService employeService;

    @GetMapping("/employes")
    public ResponseEntity<List<EmployeDtoGet>> getALlEmploye (){
        return ResponseEntity.ok(employeService.findAll());
    }
    @GetMapping("/employes/{id}")
    public ResponseEntity<EmployeDtoGet> getEmployeById(@PathVariable("id") int id){
        return ResponseEntity.ok(employeService.findById(id));
    }

    @PostMapping("/employes/add")
    public ResponseEntity<EmployeDtoGet> addEmploye (@Validated @RequestBody EmployeDtoPost employeDtoPost){
        return ResponseEntity.status(HttpStatus.CREATED).body(employeService.create(employeDtoPost));
    }

    @PutMapping("/employes/{id}/edit")
    public ResponseEntity<EmployeDtoGet> updateEmploye (@PathVariable("id") int id ,@Validated @RequestBody EmployeDtoPost employeDtoPost){
        return ResponseEntity.ok(employeService.update(id,employeDtoPost));
    }

    @DeleteMapping("/employes/{id}/delete")
    public ResponseEntity<String> deleteEmploye (@PathVariable("id") int id){
        employeService.delete(id);
        return ResponseEntity.ok("employe with id :"+id+" is delete");
    }
}
