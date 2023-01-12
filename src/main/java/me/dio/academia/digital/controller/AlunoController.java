package me.dio.academia.digital.controller;

import me.dio.academia.digital.entity.dto.form.AlunoForm;
import me.dio.academia.digital.entity.dto.form.AlunoUpdateForm;
import me.dio.academia.digital.entity.dto.view.AlunoView;
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
    public ResponseEntity<List<AlunoView>> getAll(){
        return ResponseEntity.ok(alunoService.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<AlunoView> get(@PathVariable Long id){
        return ResponseEntity.of(alunoService.get(id));
    }

    @PostMapping
    public ResponseEntity<AlunoView> create(@RequestBody AlunoForm alunoForm){
        AlunoView aluno = alunoService.create(alunoForm);

        return ResponseEntity.created(URI.create("/alunos/" + aluno.getId())).body(aluno);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<AlunoView> update(@PathVariable Long id, @RequestBody AlunoUpdateForm alunoForm){
        AlunoView aluno = alunoService.update(id, alunoForm);
        
        return ResponseEntity.created(URI.create("/alunos/" + aluno.getId())).body(aluno);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id){
        alunoService.delete(id);
    }
}
