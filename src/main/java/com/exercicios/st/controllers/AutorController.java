package com.exercicios.st.controllers;

import com.exercicios.st.models.AutorModel;
import com.exercicios.st.services.AutorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/autores")
public class AutorController {

    @Autowired
    private AutorService autorService;

    //POST
    @PostMapping
    public ResponseEntity<AutorModel> criarAutor(@RequestBody AutorModel autorModel){
        AutorModel request = autorService.criarAutor(autorModel);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequestUri()
                .path("/{id}").
                buildAndExpand(request.getId()).toUri();
        return ResponseEntity.created(uri).body(request);
    }
    //GET
    @GetMapping
    public ResponseEntity<List<AutorModel>> findAll(){
        List<AutorModel> list = autorService.findAll();
        return ResponseEntity.ok().body(list);
    }
    //GET {id}
    @GetMapping("/{id}")
    public AutorModel buscarPorId(@PathVariable Long id){
        return autorService.buscarPorId(id);
    }

    //DELETE {id}
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deletarAutor(@PathVariable Long id){
        autorService.deletarAutor(id);
        return ResponseEntity.noContent().build();
    }

    }