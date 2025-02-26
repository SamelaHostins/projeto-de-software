package projeto.software.application.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class CriarCursoDTO {

    private LocalDate dataPublicacao;
    private String descricao;
    private String titulo;
    private String urlImagemCapa;
    private String requisitos;
    private Integer vagasDisponiveis;
}

