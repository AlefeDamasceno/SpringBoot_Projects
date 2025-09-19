package com.example.todo.bobao;

import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/todos")
public class TodoController {

    private final TodoService service;

    public TodoController(TodoService service) {
        this.service = service;
    }

    @PostMapping
    public TodoEntity salvar(@RequestBody TodoEntity todo){
        return service.salvar(todo);
    }

    @PostMapping("/{id}")
    public TodoEntity atualizar(@PathVariable("id") Integer id, @RequestBody TodoEntity todo){
        return service.atualizar(todo, id);
    }

    @GetMapping("/{id}")
    public Optional<TodoEntity> buscarPorId(@PathVariable("id")Integer id){
        return service.buscarPorId(id);
    }

    @DeleteMapping("/{id}")
    public void deletarPorId(@PathVariable("id")Integer id){
        service.deletar(id);
    }

    @GetMapping
    public List<TodoEntity> listarTarefas(){
        return service.listar();
    }
}
