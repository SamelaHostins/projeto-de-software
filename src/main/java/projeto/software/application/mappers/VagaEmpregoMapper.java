package projeto.software.application.mappers;

import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;

import jakarta.inject.Named;
import projeto.software.application.dtos.CriarVagaEmpregoDTO;
import projeto.software.domain.entities.VagaEmprego;

@Mapper(componentModel = "cdi")
public interface VagaEmpregoMapper {
    
    @Named("fromEntityToDto")
    CriarVagaEmpregoDTO fromEntityToDto(VagaEmprego entity);

    @InheritInverseConfiguration
    VagaEmprego fromDtoToEntity(CriarVagaEmpregoDTO dto);
}
