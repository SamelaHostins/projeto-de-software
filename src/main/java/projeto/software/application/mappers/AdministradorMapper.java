package projeto.software.application.mappers;

import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;

import jakarta.inject.Named;
import projeto.software.application.dtos.CriarAdministradorDTO;
import projeto.software.domain.entities.Administrador;

@Mapper(componentModel = "cdi")
public interface AdministradorMapper {

    @Named("fromEntityToDto")
    CriarAdministradorDTO fromEntityToDto(Administrador entity);

    @InheritInverseConfiguration
    Administrador fromDtoToEntity(CriarAdministradorDTO dto);
}
