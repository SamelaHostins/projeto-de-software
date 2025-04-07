package projeto.software.application.mappers;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import projeto.software.application.dtos.dtosVagaEmprego.BuscarVagaEmpregoDTO;
import projeto.software.application.dtos.dtosVagaEmprego.CriarVagaEmpregoDTO;
import projeto.software.application.dtos.dtosVagaEmprego.VagaEmpregoDTO;
import projeto.software.domain.entities.VagaEmprego;

@Mapper(componentModel = "cdi")
public interface VagaEmpregoMapper {

    CriarVagaEmpregoDTO fromEntityToDto(VagaEmprego entity);

    @Mapping(target = "empresa", ignore = true)
    @Mapping(target = "usuarios", ignore = true)
    VagaEmprego toEntity(CriarVagaEmpregoDTO dto);

    @Mapping(source = "empresa.idEmpresa", target = "idEmpresa")
    BuscarVagaEmpregoDTO toBuscarDTO(VagaEmprego vaga);

    VagaEmpregoDTO toDTO(VagaEmprego vaga);

    List<VagaEmpregoDTO> toDTOList(List<VagaEmprego> vagas);
}
