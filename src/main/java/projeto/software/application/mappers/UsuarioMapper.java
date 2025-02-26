package projeto.software.application.mappers;

import org.mapstruct.Mapping;
import org.mapstruct.Named;

import projeto.software.application.dtos.CriarUsuarioDTO;
import projeto.software.domain.entities.Usuario;

import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.IterableMapping;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "cdi")
public interface UsuarioMapper {

    @Named("fromDtoToEntity")
    Usuario fromDtoToEntity(CriarUsuarioDTO dto);

    @InheritInverseConfiguration
    CriarUsuarioDTO fromEntityToDto(Usuario entity);

    @IterableMapping(qualifiedByName = "fromDtoToEntity")
    @Named("fromDtoListToEntityList")
    List<Usuario> fromDtoListToEntityList(List<CriarUsuarioDTO> dtos);
}
