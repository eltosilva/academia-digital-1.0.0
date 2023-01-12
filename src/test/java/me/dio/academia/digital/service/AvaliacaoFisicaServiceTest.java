package me.dio.academia.digital.service;

import java.util.Optional;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import me.dio.academia.digital.entity.AvaliacaoFisica;
import me.dio.academia.digital.entity.dto.form.AvaliacaoFisicaForm;
import me.dio.academia.digital.entity.dto.form.AvaliacaoFisicaUpdateForm;
import me.dio.academia.digital.factory.AlunoStubs;
import me.dio.academia.digital.factory.AvaliacaoFisicaStubs;
import me.dio.academia.digital.repository.AlunoRepository;
import me.dio.academia.digital.repository.AvaliacaoFisicaRepository;
import me.dio.academia.digital.service.impl.AvaliacaoFisicaServiceImpl;

@ExtendWith(MockitoExtension.class)
public class AvaliacaoFisicaServiceTest {
  
  private static AvaliacaoFisicaRepository avaliacaoFisicaRepository;
  private static AlunoRepository alunoRepository;
  private static IAvaliacaoFisicaService avaliacaoFisicaService;

  @Captor
  private ArgumentCaptor<AvaliacaoFisica> captor;

  @BeforeAll  public static void init(){
    avaliacaoFisicaRepository = Mockito.spy(AvaliacaoFisicaRepository.class);
    alunoRepository = Mockito.mock(AlunoRepository.class);
    avaliacaoFisicaService = new AvaliacaoFisicaServiceImpl(avaliacaoFisicaRepository, alunoRepository);

    Mockito.when(avaliacaoFisicaRepository.save(Mockito.any(AvaliacaoFisica.class))).thenReturn(new AvaliacaoFisica());
    Mockito.when(avaliacaoFisicaRepository.findById(1L)).thenReturn(Optional.of(AvaliacaoFisicaStubs.createAvaliacaoFisicaEntityWithId()));
    Mockito.when(alunoRepository.findById(1L)).thenReturn(Optional.of(AlunoStubs.createAlunoEntityWithId()));
  }


  @Test
  public void procedureCreateEstaRepassandoOsDadosCorretosParaORepositorySave(){
    AvaliacaoFisicaForm avaliacaoFisicaForm = AvaliacaoFisicaStubs.createAvaliacaoFisicaForm();
    AvaliacaoFisica avaliacaoFisicaExpected = AvaliacaoFisicaStubs.createAvaliacaoFisicaEntity();
    

    avaliacaoFisicaService.create(avaliacaoFisicaForm);
    Mockito.verify(avaliacaoFisicaRepository).save(captor.capture());
    AvaliacaoFisica avaliacaoFisica = captor.getValue();

    Assertions.assertEquals(avaliacaoFisicaExpected.getPeso(), avaliacaoFisica.getPeso());
    Assertions.assertEquals(avaliacaoFisicaExpected.getAluno(), avaliacaoFisica.getAluno());
    Assertions.assertEquals(avaliacaoFisicaExpected.getAltura(), avaliacaoFisica.getAltura());
  }

  @Test
  public void procedureUpdateEstaRepassandoOsDadosCorretosParaORepositorySave(){
    AvaliacaoFisicaUpdateForm avaliacaoFisicaUpdateForm = AvaliacaoFisicaStubs.createAvaliacaoFisicaUpdateForm();
    AvaliacaoFisica avaliacaoFisicaExpected = AvaliacaoFisicaStubs.createAvaliacaoFisicaEntityAfterUpdate();

    avaliacaoFisicaService.update(Long.valueOf(1L), avaliacaoFisicaUpdateForm);
    Mockito.verify(avaliacaoFisicaRepository).save(captor.capture());
    AvaliacaoFisica avaliacaoFisica = captor.getValue();

    Assertions.assertEquals(avaliacaoFisicaExpected, avaliacaoFisica);
  }
}
