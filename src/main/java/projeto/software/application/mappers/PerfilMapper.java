package projeto.software.application.mappers;

import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;

import jakarta.inject.Named;
import projeto.software.application.dtos.CriarPerfilDTO;
import projeto.software.domain.entities.Perfil;

@Mapper(componentModel = "cdi")
public interface PerfilMapper {

    @Named("fromEntityToDto")
    CriarPerfilDTO fromEntityToDto(Perfil entity);

    @InheritInverseConfiguration
    Perfil fromDtoToEntity(CriarPerfilDTO dto);

}