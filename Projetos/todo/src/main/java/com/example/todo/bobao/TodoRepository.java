package com.example.todo.bobao;

import org.springframework.data.jpa.repository.JpaRepository;

public interface TodoRepository extends JpaRepository<TodoEntity, Integer> {
    boolean existsByDescricao(String mensagem);
}
