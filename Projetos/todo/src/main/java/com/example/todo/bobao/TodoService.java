package com.example.todo.bobao;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Optional;

@Service
public class TodoService {

    private final TodoRepository todoRepository;
    private final TodoValidation todoValidation;


    public TodoService(TodoRepository todoRepository, TodoValidation todoValidation) {
        this.todoRepository = todoRepository;
        this.todoValidation = todoValidation;
    }

    public TodoEntity salvar(@RequestBody TodoEntity todo){
        todoValidation.validarDescricao(todo);
        return todoRepository.save(todo);
    }

    public TodoEntity atualizar(@RequestBody TodoEntity todo,
                       Integer id){
        if (buscarPorId(id).isEmpty()){
            idInexistente();
        }
        todoValidation.validarDescricao(todo);
        todo.setId(id);
        return todoRepository.save(todo);
    }

    public Optional<TodoEntity> buscarPorId(Integer id){
        return todoRepository.findById(id);
    }

    public void deletar(Integer id){
        if(buscarPorId(id).isPresent()){
            todoRepository.deleteById(id);
        }else{
            idInexistente();
        }
    }

    public List<TodoEntity> listar(){
        return todoRepository.findAll();
    }

    private void idInexistente(){
        throw new RuntimeException("Id inexistente!");
    }
}
