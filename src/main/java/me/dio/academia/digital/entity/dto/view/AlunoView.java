package me.dio.academia.digital.entity.dto.view;

import lombok.Data;
import lombok.NoArgsConstructor;
import me.dio.academia.digital.entity.AvaliacaoFisica;

import java.time.LocalDate;
import java.util.List;

@Data
@NoArgsConstructor
public class AlunoView {

    private Long id;

    private String nome;

    private String cpf;

    private String bairro;
    private LocalDate dataDeNascimento;
}
