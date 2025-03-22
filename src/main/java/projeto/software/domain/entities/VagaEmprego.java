package projeto.software.domain.entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "vaga_emprego", schema = "projeto")
@Getter
@Setter
@NoArgsConstructor // Construtor vazio (necessário para JPA)
@AllArgsConstructor // Construtor com todos os atributos
public class VagaEmprego {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID idVaga;

    @Column(nullable = false, length = 255)
    private String titulo;

    @Column(length = 500)
    private String descricao;

    @Column(length = 500)
    private String requisitos;

    @ManyToOne
    @JoinColumn(name = "id_empresa", nullable = false)
    private Empresa empresa;

    // Armazena os usuários inscritos na vaga
    @ManyToMany(mappedBy = "vagasInscritas")
    private List<Usuario> usuarios;
}
