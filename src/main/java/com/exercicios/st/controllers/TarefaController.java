package com.exercicios.st.controllers;

import com.exercicios.st.models.ProjetoModel;
import com.exercicios.st.models.TarefaModel;
import com.exercicios.st.services.TarefaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/tarefas")
public class TarefaController {

    @Autowired
    private TarefaService tarefaService;

    //cria dados
    @PostMapping
    public ResponseEntity<TarefaModel> criarTarefa(@RequestBody TarefaModel tarefaModel){
        TarefaModel requeste = tarefaService.criarTarefa(tarefaModel);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequestUri()
                .path("/{id}").
                buildAndExpand(requeste.getId()).toUri();
        return ResponseEntity.created(uri).body(requeste);
    }

    //lista os dados
    @GetMapping
    public ResponseEntity<List<TarefaModel>> findAll(){
        List<TarefaModel> list =tarefaService.findAll();
        return ResponseEntity.ok().body(list);
    }

    //busca os dados
    @GetMapping("/{id}")
    public TarefaModel buscarTarefa(@PathVariable Long id){
        return tarefaService.buscarTarefa(id);
    }

    //deleta os dados
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deletarTarefa(@PathVariable Long id){
        tarefaService.deletarTarefa(id);
        return ResponseEntity.noContent().build();
    }

}
