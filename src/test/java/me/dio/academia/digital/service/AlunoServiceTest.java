package me.dio.academia.digital.service;

import me.dio.academia.digital.entity.Aluno;
import me.dio.academia.digital.entity.dto.form.AlunoForm;
import me.dio.academia.digital.entity.dto.form.AlunoUpdateForm;
import me.dio.academia.digital.factory.AlunoStubs;
import me.dio.academia.digital.repository.AlunoRepository;
import me.dio.academia.digital.service.impl.AlunoServiceImpl;

import java.util.Optional;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.*;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class AlunoServiceTest {

    private static AlunoRepository alunoRepository;
    private static IAlunoService alunoService;
    
    @Captor
    private ArgumentCaptor<Aluno> captor;

    @BeforeAll
    public static void init(){
        alunoRepository = Mockito.spy(AlunoRepository.class);
        alunoService = new AlunoServiceImpl(alunoRepository);

        Mockito.when(alunoRepository.save(Mockito.any(Aluno.class))).thenReturn(new Aluno());
        Mockito.when(alunoRepository.findById(Long.valueOf(1L))).thenReturn(Optional.of(AlunoStubs.createAlunoEntityWithId()));
    }

    @Test
    public void procedureCreateEstaRepassandoOsDadosCorretosParaORepository(){

        AlunoForm alunoForm = AlunoStubs.createAlunoForm();
        Aluno alunoExpect = AlunoStubs.createAlunoEntity();

        alunoService.create(alunoForm);

        Mockito.verify(alunoRepository).save(captor.capture());
        Aluno alunoParametro = captor.getValue();

        Assertions.assertEquals(alunoExpect, alunoParametro);
    }

    @Test
    public void procedureUpdateEstaRepassandoOsDadosParaORepository(){
        
        AlunoUpdateForm alunoUpdateForm = AlunoStubs.createAlunoUpdateForm();
        Aluno alunoExpect = AlunoStubs.createAlunoEntityAfterUpdate();

        alunoService.update(Long.valueOf(1L), alunoUpdateForm);

        Mockito.verify(alunoRepository).save(captor.capture());
        Aluno alunoParametro = captor.getValue();

        Assertions.assertEquals(alunoExpect, alunoParametro);
    }
}
