package projeto.software.domain.entities;

import jakarta.persistence.*;
import java.util.UUID;
import java.time.LocalDate;

@Entity
@Table(name = "usuario", schema = "projeto")
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
}
