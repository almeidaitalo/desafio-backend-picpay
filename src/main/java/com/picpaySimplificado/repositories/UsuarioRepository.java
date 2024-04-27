package com.picpaySimplificado.repositories;

import com.picpaySimplificado.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface UsuarioRepository extends JpaRepository<Usuario,Long> {
    Optional<Usuario> findUsuarioByCpf(String Cpf);
    Optional<Usuario> findUsuarioByid(Long id);
}
