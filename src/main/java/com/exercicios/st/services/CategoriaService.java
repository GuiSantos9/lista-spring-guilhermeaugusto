package com.exercicios.st.services;

import com.exercicios.st.models.CategoriaModel;
import com.exercicios.st.repositories.CategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoriaService {

    @Autowired
    private CategoriaRepository categoriaRepository;

    //lista as categorias
    public List<CategoriaModel> findAll(){
        return categoriaRepository.findAll();
    }

    //cria uma categoria
    public CategoriaModel criarCategoria(CategoriaModel categoriaModel){
        return categoriaRepository.save(categoriaModel);
    }

    //deleta categoria por id
    public void deletarCategoria(Long id){
        categoriaRepository.deleteById(id);
    }

    //busca categorias por id
    public CategoriaModel buscarCategoria(Long id){
        return categoriaRepository.findById(id).get();
    }

}
