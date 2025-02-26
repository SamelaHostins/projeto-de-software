package projeto.software.domain.entities;

import jakarta.persistence.*;
import java.util.UUID;

@Entity
@Table(name = "empresa", schema = "projeto")
public class Empresa {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID idEmpresa;

    @Column(nullable = false, length = 255)
    private String nome;

    @Column(length = 255)
    private String setor;

    @Column(length = 500)
    private String descricao;
}

