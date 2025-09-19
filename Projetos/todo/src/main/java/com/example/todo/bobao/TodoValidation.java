package com.example.todo.bobao;

import org.springframework.stereotype.Component;

@Component
public class TodoValidation {

    private final TodoRepository repository;

    public TodoValidation(TodoRepository todoRepository) {
        this.repository = todoRepository;
    }

    public void validarDescricao(TodoEntity todo){
        if (repository.existsByDescricao(todo.getDescricao())){
            throw new RuntimeException("Descriçao " +
                    "existente em outro Todo!");
        }
    }
}
