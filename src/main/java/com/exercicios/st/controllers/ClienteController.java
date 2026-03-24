package com.exercicios.st.controllers;

import com.exercicios.st.models.CategoriaModel;
import com.exercicios.st.models.ClienteModel;
import com.exercicios.st.services.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/clientes")
public class ClienteController {

    @Autowired
    private ClienteService clienteService;

    //POST
    @PostMapping
    public ResponseEntity<ClienteModel> criarCliente(@RequestBody ClienteModel clienteModel){
        ClienteModel request = clienteService.criarCliente(clienteModel);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequestUri()
                .path("/{id}").
                buildAndExpand(request.getId()).toUri();
        return ResponseEntity.created(uri).body(request);
    }

    //GET
    @GetMapping
    public ResponseEntity<List<ClienteModel>> findAll(){
        List<ClienteModel> list = clienteService.findAll();
        return ResponseEntity.ok().body(list);
    }

    //GET {id}
    @GetMapping("/{id}")
    public ClienteModel buscarCliente(@PathVariable Long id){
        return clienteService.buscarCliente(id);
    }

    //DELETE {id}
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deletarCliente(@PathVariable Long id){
        clienteService.deletarCliente(id) ;
        return ResponseEntity.noContent().build();
    }

}
