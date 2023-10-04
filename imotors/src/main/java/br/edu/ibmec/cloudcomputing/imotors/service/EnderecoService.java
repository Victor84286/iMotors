package br.edu.ibmec.cloudcomputing.imotors.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import br.edu.ibmec.cloudcomputing.imotors.model.Endereco;
import br.edu.ibmec.cloudcomputing.imotors.model.Usuario;
import br.edu.ibmec.cloudcomputing.imotors.repository.EnderecoRepository;

@Service
public class EnderecoService {
    @Autowired
    EnderecoRepository enderecoRepository;

    @Autowired
    UsuarioService usuarioService;

    public List<Endereco> findAll() {
        return this.enderecoRepository.findAll();
    }

    public Optional<Endereco> findById(long id) {
        return this.enderecoRepository.findById(id);
    }

    public Endereco create(long idusuario, Endereco newEndereco) throws Exception {
        Optional<Usuario> opUsuario = this.usuarioService.findById(idusuario);

        if (opUsuario.isPresent() == false) {
            throw new Exception("Não encontrei a usuario para adicionar o endereço");
        }

        Usuario usuario = opUsuario.get();
        usuario.addEndereco(newEndereco);
        this.usuarioService.saveEndereco(usuario);

        Endereco result = usuario.getEnderecos().get(usuario.getEnderecos().size() - 1);
        return result;
    }

    public Endereco update(long id, Endereco newData) throws Exception {
        Optional<Endereco> existingItemOptional = enderecoRepository.findById(id);

        if (existingItemOptional.isPresent() == false)
            throw new Exception("Não encontrei o endereco a ser atualizado");

        Endereco existingItem = existingItemOptional.get();

        existingItem.setLogradouro(newData.getLogradouro());
        existingItem.setCep(newData.getCep());
        existingItem.setCidade(newData.getCidade());
        existingItem.setComplemento(newData.getComplemento());
        existingItem.setEstado(newData.getEstado());

        enderecoRepository.save(existingItem);
        return existingItem;
    }

    public void delete(long id) throws Exception {
        Optional<Endereco> endereco = this.enderecoRepository.findById(id);

        if (endereco.isPresent() == false)
            throw new Exception("Não encontrei o endereco a ser atualizado");

        this.enderecoRepository.delete(endereco.get());
    }

}
