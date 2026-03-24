package com.exercicios.st.controllers;

import com.exercicios.st.models.PedidoModel;
import com.exercicios.st.services.PedidosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

//refere-se a classe de controladores
@RestController
@RequestMapping("/pedidos")
public class PedidoController {

    @Autowired
    private PedidosService pedidosService;

    //POST
    @PostMapping
    public ResponseEntity<PedidoModel> criarPedido(@RequestBody PedidoModel pedidoModel){
        PedidoModel request = pedidosService.criarPedido(pedidoModel);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequestUri()
                .path("/{id}").
                buildAndExpand(request.getId()).toUri();
        return ResponseEntity.created(uri).body(request);
    }

    //GET
    @GetMapping
    public ResponseEntity<List<PedidoModel>> findAll(){
        List<PedidoModel> list = pedidosService.findAll();
        return ResponseEntity.ok().body(list);
    }

    //GET by ID
    @GetMapping("/{id}")
    public PedidoModel buscarPorId(@PathVariable Long id){
        return pedidosService.buscarPorId(id);
    }

    //DELETE by ID
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deletarPedido(@PathVariable Long id){
        pedidosService.deletarPedido(id);
        return ResponseEntity.noContent().build();
    }

}