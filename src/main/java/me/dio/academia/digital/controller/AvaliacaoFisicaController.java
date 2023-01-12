package me.dio.academia.digital.controller;

import me.dio.academia.digital.entity.dto.form.AvaliacaoFisicaForm;
import me.dio.academia.digital.entity.dto.view.AvaliacaoFisicaView;
import me.dio.academia.digital.service.IAvaliacaoFisicaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/avaliacoes")
public class AvaliacaoFisicaController {

    private IAvaliacaoFisicaService avaliacaoFisicaService;

    @Autowired
    public AvaliacaoFisicaController(IAvaliacaoFisicaService service){
        avaliacaoFisicaService = service;
    }

    @PostMapping
    public ResponseEntity<AvaliacaoFisicaView> create(@RequestBody AvaliacaoFisicaForm avForm){
        return ResponseEntity.created(URI.create("")).body(avaliacaoFisicaService.create(avForm));
    }

    @GetMapping("/{id}")
    public ResponseEntity<AvaliacaoFisicaView> get(@PathVariable Long id){
        return ResponseEntity.ok(avaliacaoFisicaService.get(id));
    }

    @GetMapping
    public ResponseEntity<List<AvaliacaoFisicaView>> getAll(){
        return ResponseEntity.ok(avaliacaoFisicaService.getAll());
    }

    @PatchMapping("/{id}")
    public ResponseEntity<AvaliacaoFisicaView> update(){
        return null;
    }

}
