package br.com.ibmec.cloud.demoapi.demoapi.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.ibmec.cloud.demoapi.demoapi.model.Usuario;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

   Optional<Usuario> findByEmailAndSenha(String email, String senha);

}
