package me.dio.academia.digital.service.impl;

import me.dio.academia.digital.entity.Aluno;
import me.dio.academia.digital.entity.dto.form.AlunoForm;
import me.dio.academia.digital.entity.dto.form.AlunoUpdateForm;
import me.dio.academia.digital.entity.dto.view.AlunoView;
import me.dio.academia.digital.repository.AlunoRepository;
import me.dio.academia.digital.service.IAlunoService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AlunoServiceImpl implements IAlunoService {

    AlunoRepository alunoRepository;

    @Autowired
    public AlunoServiceImpl(AlunoRepository alunoRepository){
        this.alunoRepository = alunoRepository;
    }
    @Override
    public AlunoView create(AlunoForm form) {
        ModelMapper modelMapper = new ModelMapper();
        Aluno aluno = modelMapper.map(form, Aluno.class);

        aluno = alunoRepository.save(aluno);
        return modelMapper.map(aluno, AlunoView.class);
    }

    @Override
    public Aluno get(Long id) {
        Optional<Aluno> optionalAluno = alunoRepository.findById(id);
        if (optionalAluno.isEmpty())
            throw new EmptyResultDataAccessException(1);

        return optionalAluno.get();
    }

    @Override
    public List<Aluno> getAll() {
        return alunoRepository.findAll();
    }

    @Override
    public Aluno update(Long id, AlunoUpdateForm formUpdate) {
        Aluno aluno = get(id);

        if (!formUpdate.getNome().isEmpty())
            aluno.setNome(formUpdate.getNome());
        if(!formUpdate.getBairro().isEmpty())
            aluno.setBairro(formUpdate.getBairro());
        if (formUpdate.getDataDeNascimento() != null)
            aluno.setDataDeNascimento(formUpdate.getDataDeNascimento());

        return alunoRepository.save(aluno);
    }

    @Override
    public void delete(Long id) {
        alunoRepository.delete(get(id));
    }
}
