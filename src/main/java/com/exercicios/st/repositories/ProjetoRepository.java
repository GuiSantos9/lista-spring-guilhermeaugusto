package com.exercicios.st.repositories;

import com.exercicios.st.models.ProjetoModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProjetoRepository extends JpaRepository<ProjetoModel, Long> {
}
