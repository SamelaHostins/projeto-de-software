package projeto.software.domain.entities;

import jakarta.persistence.*;
import java.util.UUID;
import java.time.LocalDate;

@Entity
@Table(name = "curso", schema = "projeto")
public class Curso {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID idCurso;

    @Column(name = "dt_publicacao", nullable = false)
    private LocalDate dataPublicacao;

    @Column(nullable = false, length = 500)
    private String descricao;

    @Column(nullable = false, length = 255)
    private String titulo;

    @Column(name = "url_imagem_capa", length = 500)
    private String urlImagemCapa;

    @Column(length = 255)
    private String requisitos;

    @Column(name = "vagas_disponiveis", nullable = false)
    private Integer vagasDisponiveis;
}
