package projeto.software.application.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class CriarPerfilDTO {

    private UUID idUsuario;
    private String historico;
    private String qualificacoes;
    private String experiencia;
}