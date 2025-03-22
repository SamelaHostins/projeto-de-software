package projeto.software.infra.repositories;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import io.quarkus.hibernate.orm.panache.PanacheRepositoryBase;
import projeto.software.domain.entities.Usuario;
import projeto.software.domain.entities.VagaEmprego;

public interface UsuarioRepository extends PanacheRepositoryBase<Usuario, UUID> {
    
    public List<VagaEmprego> buscarVagasInscritas(UUID idUsuario);

    public Optional<Usuario> deletarCadastroDeUsuario(UUID idUsuario);

    public List<Usuario> buscarUsuarios();

    public Optional<Usuario> buscarUsuarioPorId(UUID idUsuario);
}
