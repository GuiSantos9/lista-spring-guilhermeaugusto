package com.exercicios.st.services;

import com.exercicios.st.models.PedidoModel;
import com.exercicios.st.repositories.PedidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PedidosService {

    @Autowired
    private PedidoRepository pedidoRepository;

    //criar novo pedido
    public PedidoModel criarPedido(PedidoModel pedidoModel){
        return pedidoRepository.save(pedidoModel);
    }

    //listar todos os pedidos
    public List<PedidoModel> findAll(){
        return pedidoRepository.findAll();
    }

    //buscar pedidos por id
    public PedidoModel buscarPorId(Long id){
        return pedidoRepository.findById(id).get();
    }

    //deletar pedidos por id
    public void deletarPedido(Long id){
        pedidoRepository.deleteById(id);
    }

}
