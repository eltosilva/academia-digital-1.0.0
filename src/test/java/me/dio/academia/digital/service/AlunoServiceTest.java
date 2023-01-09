package me.dio.academia.digital.service;

import me.dio.academia.digital.entity.Aluno;
import me.dio.academia.digital.entity.dto.form.AlunoForm;
import me.dio.academia.digital.repository.AlunoRepository;
import me.dio.academia.digital.service.impl.AlunoServiceImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.*;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;

@ExtendWith(MockitoExtension.class)
public class AlunoServiceTest {

    @Spy
    private AlunoRepository alunoRepository;

    @Captor
    private ArgumentCaptor<Aluno> captor;

    @InjectMocks
    private AlunoServiceImpl alunoService;

    @Test
    public void procedureCreateEstaRepassandoOsDadosCorretosParaORepository(){

        AlunoForm alunoForm = new AlunoForm();
        alunoForm.setNome("Elto");
        alunoForm.setCpf("1234");
        alunoForm.setBairro("Carajas");
        alunoForm.setDataDeNascimento(LocalDate.of(1984, 10, 20));

        Aluno alunoExpect = new Aluno();
        alunoExpect.setNome("Elto");
        alunoExpect.setCpf("1234");
        alunoExpect.setBairro("Carajas");
        alunoExpect.setDataDeNascimento(LocalDate.of(1984, 10, 20));

        alunoService.create(alunoForm);

        Mockito.verify(alunoRepository).save(captor.capture());
        Aluno alunoParametro = captor.getValue();

        Assertions.assertEquals(alunoExpect, alunoParametro);
    }
}
