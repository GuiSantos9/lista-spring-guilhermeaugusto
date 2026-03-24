package com.exercicios.st.controllers;

import com.exercicios.st.models.LivroModel;
import com.exercicios.st.services.LivroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/livros")
public class LivroController {

    @Autowired
    private LivroService livroService;

    //POST
    @PostMapping
    public ResponseEntity<LivroModel> criarLivro(@RequestBody LivroModel livroModel){
        LivroModel request = livroService.criarLivro(livroModel);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequestUri()
                .path("/{id}").
                buildAndExpand(request.getId()).toUri();
        return ResponseEntity.created(uri).body(request);
    }

    //GET
    @GetMapping
    public ResponseEntity<List<LivroModel>> findAll(){
        List<LivroModel> list = livroService.findAll();
        return ResponseEntity.ok().body(list);
    }

    //GET {id}
    @GetMapping("/{id}")
    public LivroModel buscarPorId(@PathVariable Long id){
        return livroService.buscarLivro(id);
    }

    //DELETE {id}
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deletarLivro(@PathVariable Long id){
        livroService.deletarLivro(id);
        return ResponseEntity.noContent().build();
    }

}