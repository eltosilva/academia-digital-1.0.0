package me.dio.academia.digital.controller;

import me.dio.academia.digital.entity.AvaliacaoFisica;
import me.dio.academia.digital.entity.dto.form.AvaliacaoFisicaForm;
import me.dio.academia.digital.service.IAvaliacaoFisicaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.URI;

@RestController
@RequestMapping("/avaliacoes")
public class AvaliacaoFisicaController {

    private IAvaliacaoFisicaService afService;

    @Autowired
    public AvaliacaoFisicaController(IAvaliacaoFisicaService service){
        afService = service;
    }

    @PostMapping
    public ResponseEntity<AvaliacaoFisica> create(@RequestBody AvaliacaoFisicaForm avForm){
        return ResponseEntity.created(URI.create("")).body(afService.create(avForm));
    }

}
