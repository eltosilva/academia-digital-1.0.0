package me.dio.academia.digital.service;

import me.dio.academia.digital.entity.Aluno;
import me.dio.academia.digital.entity.dto.form.AlunoForm;
import me.dio.academia.digital.entity.dto.form.AlunoUpdateForm;
import me.dio.academia.digital.factory.dto.AlunoFormStub;
import me.dio.academia.digital.factory.entity.AlunoEntityStub;
import me.dio.academia.digital.repository.AlunoRepository;
import me.dio.academia.digital.service.impl.AlunoServiceImpl;

import java.util.Optional;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.*;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class AlunoServiceTest {

    @Spy
    private AlunoRepository alunoRepository;

    @InjectMocks
    private AlunoServiceImpl alunoService;
    
    @Captor
    private ArgumentCaptor<Aluno> captor;

    @BeforeEach
    public void init(){
        Mockito.when(alunoRepository.save(Mockito.any(Aluno.class))).thenReturn(AlunoEntityStub.factoryEntityAlunoCreate());
        Mockito.when(alunoRepository.findById(Long.valueOf(1L))).thenReturn(Optional.of(AlunoEntityStub.factoryEntityAlunoCreate()));
    }

    @Test
    public void procedureCreateEstaRepassandoOsDadosCorretosParaORepository(){

        AlunoForm alunoForm = AlunoFormStub.factoryAlunoForm();
        Aluno alunoExpect = AlunoEntityStub.factoryEntityAlunoCreate();

        alunoService.create(alunoForm);

        Mockito.verify(alunoRepository).save(captor.capture());
        Aluno alunoParametro = captor.getValue();

        Assertions.assertEquals(alunoExpect, alunoParametro);
    }

    @Test
    public void procedureUpdateEstaRepassandoOsDadosParaORepository(){
        
        AlunoUpdateForm alunoUpdateForm = AlunoFormStub.factoryAlunoUpdateForm();
        Aluno alunoExpect = AlunoEntityStub.factoryEntityAlunoUpdate();

        alunoService.update(Long.valueOf(1L), alunoUpdateForm);

        Mockito.verify(alunoRepository).save(captor.capture());
        Aluno alunoParametro = captor.getValue();

        Assertions.assertEquals(alunoExpect, alunoParametro);
    }
}
