package projeto.software.application.mappers;

import org.mapstruct.*;

import projeto.software.application.dtos.CriarCursoDTO;
import projeto.software.domain.entities.Curso;

import java.util.List;

@Mapper(componentModel = "cdi")
public interface CursoMapper {

    @Named("fromEntityToDto")
    CriarCursoDTO fromEntityToDto(Curso entity);

    @InheritInverseConfiguration
    Curso fromDtoToEntity(CriarCursoDTO dto);

    @IterableMapping(qualifiedByName = "fromEntityToDto")
    @Named("fromEntityListToDtoList")
    List<CriarCursoDTO> fromEntityListToDtoList(List<Curso> cursos);
}
