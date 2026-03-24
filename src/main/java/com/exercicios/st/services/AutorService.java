package com.exercicios.st.services;

import com.exercicios.st.models.AutorModel;
import com.exercicios.st.repositories.AutorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AutorService {

    @Autowired
    private AutorRepository autorRepository;

    //listar autores
    public List<AutorModel> findAll(){
        return autorRepository.findAll();
    }
    //criar autores
    public AutorModel criarAutor(AutorModel autorModel){
        return autorRepository.save(autorModel);
    }
    //deletar autores por id
    public void deletarAutor(Long id){
        autorRepository.deleteById(id);
    }
    //buscar autores por id
    public AutorModel buscarPorId(Long id){
        return autorRepository.findById(id).get();
    }


}
