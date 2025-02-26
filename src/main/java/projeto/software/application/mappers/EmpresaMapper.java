package projeto.software.application.mappers;

import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;

import jakarta.inject.Named;
import projeto.software.application.dtos.CriarEmpresaDTO;
import projeto.software.domain.entities.Empresa;

@Mapper(componentModel = "cdi")
public interface EmpresaMapper {

    @Named("fromEntityToDto")
    CriarEmpresaDTO fromEntityToDto(Empresa entity);

    @InheritInverseConfiguration
    Empresa fromDtoToEntity(CriarEmpresaDTO dto);

}