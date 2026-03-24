package com.exercicios.st.controllers;

import com.exercicios.st.models.ClienteModel;
import com.exercicios.st.models.FornecedorModel;
import com.exercicios.st.services.FornecedorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/fornecedores")
public class FornecedorController {

    @Autowired
    private FornecedorService fornecedorService;

    //POST
    @PostMapping
    public ResponseEntity<FornecedorModel> criarFornecedor(@RequestBody FornecedorModel fornecedorModel){
        FornecedorModel request = fornecedorService.criarFornecedor(fornecedorModel);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequestUri()
                .path("/{id}").
                buildAndExpand(request.getId()).toUri();
        return ResponseEntity.created(uri).body(request);
    }

    //GET
    @GetMapping
    public ResponseEntity<List<FornecedorModel>> findAll(){
        List<FornecedorModel> list = fornecedorService.findAll();
        return ResponseEntity.ok().body(list);
    }

    //GET {id}
    @GetMapping("/{id}")
    public FornecedorModel buscarFornecedor(@PathVariable Long id){
        return fornecedorService.buscarFornecedor(id);
    }

    //DELETE {id}
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deletarFornecedor(@PathVariable Long id){
        fornecedorService.deletarFornecedor(id) ;
        return ResponseEntity.noContent().build();
    }

}
