package me.dio.academia.digital.service.impl;

import me.dio.academia.digital.entity.Aluno;
import me.dio.academia.digital.entity.dto.form.AlunoForm;
import me.dio.academia.digital.entity.dto.form.AlunoUpdateForm;
import me.dio.academia.digital.entity.dto.view.AlunoView;
import me.dio.academia.digital.repository.AlunoRepository;
import me.dio.academia.digital.service.IAlunoService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class AlunoServiceImpl implements IAlunoService {

    private AlunoRepository alunoRepository;
    private ModelMapper modelMapper;

    @Autowired
    public AlunoServiceImpl(AlunoRepository alunoRepository){
        this.alunoRepository = alunoRepository;
        modelMapper = new ModelMapper();
    }

    @Override
    public AlunoView create(AlunoForm form) {
        Aluno aluno = modelMapper.map(form, Aluno.class);

        return modelMapper.map(alunoRepository.save(aluno), AlunoView.class);
    }

    @Override
    public AlunoView get(Long id) {
        return modelMapper.map(find(id), AlunoView.class);
    }

    private Aluno find(Long id){
        Optional<Aluno> optionalAluno = alunoRepository.findById(id);
        
        return optionalAluno.orElseThrow();
    }

    @Override
    public List<AlunoView> getAll() {
        List<Aluno> alunos = alunoRepository.findAll();

        return alunos.stream()
            .map(aluno -> modelMapper.map(aluno, AlunoView.class))
            .collect(Collectors.toList());
    }

    @Override
    public AlunoView update(Long id, AlunoUpdateForm formUpdate) {
        Aluno aluno = find(id);

        if (formUpdate.getNome() != null)
            aluno.setNome(formUpdate.getNome());
        if(formUpdate.getBairro() != null)
            aluno.setBairro(formUpdate.getBairro());
        if (formUpdate.getDataDeNascimento() != null)
            aluno.setDataDeNascimento(formUpdate.getDataDeNascimento());

        return modelMapper.map(alunoRepository.save(aluno), AlunoView.class);
    }

    @Override
    public void delete(Long id) {
        alunoRepository.delete(find(id));
    }
}
