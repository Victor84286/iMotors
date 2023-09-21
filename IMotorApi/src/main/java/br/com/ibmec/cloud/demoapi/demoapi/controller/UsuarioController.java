package br.com.ibmec.cloud.demoapi.demoapi.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.ibmec.cloud.demoapi.demoapi.model.Usuario;
import br.com.ibmec.cloud.demoapi.demoapi.repository.UsuarioRepository;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {

    @Autowired
    private UsuarioRepository UsuarioRepository;

    @GetMapping
    public ResponseEntity<List<Usuario>> getAll() {

        try {

            return new ResponseEntity<>(this.UsuarioRepository.findAll(), HttpStatus.OK);

        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping
    public ResponseEntity<Usuario> create(@RequestBody Usuario item) {
        try {

            Usuario result = this.UsuarioRepository.save(item);

            return new ResponseEntity<>(result, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.EXPECTATION_FAILED);
        }
    }

    @PostMapping(name = "login", path = "login")
    public ResponseEntity<Usuario> login(@RequestBody Usuario item) {
        try {
            Optional<Usuario> usuario = this.UsuarioRepository.findByEmailAndSenha(item.getEmail(), item.getSenha());

            if (usuario.isPresent() == false) {
                return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
            }

            return new ResponseEntity<>(usuario.get(), HttpStatus.OK);

        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.EXPECTATION_FAILED);
        }
    }

    @GetMapping("{id}")
    public ResponseEntity<Usuario> getById(@PathVariable("id") long id) {

        Optional<Usuario> result = this.UsuarioRepository.findById(id);

        if (result.isPresent()) {
            return new ResponseEntity<>(result.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("{id}")
    public ResponseEntity<Usuario> update(@PathVariable("id") long id, @RequestBody Usuario pessoaNovosDados) {

        Optional<Usuario> result = this.UsuarioRepository.findById(id);

        if (result.isPresent() == false) {
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }

        Usuario pessoaAtualizada = result.get();
        pessoaAtualizada.setNome(pessoaNovosDados.getNome());
        pessoaAtualizada.setCpf(pessoaNovosDados.getCpf());

        this.UsuarioRepository.save(pessoaAtualizada);

        return new ResponseEntity<>(pessoaAtualizada, HttpStatus.OK);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<HttpStatus> delete(@PathVariable("id") long id) {
        try {

            Optional<Usuario> pessoaASerExcluida = this.UsuarioRepository.findById(id);

            if (pessoaASerExcluida.isPresent() == false) {
                return new ResponseEntity(HttpStatus.NOT_FOUND);
            }

            this.UsuarioRepository.delete(pessoaASerExcluida.get());

            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.EXPECTATION_FAILED);
        }
    }

}