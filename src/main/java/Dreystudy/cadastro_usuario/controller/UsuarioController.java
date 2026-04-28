package Dreystudy.cadastro_usuario.controller;

import Dreystudy.cadastro_usuario.business.UsuarioService;
import Dreystudy.cadastro_usuario.dto.request.UsuarioRequestDTO;
import Dreystudy.cadastro_usuario.dto.response.UsuarioResponseDTO;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/usuario")
@RequiredArgsConstructor
public class UsuarioController {

    private final UsuarioService usuarioService;

    @PostMapping
    public ResponseEntity<UsuarioResponseDTO> salvarUsuario(@RequestBody @Valid  UsuarioRequestDTO usuarioRequestDTO){
        UsuarioResponseDTO usuarioCriado = usuarioService.salvarUsuario(usuarioRequestDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(usuarioCriado);

    }

    @GetMapping
    public ResponseEntity<UsuarioResponseDTO> buscarUsuarioPorEmail(@RequestParam String email){
        UsuarioResponseDTO usuarioResponseDTO = usuarioService.buscarUsuarioPorEmail(email);
        return ResponseEntity.ok(usuarioResponseDTO);
    }

    @DeleteMapping
    public ResponseEntity<Void> deletarUsuarioPorEmail(@RequestParam String email){
        usuarioService.deletarUsuarioPorEmail(email);
        return ResponseEntity.noContent().build();

    }

    @PutMapping
    public ResponseEntity<UsuarioResponseDTO> atualizarUsuarioPorId(@RequestParam String email , @RequestBody @Valid UsuarioRequestDTO usuarioRequestDTO){
        UsuarioResponseDTO usuarioResponseDTO = usuarioService.atualizarUsuarioPorEmail(email, usuarioRequestDTO);
        return ResponseEntity.ok(usuarioResponseDTO);
    }

}
