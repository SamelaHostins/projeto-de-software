package projeto.software.domain.entities;

import jakarta.persistence.*;
import java.util.UUID;

@Entity
@Table(name = "administrador", schema = "projeto")
public class Administrador {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID idAdministrador;

    @OneToOne
    @JoinColumn(name = "id_usuario", nullable = false, unique = true)
    private Usuario usuario;
}
