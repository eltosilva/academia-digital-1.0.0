package me.dio.academia.digital.entity.dto.view;

import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDate;

@Data
@NoArgsConstructor
public class AlunoView {

    private Long id;

    private String nome;

    private String cpf;

    private String bairro;
    private LocalDate dataDeNascimento;
}
