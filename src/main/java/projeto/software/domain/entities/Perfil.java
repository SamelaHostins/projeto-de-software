package projeto.software.domain.entities;

import jakarta.persistence.*;
import java.util.UUID;

@Entity
@Table(name = "perfil", schema = "projeto")
public class Perfil {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID idPerfil;

    @OneToOne
    @JoinColumn(name = "id_usuario", nullable = false, unique = true)
    private Usuario usuario;

    @Column(length = 500)
    private String historico;

    @Column(length = 500)
    private String qualificacoes;

    @Column(nullable = false, length = 500)
    private String experiencia;
}

