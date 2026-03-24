package com.exercicios.st.controllers;

import com.exercicios.st.models.ProdutoModel;
import com.exercicios.st.models.ProjetoModel;
import com.exercicios.st.services.ProjetoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/projetos")
public class ProjetoController {

    @Autowired
    private ProjetoService projetoService;

    //cria dados
    @PostMapping
    public ResponseEntity<ProjetoModel> criarProjeto(@RequestBody ProjetoModel projetoModel){
        ProjetoModel requeste = projetoService.criarProjeto(projetoModel);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequestUri()
                .path("/{id}").
                buildAndExpand(requeste.getId()).toUri();
        return ResponseEntity.created(uri).body(requeste);
    }

    //lista os dados
    @GetMapping
    public ResponseEntity<List<ProjetoModel>> findAll(){
        List<ProjetoModel> list =projetoService.findAll();
        return ResponseEntity.ok().body(list);
    }

    //busca os dados
    @GetMapping("/{id}")
    public ProjetoModel buscarProjeto(@PathVariable Long id){
        return projetoService.buscarProjeto(id);
    }

    //deleta os dados
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deletarProjeto(@PathVariable Long id){
        projetoService.deletarProjeto(id);
        return ResponseEntity.noContent().build();
    }


}
