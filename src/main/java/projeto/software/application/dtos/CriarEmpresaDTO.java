package projeto.software.application.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class CriarEmpresaDTO {

    private String nome;
    private String setor;
    private String descricao;
}
