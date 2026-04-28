package Dreystudy.cadastro_usuario.dto.request;

import jakarta.validation.constraints.NotBlank;

public record UsuarioRequestDTO(
        @NotBlank
        String email,
        @NotBlank
        String nome,
        @NotBlank
        String celular
) {
}