package projeto.software.application.dtos;

import java.time.LocalDate;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class CriarUsuarioDTO {

    private String nome;
    private String sobrenome;
    private LocalDate dataNascimento;
    private String email;
    private String telefone;
    private String loginUsuario;
    private String senha;
    private Integer tipoUsuario;
}

