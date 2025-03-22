package projeto.software.application.dtos.dtosVagaEmprego;

import java.util.UUID;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class VagaEmpregoDTO {

    private UUID idVaga;
    private String titulo;
    private String descricao;
}
