package com.exercicios.st.services;

import com.exercicios.st.models.ProjetoModel;
import com.exercicios.st.repositories.ProjetoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProjetoService {

    @Autowired
    private ProjetoRepository projetoRepository;

    //listar
    public List<ProjetoModel> findAll(){
        return projetoRepository.findAll();
    }

    //criar
    public ProjetoModel criarProjeto(ProjetoModel projetoModel){
        return projetoRepository.save(projetoModel);
    }

    //deletar pelo id
    public void deletarProjeto(Long id){
        projetoRepository.deleteById(id);
    }

    //buscar pelo id
    public ProjetoModel buscarProjeto(Long id){
        return projetoRepository.findById(id).get();
    }

}
