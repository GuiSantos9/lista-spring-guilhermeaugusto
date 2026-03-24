package com.exercicios.st.services;

import com.exercicios.st.models.DepartamentoModel;
import com.exercicios.st.repositories.DepartamentoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DepartamentoService {

    @Autowired
    private DepartamentoRepository departamentoRepository;

    //listar departamentos
    public List<DepartamentoModel> findAll(){
        return departamentoRepository.findAll();
    }

    //criar departamento
    public DepartamentoModel criarDepartamento(DepartamentoModel departamentoModel){
        return departamentoRepository.save(departamentoModel);
    }

    //deletar departamento por id
    public void deletarDepartamento(Long id){
        departamentoRepository.deleteById(id);
    }

    //buscar por id
    public DepartamentoModel buscarDepartamento(Long id){
        return departamentoRepository.findById(id).get();
    }

}
