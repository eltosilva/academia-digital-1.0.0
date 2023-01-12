package me.dio.academia.digital.factory;

import java.time.LocalDate;

import me.dio.academia.digital.entity.Aluno;
import me.dio.academia.digital.entity.dto.form.AlunoForm;
import me.dio.academia.digital.entity.dto.form.AlunoUpdateForm;

public class AlunoStubs {
  private static final Long id = Long.valueOf(1L);
  private static final String nome = "Elto";
  private static final String cpf = "111.222.333-44";
  private static final String bairro = "Carajas";
  private static final String bairroUpdate = "Liberdade";
  private static final LocalDate dataNascimento = LocalDate.of(1984, 10, 20);

  public static Aluno createAlunoEntity() {    
    return new Aluno(null, nome, cpf, bairro, dataNascimento, null);
  }

  public static Aluno createAlunoEntityWithId() {    
    return new Aluno(id, nome, cpf, bairro, dataNascimento, null);
  }

  public static Aluno createAlunoEntityAfterUpdate(){
    return new Aluno(id, nome, cpf, bairroUpdate, dataNascimento, null);
  }

  public static AlunoForm createAlunoForm(){
    return new AlunoForm(nome, cpf, bairro, dataNascimento);
  }

  public static AlunoUpdateForm createAlunoUpdateForm(){
    AlunoUpdateForm aluno = new AlunoUpdateForm();
    aluno.setBairro(bairroUpdate);
    
    return aluno;
  }
}