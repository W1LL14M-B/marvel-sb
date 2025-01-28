package com.heroes.marvelcomic.service;


import com.heroes.marvelcomic.entity.UsuarioEntity;
import com.heroes.marvelcomic.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    public UsuarioEntity registrarUsuario(UsuarioEntity usuario) {
        if (usuarioRepository.existsByIdentificacion(usuario.getIdentificacion())) {
            throw new IllegalArgumentException("La identificación ya está registrada.");
        }
        if (usuarioRepository.existsByCorreo(usuario.getCorreo())) {
            throw new IllegalArgumentException("El correo ya está registrado.");
        }
        return usuarioRepository.save(usuario);
    }

    public Optional<UsuarioEntity> obtenerUsuarioPorId(Long id) {
        return usuarioRepository.findById(id);
    }
    
    public List<UsuarioEntity> obtenerTodosLosUsuarios() {
        return usuarioRepository.findAll();
    }
    
    public boolean validarCredenciales(String nombre, String identificacion) {
        return usuarioRepository.existsByNombreAndIdentificacion(nombre, identificacion);
    }
}
