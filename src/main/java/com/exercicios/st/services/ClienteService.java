package com.exercicios.st.services;

import com.exercicios.st.models.ClienteModel;
import com.exercicios.st.repositories.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;

    //listar clientes
    public List<ClienteModel> findAll(){
        return clienteRepository.findAll();
    }

    //criar clientes
    public ClienteModel criarCliente(ClienteModel clienteModel){
        return clienteRepository.save(clienteModel);
    }

    //deleta clientes pelo id
    public void deletarCliente(Long id){
       clienteRepository.deleteById(id);
    }

    //busca clientes pelo id
    public ClienteModel buscarCliente(Long id){
        return clienteRepository.findById(id).get();
    }

}
