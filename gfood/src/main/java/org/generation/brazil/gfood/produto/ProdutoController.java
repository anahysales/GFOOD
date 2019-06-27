package org.generation.brazil.gfood.produto;

import org.generation.brazil.gfood.cliente.Cliente;
import org.generation.brazil.gfood.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

    @RestController
    public class ProdutoController {

        @Autowired
        private ProdutoRepository repository;


        @GetMapping("/produtos")
        public List<Produto> findAll (){
            return repository.findAll();

        }

        @ResponseStatus(HttpStatus.CREATED)
        @PostMapping("/produtos")
        public Produto save(@RequestBody Produto produto){

            System.out.println("Nome:" + produto.getNome());
            System.out.println("Descrição:" + produto.getDescricao());

            return repository.save(produto);
        }

        @PutMapping("/produtos/{id}")
        public Produto update (@PathVariable Long id, @RequestBody Produto produto)
                throws ResourceNotFoundException {

            return repository.findById(id).map(c -> {
                c.setNome(produto.getNome());
                c.setDescricao(produto.getDescricao());
                return repository.save(c);
            }).orElseThrow(() ->
                    new ResourceNotFoundException("Não existe um produto cadastrado com o id: " + id));
        }

        @DeleteMapping("/produtos/{id}")
        public void delete(@PathVariable Long id) {
            repository.deleteById(id);
        }


    }


