package com.example.todos.oi;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TodoService{

    private final TodoRepository todoRepository;

    public TodoService(TodoRepository todoRepository) {
        this.todoRepository = todoRepository;
    }

    public TodoEntity salvar(TodoEntity todo){
        return todoRepository.save(todo);
    }

    public void atualizar(TodoEntity todo){
        todoRepository.save(todo);
    }

    public List<TodoEntity> listar(){
        return todoRepository.findAll();
    }
}
