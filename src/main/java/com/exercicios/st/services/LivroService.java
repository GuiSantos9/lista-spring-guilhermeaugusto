package com.exercicios.st.services;

import com.exercicios.st.models.LivroModel;
import com.exercicios.st.repositories.LivroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LivroService {

    @Autowired
    private LivroRepository livroRepository;

    //metodo para listar livros
    public List<LivroModel> findAll(){
        return livroRepository.findAll();
    }

    //metodo para criar livros
    public LivroModel criarLivro(LivroModel livroModel){
        return livroRepository.save(livroModel);
    }

    //metodo para deletar livros
    public void deletarLivro(Long id){
        livroRepository.deleteById(id);
    }

    //metodo para buscar livros pelo id
    public LivroModel buscarLivro(Long id){
        return livroRepository.findById(id).get();
    }


}