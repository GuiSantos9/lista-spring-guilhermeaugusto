package com.exercicios.st.models;

import jakarta.persistence.*;

import java.math.BigDecimal;

@Entity
@Table(name = "tb_produto")
public class ProdutoModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY )
    private Long id;

    @Column(name = "NomeDoProduto")
    private String nomeDoProduto;

    @Column(name = "Preco")
    private BigDecimal precoDoProtudo;

    @Column(name = "QuantidadeEmEstoque")
    private Integer estoque;

    public ProdutoModel(){}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNomeDoProduto() {
        return nomeDoProduto;
    }

    public void setNomeDoProduto(String nomeDoProduto) {
        this.nomeDoProduto = nomeDoProduto;
    }

    public BigDecimal getPrecoDoProtudo() {
        return precoDoProtudo;
    }

    public void setPrecoDoProtudo(BigDecimal precoDoProtudo) {
        this.precoDoProtudo = precoDoProtudo;
    }

    public Integer getEstoque() {
        return estoque;
    }

    public void setEstoque(Integer estoque) {
        this.estoque = estoque;
    }
}
