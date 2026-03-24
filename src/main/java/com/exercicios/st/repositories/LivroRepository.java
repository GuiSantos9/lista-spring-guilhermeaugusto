package com.exercicios.st.repositories;

import com.exercise.st.models.LivroModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LivroRepository extends JpaRepository<LivroModel,Long> {
}