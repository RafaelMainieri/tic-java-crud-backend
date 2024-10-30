package com.consuptiom.crud.controller;

import com.consuptiom.crud.models.PessoaModel;
import com.consuptiom.crud.repositories.PessoaRepository;
import lombok.AllArgsConstructor;
import org.apache.coyote.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController // diz pro spring q essa classe eh um controlador
@RequestMapping("/pessoas") // endereco para digitar na url para acessar a aplicação
@CrossOrigin("*") // para funcionar em qualquer navegador
@AllArgsConstructor
public class PessoaController {
    private PessoaRepository pessoaRepository;

    @GetMapping
    public ResponseEntity<List<PessoaModel>> pegaTodasAsPessoas() {
        // pega e mostra todas as pessoas
        return new ResponseEntity<>(pessoaRepository.findAll(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<PessoaModel> criaNovaPessoa(@RequestBody PessoaModel novaPessoa) {
        // cria uma nova pessoa
        novaPessoa.setId(null); // garantindo que a nova pessoa está sem ID para que o JPA entenda q eh pra criar uma nova
        return new ResponseEntity<>(pessoaRepository.save(novaPessoa), HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<PessoaModel> editaPessoa(@RequestBody PessoaModel novaPessoa) {
        // atualiza dados de uma pessoa
        return new ResponseEntity<>(pessoaRepository.save(novaPessoa), HttpStatus.OK);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Void> deletaPessoa(@PathVariable Integer id) {
        // remove uma pessoa por ID
        pessoaRepository.deleteById(id);

        return new ResponseEntity<>(HttpStatus.OK);
    }
}
