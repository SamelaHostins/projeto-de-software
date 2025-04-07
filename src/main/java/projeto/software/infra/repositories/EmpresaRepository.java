package projeto.software.infra.repositories;

import java.util.UUID;

import io.quarkus.hibernate.orm.panache.PanacheRepositoryBase;
import projeto.software.domain.entities.Empresa;

public interface EmpresaRepository extends PanacheRepositoryBase<Empresa, UUID> {
    
}
