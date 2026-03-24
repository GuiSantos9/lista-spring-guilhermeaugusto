package com.exercicios.st.controllers;

import com.exercicios.st.models.ProdutoModel;
import com.exercicios.st.services.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/produtos")
public class ProdutoController {

    @Autowired
    private ProdutoService produtoService;

    //cria dados
    @PostMapping
    public ResponseEntity<ProdutoModel> criarProduto(@RequestBody ProdutoModel produtoModel){
        ProdutoModel requeste = produtoService.criarProduto(produtoModel);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequestUri()
                .path("/{id}").
                buildAndExpand(requeste.getId()).toUri();
        return ResponseEntity.created(uri).body(requeste);
    }

    //lista os dados
    @GetMapping
    public ResponseEntity<List<ProdutoModel>> findAll(){
        List<ProdutoModel> list =produtoService.findAll();
        return ResponseEntity.ok().body(list);
    }

    //busca os dados
    @GetMapping("/{id}")
    public ProdutoModel buscarPorid(@PathVariable Long id){
        return produtoService.buscarProduto(id);
    }

    //deleta os dados
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deletarProduto(@PathVariable Long id){
        produtoService.deletarProduto(id);
        return ResponseEntity.noContent().build();
    }

}
