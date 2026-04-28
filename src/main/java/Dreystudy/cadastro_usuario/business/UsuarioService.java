package Dreystudy.cadastro_usuario.business;


import Dreystudy.cadastro_usuario.dto.request.UsuarioRequestDTO;
import Dreystudy.cadastro_usuario.dto.response.UsuarioResponseDTO;
import Dreystudy.cadastro_usuario.infrastructure.entitys.Usuario;
import Dreystudy.cadastro_usuario.infrastructure.repository.UsuarioRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class UsuarioService {

    private final UsuarioRepository repository;

    @Transactional
    public UsuarioResponseDTO salvarUsuario(UsuarioRequestDTO usuarioRequestDTO){

        if (repository.existsByEmail(usuarioRequestDTO.email())){
            throw new RuntimeException("Já existe um registro com esse email:" + usuarioRequestDTO.email());
        }

        Usuario usuario = new Usuario();
        usuario.setEmail(usuarioRequestDTO.email());
        usuario.setNome(usuarioRequestDTO.nome());
        usuario.setCelular(usuarioRequestDTO.celular());

        repository.save(usuario);

        return new UsuarioResponseDTO(
                usuario.getId(),
                usuario.getEmail(),
                usuario.getNome(),
                usuario.getCelular());

    }

    public UsuarioResponseDTO buscarUsuarioPorEmail(String email){

        Usuario usuario =  repository.findByEmail(email).orElseThrow(
                () -> new RuntimeException("Email não encontrado!"));

        return new UsuarioResponseDTO(
                usuario.getId(),
                usuario.getEmail(),
                usuario.getNome(),
                usuario.getCelular()
        );
    }

    @Transactional
    public void deletarUsuarioPorEmail(String email){

        Usuario usuario = repository.findByEmail(email)
                .orElseThrow(() -> new RuntimeException("Usuário não encontrado com o e-mail"));

        repository.delete(usuario);
    }

    @Transactional
    public UsuarioResponseDTO atualizarUsuarioPorEmail(String email, UsuarioRequestDTO usuarioRequestDTO){

        Usuario usuarioEntity = repository.findByEmail(email).orElseThrow(() -> new RuntimeException("Email não encontrado!"));
        usuarioEntity.atualizarDados(usuarioRequestDTO);

        return new UsuarioResponseDTO(
                usuarioEntity.getId(),
                usuarioEntity.getEmail(),
                usuarioEntity.getNome(),
                usuarioEntity.getCelular());
    }
}
