package projeto.software.domain.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

import java.util.UUID;

@Entity
@Table(name = "empresa", schema = "projeto")
@Getter
@Setter
@NoArgsConstructor // Construtor vazio (necessário para JPA)
@AllArgsConstructor // Construtor com todos os atributos
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
