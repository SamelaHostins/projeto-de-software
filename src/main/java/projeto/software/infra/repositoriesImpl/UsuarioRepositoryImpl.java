package projeto.software.infra.repositoriesImpl;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

import jakarta.enterprise.context.ApplicationScoped;
import projeto.software.domain.entities.Usuario;
import projeto.software.domain.entities.VagaEmprego;
import projeto.software.infra.repositories.UsuarioRepository;

@ApplicationScoped
public class UsuarioRepositoryImpl implements UsuarioRepository {

    @Override
    public List<VagaEmprego> buscarVagasInscritas(UUID idUsuario) {
        Usuario usuario = findByIdOptional(idUsuario).orElse(null);
        if (usuario != null) {
            return usuario.getVagasInscritas().stream()
                    .collect(Collectors.toList());
        } else {
            return Collections.emptyList();
        }
    }

    @Override
    public Optional<Usuario> deletarCadastroDeUsuario(UUID idUsuario) {
        Optional<Usuario> usuarioOptional = findByIdOptional(idUsuario);
        if (usuarioOptional.isPresent()) {
            deleteById(idUsuario);
        }
        return usuarioOptional;
    }

    @Override
    public Optional<Usuario> buscarUsuarioPorId(UUID idUsuario) {
        return find("id_usuario", idUsuario).firstResultOptional();
    }

    @Override
    public List<Usuario> buscarUsuarios() {
        List<Usuario> usuarios = listAll();
        usuarios.sort(Comparator.comparing(Usuario::getNome));
        return usuarios;
    }

}
