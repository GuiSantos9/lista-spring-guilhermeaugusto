package com.exercicios.st.controllers;

import com.exercicios.st.models.AutorModel;
import com.exercicios.st.models.DepartamentoModel;
import com.exercicios.st.services.DepartamentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/departamentos")
public class DepartamentoController {

    @Autowired
    private DepartamentoService departamentoService;

    //POST
    @PostMapping
    public ResponseEntity<DepartamentoModel> criarDepartamento(@RequestBody DepartamentoModel departamentoModel){
        DepartamentoModel request = departamentoService.criarDepartamento(departamentoModel);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequestUri()
                .path("/{id}").
                buildAndExpand(request.getId()).toUri();
        return ResponseEntity.created(uri).body(request);
    }
    //GET
    @GetMapping
    public ResponseEntity<List<DepartamentoModel>> findAll(){
        List<DepartamentoModel> list = departamentoService.findAll();
        return ResponseEntity.ok().body(list);
    }
    //GET {id}
    @GetMapping("/{id}")
    public DepartamentoModel buscarDepartamento(@PathVariable Long id){
        return departamentoService.buscarDepartamento(id);
    }

    //DELETE {id}
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deletarDepartamento(@PathVariable Long id){
        departamentoService.deletarDepartamento(id);
        return ResponseEntity.noContent().build();
    }

}
