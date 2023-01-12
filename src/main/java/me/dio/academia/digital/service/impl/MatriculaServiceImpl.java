package me.dio.academia.digital.service.impl;

import me.dio.academia.digital.entity.Aluno;
import me.dio.academia.digital.entity.Matricula;
import me.dio.academia.digital.entity.dto.form.MatriculaForm;
import me.dio.academia.digital.entity.dto.view.MatriculaView;
import me.dio.academia.digital.repository.AlunoRepository;
import me.dio.academia.digital.repository.MatriculaRepository;
import me.dio.academia.digital.service.IMatriculaService;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MatriculaServiceImpl implements IMatriculaService {

    private MatriculaRepository matriculaRepository;
    private AlunoRepository alunoRepository;
    private ModelMapper modelMapper;

    @Autowired
    public MatriculaServiceImpl(MatriculaRepository matriculaRepository, AlunoRepository alunoRepository){
        this.matriculaRepository = matriculaRepository;
        this.alunoRepository = alunoRepository;

        modelMapper = new ModelMapper();
    }

    @Override
    public MatriculaView create(MatriculaForm form) {
        Optional<Aluno> aluno = alunoRepository.findById(form.getAlunoId());
        Matricula matricula = new Matricula(null, aluno.orElseThrow(), LocalDateTime.now());
        
        return modelMapper.map(matriculaRepository.save(matricula), MatriculaView.class);
    }

    @Override
    public Optional<MatriculaView> get(Long id) {
        Optional<Matricula> optionalMatricula = matriculaRepository.findById(id);
        
        return optionalMatricula.map(matricula -> modelMapper.map(matricula, MatriculaView.class));
    }

    @Override
    public List<MatriculaView> getAll() {
        List<Matricula> matriculas = matriculaRepository.findAll();

        return matriculas.stream()
            .map(matricula -> modelMapper.map(matriculas, MatriculaView.class))
            .collect(Collectors.toList());
    }

    @Override
    public void delete(Long id) {
        matriculaRepository.deleteById(id);
    }
}
