package Dreystudy.cadastro_usuario.infrastructure.entitys;

import Dreystudy.cadastro_usuario.dto.request.UsuarioRequestDTO;
import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table (name = "TB_USUARIO")
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "email", unique = true)
    private String email;

    @Column(name = "nome")
    private String nome;

    @Column(name = "celular")
    private String celular;

    public void atualizarDados(UsuarioRequestDTO usuarioRequestDTO){
        this.setEmail(usuarioRequestDTO.email());
        this.setNome(usuarioRequestDTO.nome());
        this.setCelular(usuarioRequestDTO.celular());
    }
}

