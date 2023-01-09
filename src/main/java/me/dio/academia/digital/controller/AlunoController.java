package me.dio.academia.digital.controller;

import me.dio.academia.digital.entity.Aluno;
import me.dio.academia.digital.entity.form.AlunoForm;
import me.dio.academia.digital.service.IAlunoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/alunos")
public class AlunoController {

    private IAlunoService alunoService;

    @Autowired
    public AlunoController(IAlunoService alunoService){
        this.alunoService = alunoService;
    }

    @GetMapping
    public ResponseEntity<List<Aluno>> getAll(){
        return ResponseEntity.ok(alunoService.getAll());
    }

    @PostMapping
    public ResponseEntity<Aluno> create(@RequestBody AlunoForm alunoForm){
        Aluno aluno = alunoService.create(alunoForm);

        return ResponseEntity.created(URI.create("")).body(aluno);
    }
}
