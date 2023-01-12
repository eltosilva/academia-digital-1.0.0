package me.dio.academia.digital.service;

import me.dio.academia.digital.entity.AvaliacaoFisica;
import me.dio.academia.digital.entity.dto.form.AvaliacaoFisicaForm;
import me.dio.academia.digital.entity.dto.form.AvaliacaoFisicaUpdateForm;
import me.dio.academia.digital.entity.dto.view.AvaliacaoFisicaView;

import java.util.List;
import java.util.Optional;

public interface IAvaliacaoFisicaService {
  /**
   * Cria uma Avaliação Física e salva no banco de dados.
   * @param form - formulário referente aos dados para criação da Avaliação Física no banco de dados.
   * @return - Avaliação Física recém-criada.
   */
  AvaliacaoFisicaView create(AvaliacaoFisicaForm form);

  /**
   * Retorna uma Avaliação Física que está no banco de dados de acordo com seu Id.
   * @param id - id da Avaliação Física que será exibida.
   * @return - Avaliação Física de acordo com o Id fornecido.
   */
  Optional<AvaliacaoFisicaView> get(Long id);

  /**
   * Retorna todas as Avaliações Física que estão no banco de dados.
   * @return - Uma lista com todas as Avaliações Física que estão salvas no DB.
   */
  List<AvaliacaoFisicaView> getAll();

  /**
   * Atualiza a avaliação física.
   * @param id - id da Avaliação Física que será atualizada.
   * @param formUpdate - formulário referente aos dados necessários para atualização da Avaliação
   * Física no banco de dados.
   * @return - Avaliação Física recém-atualizada.
   */
  AvaliacaoFisicaView update(Long id, AvaliacaoFisicaUpdateForm formUpdate);

  /**
   * Deleta uma Avaliação Física específica.
   * @param id - id da Avaliação Física que será removida.
   */
  void delete(Long id);
}
