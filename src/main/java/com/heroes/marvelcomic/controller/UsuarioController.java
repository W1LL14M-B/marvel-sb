package com.heroes.marvelcomic.controller;


import com.heroes.marvelcomic.entity.UsuarioEntity;
import com.heroes.marvelcomic.service.UsuarioService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;



/* @CrossOrigin(origins = "http://localhost:5173")*/

@CrossOrigin(origins = "http://localhost:5173", methods = {RequestMethod.GET, RequestMethod.POST})
@RestController
@RequestMapping("/api/usuarios")
public class UsuarioController {
@Autowired
private UsuarioService usuarioService;

@PostMapping
public ResponseEntity<UsuarioEntity> registrarUsuario(@Valid @RequestBody UsuarioEntity usuario) {
    UsuarioEntity nuevoUsuario = usuarioService.registrarUsuario(usuario);
    return ResponseEntity.ok(nuevoUsuario);
}

@GetMapping("/{id}")
public ResponseEntity<UsuarioEntity> obtenerUsuarioPorId(@PathVariable Long id) {
    return usuarioService.obtenerUsuarioPorId(id)
            .map(ResponseEntity::ok)
            .orElse(ResponseEntity.notFound().build());
 }

@GetMapping
public ResponseEntity<?> obtenerTodosLosUsuarios() {
    return ResponseEntity.ok(usuarioService.obtenerTodosLosUsuarios());
}
}



