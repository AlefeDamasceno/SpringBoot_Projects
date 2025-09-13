package com.example.produtosapi.controller;

import com.example.produtosapi.model.Produto;
import com.example.produtosapi.repository.ProdutoRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("produtos")

public class ProdutoController {

    private final ProdutoRepository produtoRepository;

    public ProdutoController(ProdutoRepository produtoRepository) {
        this.produtoRepository = produtoRepository;
    }

    @PostMapping
    public Produto salvar(@RequestBody Produto produto){

        var id = UUID.randomUUID().toString();
        produto.setId(id);

        produtoRepository.save(produto);
        return produto;
    }

    @GetMapping("/{id}")
    public Produto buscarPorId(@PathVariable ("id") String id){
        return produtoRepository.findById(id).orElse(null);
    }

    @GetMapping("/nome/{nome}")
    public List<Produto> buscarPorNome(@PathVariable ("nome") String nome){
        return produtoRepository.findByNome(nome);
    }

    @DeleteMapping("/{id}")
    public void deletar(@PathVariable ("id") String id){
        produtoRepository.deleteById(id);
    }

    @PutMapping("/{id}")
    public Produto atualizar(@PathVariable ("id") String id,
                          @RequestBody Produto produto){
        if (buscarPorId(id) != null){
            produto.setId(id);
            return produtoRepository.save(produto);
        }
        return null;
    }
}
