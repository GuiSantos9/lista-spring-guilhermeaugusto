package com.exercicios.st.repositories;

import com.exercicios.st.models.PedidoModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PedidoRepository extends JpaRepository<PedidoModel, Long>{
}