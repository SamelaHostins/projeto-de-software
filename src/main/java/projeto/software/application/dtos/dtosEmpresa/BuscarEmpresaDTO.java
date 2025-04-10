package projeto.software.application.dtos.dtosEmpresa;

import java.util.UUID;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class BuscarEmpresaDTO {

    private UUID idEmpresa;
    private String nome;
    private String setor;
    private String descricao;
}
