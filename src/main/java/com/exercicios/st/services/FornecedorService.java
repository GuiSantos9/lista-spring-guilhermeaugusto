package com.exercicios.st.services;

import com.exercicios.st.models.FornecedorModel;
import com.exercicios.st.repositories.FornecedorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FornecedorService {

    @Autowired
    private FornecedorRepository fornecedorRepository;

    //listar Fornecedor
    public List<FornecedorModel> findAll(){
        return fornecedorRepository.findAll();
    }

    //criar Fornecedor
    public FornecedorModel criarFornecedor(FornecedorModel fornecedorModel){
        return fornecedorRepository.save(fornecedorModel);
    }

    //deletar fornecedor por id
    public void deletarFornecedor(Long id){
        fornecedorRepository.deleteById(id);
    }

    //buscar fornecedor por id
    public FornecedorModel buscarFornecedor(Long id){
        return fornecedorRepository.findById(id).get();
    }

}
