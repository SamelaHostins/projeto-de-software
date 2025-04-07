package projeto.software.infra.repositories;

import java.util.UUID;

import io.quarkus.hibernate.orm.panache.PanacheRepositoryBase;
import projeto.software.domain.entities.VagaEmprego;

public interface VagaEmpregoRepository extends PanacheRepositoryBase<VagaEmprego, UUID> {
    
}
