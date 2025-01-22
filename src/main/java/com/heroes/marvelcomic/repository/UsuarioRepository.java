package com.heroes.marvelcomic.repository;


import com.heroes.marvelcomic.entity.UsuarioEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<UsuarioEntity, Long> {
    boolean existsByIdentificacion(String identificacion);
    boolean existsByCorreo(String correo);
}
