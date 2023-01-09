package me.dio.academia.digital.entity.form;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
public class AlunoForm {

  private String nome;

  private String cpf;

  private String bairro;

  private LocalDate dataDeNascimento;
}
