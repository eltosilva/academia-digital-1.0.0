package me.dio.academia.digital.controller;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import me.dio.academia.digital.entity.dto.form.MatriculaForm;
import me.dio.academia.digital.entity.dto.view.MatriculaView;
import me.dio.academia.digital.service.IMatriculaService;

@RestController
@RequestMapping("/matriculas")
public class MatriculaController {

  private IMatriculaService matriculaService;

  @Autowired
  public MatriculaController(IMatriculaService matriculaService){
    this.matriculaService = matriculaService;
  }

  @PostMapping
  public ResponseEntity<MatriculaView> create(@RequestBody MatriculaForm form){
    MatriculaView matricula = matriculaService.create(form);

    return ResponseEntity
      .created(URI.create("/matriculas/" + matricula.getId()))
      .body(matricula);
  }

  @GetMapping
  public ResponseEntity<List<MatriculaView>> getAll(){
    return ResponseEntity.ok(matriculaService.getAll());
  }

  @GetMapping("/{id}")
  public ResponseEntity<MatriculaView> get(@PathVariable Long id){
    return ResponseEntity.of(matriculaService.get(id));
  }

  @DeleteMapping("/{id}")
  public void delete(@PathVariable Long id){
    matriculaService.delete(id);
  }
}
