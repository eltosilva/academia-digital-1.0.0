package me.dio.academia.digital.service.impl;

import me.dio.academia.digital.entity.Aluno;
import me.dio.academia.digital.entity.AvaliacaoFisica;
import me.dio.academia.digital.entity.dto.form.AvaliacaoFisicaForm;
import me.dio.academia.digital.entity.dto.form.AvaliacaoFisicaUpdateForm;
import me.dio.academia.digital.entity.dto.view.AvaliacaoFisicaView;
import me.dio.academia.digital.repository.AlunoRepository;
import me.dio.academia.digital.repository.AvaliacaoFisicaRepository;
import me.dio.academia.digital.service.IAvaliacaoFisicaService;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class AvaliacaoFisicaServiceImpl implements IAvaliacaoFisicaService {

    AvaliacaoFisicaRepository avaliacaoFisicaRepository;
    AlunoRepository alunoRepository;
    ModelMapper modelMapper;

    @Autowired
    public AvaliacaoFisicaServiceImpl(AvaliacaoFisicaRepository avaliacaoFisicaRepository, AlunoRepository alunoRepository) {
        this.avaliacaoFisicaRepository = avaliacaoFisicaRepository;
        this.alunoRepository = alunoRepository;
        modelMapper = new ModelMapper();
    }

    @Override
    public AvaliacaoFisicaView create(AvaliacaoFisicaForm form) {
        AvaliacaoFisica avaliacaoFisica = new AvaliacaoFisica();
        Optional<Aluno> aluno = alunoRepository.findById(form.getAlunoId());

        avaliacaoFisica.setAluno(aluno.orElseThrow());
        avaliacaoFisica.setPeso(form.getPeso());
        avaliacaoFisica.setAltura(form.getAltura());

        avaliacaoFisica = avaliacaoFisicaRepository.save(avaliacaoFisica);

        return modelMapper.map(avaliacaoFisica, AvaliacaoFisicaView.class);
    }

    @Override
    public AvaliacaoFisicaView get(Long id) {
        return modelMapper.map(findById(id), AvaliacaoFisicaView.class);
    }

    private AvaliacaoFisica findById(Long id){
        Optional<AvaliacaoFisica> optional = avaliacaoFisicaRepository.findById(id);
        return optional.orElseThrow();
    }

    @Override
    public List<AvaliacaoFisicaView> getAll() {
        List<AvaliacaoFisica> avaliacoes = avaliacaoFisicaRepository.findAll();
        
        return avaliacoes.stream()
            .map(avaliacao -> modelMapper.map(avaliacao, AvaliacaoFisicaView.class))
            .collect(Collectors.toList());
    }

    @Override
    public AvaliacaoFisicaView update(Long id, AvaliacaoFisicaUpdateForm formUpdate) {
        AvaliacaoFisica avaliacao = findById(id);

        if(formUpdate.getAltura() != null)
            avaliacao.setAltura(formUpdate.getAltura());
        if(formUpdate.getPeso() != null)
            avaliacao.setPeso(formUpdate.getPeso());

        avaliacao = avaliacaoFisicaRepository.save(avaliacao);
        return modelMapper.map(avaliacao, AvaliacaoFisicaView.class);
    }

    @Override
    public void delete(Long id) {
        avaliacaoFisicaRepository.deleteById(id);
    }
}
