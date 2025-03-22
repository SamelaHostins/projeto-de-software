package projeto.software.application.dtos.dtosVagaEmprego;

import java.util.List;
import java.util.UUID;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import projeto.software.application.dtos.dtosUsuario.BuscarUsuarioDTO;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class BuscarVagaEmpregoDTO {

    private UUID idVaga;
    private String titulo;
    private String descricao;
    private String requisitos;
    private UUID idEmpresa;
    private List<BuscarUsuarioDTO> usuarios;
}
