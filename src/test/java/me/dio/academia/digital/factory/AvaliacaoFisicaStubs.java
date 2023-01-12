package me.dio.academia.digital.factory;

import java.time.LocalDateTime;

import me.dio.academia.digital.entity.Aluno;
import me.dio.academia.digital.entity.AvaliacaoFisica;
import me.dio.academia.digital.entity.dto.form.AvaliacaoFisicaForm;
import me.dio.academia.digital.entity.dto.form.AvaliacaoFisicaUpdateForm;

public class AvaliacaoFisicaStubs {
  
  private static final Long id = Long.valueOf(1L);
  private static final Double altura = Double.valueOf(1.68);
  private static final Double peso = Double.valueOf(97.1);
  private static final Double pesoUpdate = Double.valueOf(96.3);
  private static final Aluno aluno = AlunoStubs.createAlunoEntityWithId();
  private static final LocalDateTime dataDaAvaliacao = LocalDateTime.of(2023, 1, 11, 12, 27, 0);

  public static AvaliacaoFisica createAvaliacaoFisicaEntity(){    
    return new AvaliacaoFisica(null, aluno, dataDaAvaliacao, peso, altura);
  }

  public static AvaliacaoFisica createAvaliacaoFisicaEntityWithId(){
    return new AvaliacaoFisica(id, aluno, dataDaAvaliacao, peso, altura);
  }

  public static AvaliacaoFisica createAvaliacaoFisicaEntityAfterUpdate(){    
    return new AvaliacaoFisica(id, aluno, dataDaAvaliacao, pesoUpdate, altura);
  }

  public static AvaliacaoFisicaForm createAvaliacaoFisicaForm(){
    return new AvaliacaoFisicaForm(aluno.getId(), peso, altura);
  }

  public static AvaliacaoFisicaUpdateForm createAvaliacaoFisicaUpdateForm(){
    AvaliacaoFisicaUpdateForm avaliacaoFisicaUpdateForm = new AvaliacaoFisicaUpdateForm();
    avaliacaoFisicaUpdateForm.setPeso(pesoUpdate);

    return avaliacaoFisicaUpdateForm;
  }
}
