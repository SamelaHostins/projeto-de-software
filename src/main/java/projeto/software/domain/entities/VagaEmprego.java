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
    @Column(name = "id_vaga")
    private @Getter @Setter UUID idVaga;

    @Column(nullable = false, length = 255)
    private @Getter @Setter String titulo;

    @Column(length = 500)
    private @Getter @Setter String descricao;

    @Column(length = 500)
    private @Getter @Setter String requisitos;

    @ManyToOne
    @JoinColumn(name = "id_empresa", nullable = false)
    private @Getter @Setter Empresa empresa;

    // Armazena os usuários inscritos na vaga
    @ManyToMany(mappedBy = "vagasInscritas")
    private @Getter @Setter List<Usuario> usuarios;
}
