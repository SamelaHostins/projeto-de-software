package projeto.software.domain.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.UUID;
import java.time.LocalDate;

@Entity
@Table(name = "usuario", schema = "projeto")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID idUsuario;

    @Column(nullable = false, length = 25)
    private String nome;

    @Column(nullable = false, length = 25)
    private String sobrenome;

    @Column(name = "data_nascimento", nullable = false)
    private LocalDate dataNascimento;

    @Column(nullable = false, unique = true, length = 30)
    private String email;

    @Column(nullable = false, unique = true, length = 12)
    private String telefone;

    @Column(name = "login_usuario", nullable = false, unique = true, length = 25)
    private String loginUsuario;

    @Column(nullable = false, length = 8)
    private String senha;

    @Column(length = 500)
    private String historico;

    @Column(length = 500)
    private String qualificacoes;

    @Column(nullable = false, length = 500)
    private String experiencia;

    @Column(nullable = false)
    private int disponibilidade;

    // armazena as vagas nas quais o usuário está inscrito.
    @ManyToMany
    @JoinTable(name = "inscricao_vaga", schema = "projeto", joinColumns = @JoinColumn(name = "id_usuario"), inverseJoinColumns = @JoinColumn(name = "id_vaga"))
    private List<VagaEmprego> vagasInscritas;
}
