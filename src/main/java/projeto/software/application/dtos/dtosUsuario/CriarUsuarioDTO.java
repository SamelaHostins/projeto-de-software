package projeto.software.application.dtos.dtosUsuario;

import java.time.LocalDate;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import projeto.software.application.dtos.dtosVagaEmprego.VagaEmpregoDTO;

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
    private String historico;
    private String qualificacoes;
    private String experiencia;
    private int disponibilidade;
    private List<VagaEmpregoDTO> vagasInscritas; 

    public void UsuarioDTO(String nome, String sobrenome, LocalDate dataNascimento, 
                      String email, String telefone, String loginUsuario, String historico, 
                      String qualificacoes, String experiencia, int disponibilidade, List<VagaEmpregoDTO> vagasInscritas) {
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.dataNascimento = dataNascimento;
        this.email = email;
        this.telefone = telefone;
        this.loginUsuario = loginUsuario;
        this.historico = historico;
        this.qualificacoes = qualificacoes;
        this.experiencia = experiencia;
        this.disponibilidade = disponibilidade;
        this.vagasInscritas = vagasInscritas;
    }

}
