package me.dio.academia.digital.entity.dto.view;

import java.time.LocalDateTime;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class AvaliacaoFisicaView {
  private Long id;

  private AlunoView aluno;

  private LocalDateTime dataDaAvaliacao = LocalDateTime.now();

  private double peso;

  private double altura;
}
