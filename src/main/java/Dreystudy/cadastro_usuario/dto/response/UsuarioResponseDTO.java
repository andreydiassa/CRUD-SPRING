package Dreystudy.cadastro_usuario.dto.response;

public record UsuarioResponseDTO(
        Long id,
        String email,
        String nome,
        String celular
) {
}