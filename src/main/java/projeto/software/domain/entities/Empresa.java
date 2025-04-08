package projeto.software.domain.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

import java.util.UUID;

@Entity
@Table(name = "empresa", schema = "projeto")
@NoArgsConstructor // Construtor vazio (necessário para JPA)
@AllArgsConstructor // Construtor com todos os atributos
public class Empresa {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_empresa")
    private @Getter @Setter UUID idEmpresa;

    @Column(nullable = false, length = 255)
    private @Getter @Setter String nome;

    @Column(length = 255)
    private @Getter @Setter String setor;

    @Column(length = 500)
    private @Getter @Setter String descricao;
}
