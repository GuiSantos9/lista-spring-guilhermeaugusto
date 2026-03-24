package com.exercicios.st.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class TarefaModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "Descrição")
    private String descricao;

    @Column(name = "DataDeVencimento")
    private LocalDate dataVencimento;

    @Column(name = "Concluida")
    private Boolean concluida;


}
