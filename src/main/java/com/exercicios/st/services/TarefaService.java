package com.exercicios.st.services;

import com.exercicios.st.models.TarefaModel;
import com.exercicios.st.repositories.TarefaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TarefaService {

     @Autowired
    private TarefaRepository tarefaRepository;

     //listar
    public List<TarefaModel> findAll(){
        return tarefaRepository.findAll();
    }

    //criar
    public TarefaModel criarTarefa(TarefaModel tarefaModel){
        return tarefaRepository.save(tarefaModel);
    }

    //deletar pelo id
    public void deletarTarefa(Long id){
        tarefaRepository.deleteById(id);
    }

    //buscar pelo id
    public TarefaModel buscarTarefa(Long id){
        return tarefaRepository.findById(id).get();
    }
}
