package projeto.software.application.dtos.dtosVagaEmprego;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class CriarVagaEmpregoDTO {

    private String titulo;
    private String descricao;
    private String requisitos;
    private UUID idEmpresa;
}

