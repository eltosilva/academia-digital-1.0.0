package me.dio.academia.digital.factory.dto;

import java.time.LocalDate;

import me.dio.academia.digital.entity.dto.form.AlunoForm;
import me.dio.academia.digital.entity.dto.form.AlunoUpdateForm;

public class AlunoFormStub {

  public static AlunoForm factoryAlunoForm() {
    AlunoForm aluno = new AlunoForm();
    aluno.setNome("Elto");
    aluno.setCpf("1234");
    aluno.setBairro("Carajas");
    aluno.setDataDeNascimento(LocalDate.of(1984, 10, 20));

    return aluno;
  }

  public static AlunoUpdateForm factoryAlunoUpdateForm(){
    AlunoUpdateForm aluno = new AlunoUpdateForm();
    aluno.setBairro("Liberdade");

    return aluno;
  }
}
