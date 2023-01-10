package me.dio.academia.digital.factory.entity;

import java.time.LocalDate;

import me.dio.academia.digital.entity.Aluno;

public class AlunoEntityStub {

  public static Aluno factoryEntityAlunoCreate() {
    Aluno aluno = new Aluno();
    aluno.setNome("Elto");
    aluno.setCpf("1234");
    aluno.setBairro("Carajas");
    aluno.setDataDeNascimento(LocalDate.of(1984, 10, 20));
    
    return aluno;
  }

  public static Aluno factoryEntityAlunoUpdate(){
    Aluno aluno = factoryEntityAlunoCreate();
    aluno.setBairro("Liberdade");

    return aluno;
  }
}