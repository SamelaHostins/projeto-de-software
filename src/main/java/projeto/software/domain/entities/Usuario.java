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
@AllArgsConstructor
@NoArgsConstructor
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_usuario")
    private @Getter @Setter UUID idUsuario;

    @Column(nullable = false, length = 25)
    private  @Getter @Setter String nome;

    @Column(nullable = false, length = 25)
    private  @Getter @Setter String sobrenome;

    @Column(name = "data_nascimento", nullable = false)
    private @Getter @Setter LocalDate dataNascimento;

    @Column(nullable = false, unique = true, length = 30)
    private  @Getter @Setter String email;

    @Column(nullable = false, unique = true, length = 12)
    private  @Getter @Setter String telefone;

    @Column(name = "login_usuario", nullable = false, unique = true, length = 25)
    private  @Getter @Setter String loginUsuario;

    @Column(nullable = false, length = 8)
    private  @Getter @Setter String senha;

    @Column(length = 500)
    private  @Getter @Setter String historico;

    @Column(length = 500)
    private  @Getter @Setter String qualificacoes;

    @Column(nullable = false, length = 500)
    private  @Getter @Setter String experiencia;

    @Column(nullable = false)
    private @Getter @Setter int disponibilidade;

    // armazena as vagas nas quais o usuário está inscrito.
    @ManyToMany
    @JoinTable(name = "inscricao_vaga", schema = "projeto", joinColumns = @JoinColumn(name = "id_usuario"), inverseJoinColumns = @JoinColumn(name = "id_vaga"))
    private @Getter @Setter List<VagaEmprego> vagasInscritas;
}
