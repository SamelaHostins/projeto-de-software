package projeto.software.application.services.interfaces;

import java.util.List;
import java.util.UUID;

import projeto.software.application.dtos.dtosVagaEmprego.BuscarVagaEmpregoDTO;
import projeto.software.application.dtos.dtosVagaEmprego.CriarVagaEmpregoDTO;
import projeto.software.application.dtos.dtosVagaEmprego.VagaEmpregoDTO;

public interface VagaEmpregoService {

    List<VagaEmpregoDTO> listarVagas();

    void criarVaga(CriarVagaEmpregoDTO dto);

    void excluirVaga(UUID idVaga);

    BuscarVagaEmpregoDTO buscarVagaComUsuarios(UUID idVaga);
}
