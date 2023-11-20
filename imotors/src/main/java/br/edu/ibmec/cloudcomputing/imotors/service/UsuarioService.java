package br.edu.ibmec.cloudcomputing.imotors.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import br.edu.ibmec.cloudcomputing.imotors.exception.BusinessException;
import br.edu.ibmec.cloudcomputing.imotors.model.Post;
import br.edu.ibmec.cloudcomputing.imotors.model.Usuario;
import br.edu.ibmec.cloudcomputing.imotors.repository.UsuarioRepository;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository _usuarioRepository;

    public List<Usuario> findAll() {
        return this._usuarioRepository.findAll();
    }

    public Optional<Usuario> findById(long id) {
        return this._usuarioRepository.findById(id);
    }

    public Usuario save(Usuario usuario) throws BusinessException {
        if (this._usuarioRepository.countByCpf(usuario.getCpf()) > 0) {
            throw new BusinessException("Este CPF já existe na base de dados");
        }
        this._usuarioRepository.save(usuario);
        return usuario;
    }

    public Usuario update(long id, Usuario newData) throws BusinessException {
        Optional<Usuario> result = this._usuarioRepository.findById(id);

        if (result.isPresent() == false) {
            throw new BusinessException("Não encontrei a usuario a ser atualizada");
        }

        Usuario pessoaASerAtualizada = result.get();
        pessoaASerAtualizada.setNome(newData.getNome());
        pessoaASerAtualizada.setCpf(newData.getCpf());
        this._usuarioRepository.save(pessoaASerAtualizada);
        return pessoaASerAtualizada;
    }

    public void delete(long id) throws BusinessException {
        Optional<Usuario> pessoaASerExcluida = this._usuarioRepository.findById(id);
        // Não achei a usuario a ser excluida
        if (pessoaASerExcluida.isPresent() == false) {
            throw new BusinessException("Não encontrei a usuario a ser atualizada");
        }
        this._usuarioRepository.delete(pessoaASerExcluida.get());
    }
}
