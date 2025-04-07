package projeto.software.application.services.impl;

import java.util.List;
import java.util.UUID;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.NotFoundException;
import projeto.software.application.dtos.dtosVagaEmprego.BuscarVagaEmpregoDTO;
import projeto.software.application.dtos.dtosVagaEmprego.CriarVagaEmpregoDTO;
import projeto.software.application.dtos.dtosVagaEmprego.VagaEmpregoDTO;
import projeto.software.application.mappers.UsuarioMapper;
import projeto.software.application.mappers.VagaEmpregoMapper;
import projeto.software.application.services.interfaces.VagaEmpregoService;
import projeto.software.domain.entities.Empresa;
import projeto.software.domain.entities.VagaEmprego;
import projeto.software.infra.repositories.EmpresaRepository;
import projeto.software.infra.repositories.VagaEmpregoRepository;

@ApplicationScoped
public class VagaEmpregoServiceImpl implements VagaEmpregoService {

    @Inject
    VagaEmpregoMapper vagaEmpregoMapper;

    @Inject
    UsuarioMapper usuarioMapper;

    @Inject
    VagaEmpregoRepository vagaEmpregoRepository;

    @Inject
    EmpresaRepository empresaRepository;

    public List<VagaEmpregoDTO> listarVagas() {
        List<VagaEmprego> vagas = vagaEmpregoRepository.listAll();
        return vagaEmpregoMapper.toDTOList(vagas);
    }

    @Transactional
    public void criarVaga(CriarVagaEmpregoDTO dto) {
        VagaEmprego vaga = vagaEmpregoMapper.toEntity(dto);
        Empresa empresa = empresaRepository.findById(dto.getIdEmpresa());
        if (empresa == null)
            throw new NotFoundException("Empresa não encontrada");

        vaga.setEmpresa(empresa);
        vagaEmpregoRepository.persist(vaga);
    }

    @Transactional
    public void excluirVaga(UUID idVaga) {
        VagaEmprego vaga = vagaEmpregoRepository.findById(idVaga);
        if (vaga == null)
            throw new NotFoundException("Vaga não encontrada");
        vagaEmpregoRepository.delete(vaga);
    }

    public BuscarVagaEmpregoDTO buscarVagaComUsuarios(UUID idVaga) {
        VagaEmprego vaga = vagaEmpregoRepository.findById(idVaga);
        if (vaga == null)
            throw new NotFoundException("Vaga não encontrada");

        BuscarVagaEmpregoDTO dto = vagaEmpregoMapper.toBuscarDTO(vaga);
        dto.setUsuarios(usuarioMapper.toUsuarioDTOList(vaga.getUsuarios()));
        return dto;
    }

}
