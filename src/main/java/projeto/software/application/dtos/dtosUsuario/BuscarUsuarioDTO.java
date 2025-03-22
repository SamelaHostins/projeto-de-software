package projeto.software.application.dtos.dtosUsuario;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import projeto.software.application.dtos.dtosVagaEmprego.VagaEmpregoDTO;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
// Classe para que o cliente possa ver seu cadastro
public class BuscarUsuarioDTO {

    private UUID idUsuario;
    private String nome;
    private String sobrenome;
    private LocalDate dataNascimento;
    private String email;
    private String telefone;
    private String loginUsuario;
    private String historico;
    private String qualificacoes;
    private String experiencia;
    private int disponibilidade;
    private List<VagaEmpregoDTO> vagasInscritas;
}
