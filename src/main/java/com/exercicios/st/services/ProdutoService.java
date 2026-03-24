package com.exercicios.st.services;

import com.exercicios.st.models.ProdutoModel;
import com.exercicios.st.repositories.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProdutoService {

    @Autowired
    private ProdutoRepository produtoRepository;

    //lista os produtos
    public List<ProdutoModel> findAll(){
        return produtoRepository.findAll();
    }

    //criar os produtos
    public ProdutoModel criarProduto(ProdutoModel produtoModel){
        return produtoRepository.save(produtoModel);
    }

    //deletar os produtos
    public void deletarProduto(Long id){
        produtoRepository.deleteById(id);
    }

    //metodo para buscar estudantes pelo id
    public ProdutoModel buscarProduto(Long id){
        return produtoRepository.findById(id).get();
    }

}