package projeto.software.application.mappers;

import java.util.List;

import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.IterableMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Named;

import projeto.software.application.dtos.dtosUsuario.BuscarUsuarioDTO;
import projeto.software.application.dtos.dtosUsuario.CriarUsuarioDTO;
import projeto.software.domain.entities.Usuario;

@Mapper(componentModel = "cdi")
public interface UsuarioMapper {

    @Named("fromDtoToEntity")
    Usuario fromDtoToEntity(CriarUsuarioDTO dto);

    @InheritInverseConfiguration
    CriarUsuarioDTO fromEntityToDto(Usuario entity);

    Usuario fromDtoBuscarToEntity(BuscarUsuarioDTO dto);

    @InheritInverseConfiguration
    BuscarUsuarioDTO fromEntityToDtoBuscar(Usuario entity);

    List<BuscarUsuarioDTO> toUsuarioDTOList(List<Usuario> usuarios);

    @IterableMapping(qualifiedByName = "fromDtoToEntity")
    @Named("fromDtoListToEntityList")
    List<Usuario> fromDtoListToEntityList(List<CriarUsuarioDTO> dtos);
}
