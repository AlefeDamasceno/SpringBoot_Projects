package com.example.todos.oi;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/todos")
public class TodoController {

    private final TodoService service;

    public TodoController(TodoService service) {
        this.service = service;
    }

    @PostMapping
    public TodoEntity salvar(@RequestBody TodoEntity todo){
        return this.service.salvar(todo);
    }

    @PostMapping("/{id}")
    public void AtualizarPorId(@PathVariable("id") Integer id, @RequestBody TodoEntity todo){
        todo.setId(id);
        this.service.atualizar(todo);
    }

    @GetMapping
    public List<TodoEntity> listarTarefas(TodoEntity todo){
        return service.listar();
    }
}
