package Dreystudy.cadastro_usuario.controller;

import Dreystudy.cadastro_usuario.business.UsuarioService;
import Dreystudy.cadastro_usuario.infrastructure.entitys.Usuario;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.function.RequestPredicate;

import static org.springframework.data.jpa.domain.AbstractPersistable_.id;

@RestController
@RequestMapping("/usuario")
@RequiredArgsConstructor
public class UsuarioController {

    private final UsuarioService usuarioService;

    @PostMapping
    public ResponseEntity<Void> salvarUsuario(@RequestBody Usuario usuario){
       usuarioService.salvarUsuario(usuario);
        return ResponseEntity.ok().build();

    }

    @GetMapping
    public ResponseEntity<Usuario> buscarUsuarioPorEmail(@RequestParam String email){
        return ResponseEntity.ok(usuarioService.buscarUsuarioPorEmail(email));
    }

    @DeleteMapping
    public ResponseEntity<Void> deletarUsuarioPorEmail(@RequestParam String email){
        usuarioService.deletarUsuarioPorEmail(email);
        return ResponseEntity.ok().build();

    }

    @PutMapping
    public ResponseEntity<Void> atualizarUsuarioPorId(@RequestParam String email , @RequestBody Usuario usuario){
        usuarioService.atualizarUsuarioPorEmail(email, usuario);
        return ResponseEntity.ok().build();
    }

}
