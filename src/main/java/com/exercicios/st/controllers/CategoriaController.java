package com.exercicios.st.controllers;

import com.exercicios.st.models.CategoriaModel;
import com.exercicios.st.services.CategoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/categorias")
public class CategoriaController {

    @Autowired
    private CategoriaService categoriaService;

    //POST
    @PostMapping
    public ResponseEntity<CategoriaModel> criarCategoria(@RequestBody CategoriaModel categoriaModel){
        CategoriaModel request = categoriaService.criarCategoria(categoriaModel);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequestUri()
                .path("/{id}").
                buildAndExpand(request.getId()).toUri();
        return ResponseEntity.created(uri).body(request);
    }

    //GET
    @GetMapping
    public ResponseEntity<List<CategoriaModel>> findAll(){
        List<CategoriaModel> list = categoriaService.findAll();
        return ResponseEntity.ok().body(list);
    }

    //GET {id}
    @GetMapping("/{id}")
    public CategoriaModel buscarCategoria(@PathVariable Long id){
        return categoriaService.buscarCategoria(id);
    }

    //DELETE {id}
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deletarCategoria(@PathVariable Long id){
        categoriaService.deletarCategoria(id) ;
        return ResponseEntity.noContent().build();
    }

}
