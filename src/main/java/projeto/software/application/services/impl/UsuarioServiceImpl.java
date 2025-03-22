package projeto.software.application.services.impl;

import java.text.Normalizer;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import io.vertx.core.impl.logging.Logger;
import io.vertx.core.impl.logging.LoggerFactory;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import projeto.software.application.dtos.dtosUsuario.BuscarUsuarioDTO;
import projeto.software.application.dtos.dtosUsuario.CriarUsuarioDTO;
import projeto.software.application.mappers.UsuarioMapper;
import projeto.software.application.services.interfaces.UsuarioService;
import projeto.software.domain.entities.Usuario;
import projeto.software.infra.repositories.UsuarioRepository;

@ApplicationScoped
public class UsuarioServiceImpl implements UsuarioService {

    @Inject
    UsuarioMapper usuarioMapper;

    @Inject
    UsuarioRepository usuarioRepository;

    private static Logger logger = LoggerFactory.getLogger(LoggerFactory.class);

    private String removeAcentos(String texto) {
        if (texto == null) {
            return null;
        }
        String normalized = Normalizer.normalize(texto, Normalizer.Form.NFD);
        return normalized.replaceAll("[^\\p{ASCII}]", "");
    }

    @Override
    @Transactional
    public CriarUsuarioDTO cadastrarUsuario(CriarUsuarioDTO usuarioDTO) throws Exception {
        try {
            if (usuarioRepository.find("email", usuarioDTO.getEmail()).firstResultOptional().isPresent()) {
                throw new Exception("E-mail já cadastrado");
            }

            Usuario usuario = usuarioMapper.fromDtoToEntity(usuarioDTO);

            String[] sobrenomes = usuarioDTO.getSobrenome().split(" ");
            String ultimoSobrenome = sobrenomes[sobrenomes.length - 1];
            String loginUsuario = removeAcentos(usuarioDTO.getNome().toLowerCase()) + "."
                    + removeAcentos(ultimoSobrenome.toLowerCase());
            usuario.setLoginUsuario(loginUsuario);

            logger.info("Salvando o usuario no banco de dados");
            usuarioRepository.persistAndFlush(usuario);

            return usuarioMapper.fromEntityToDto(usuario);

        } catch (Exception e) {
            logger.error("Erro ao cadastrar usuario", e);
            throw new RuntimeException("Erro ao cadastrar usuario.", e);
        }
    }

    @Override
    public BuscarUsuarioDTO buscarUsuarioPorId(UUID idusuario) throws Exception {
        logger.info("Validando se o usuario existe");
        Usuario usuario = usuarioRepository.findByIdOptional(idusuario)
                .orElseThrow(() -> new Exception("Usuário não encontrado"));
        return getBuscarUsuarioDTO(usuario);
    }

    @Override
    public List<BuscarUsuarioDTO> buscarUsuarios() {
        logger.info("Buscando de forma ordenada os Usuarios cadastrados");
        return usuarioRepository.buscarUsuarios().stream()
                .map(usuario -> getBuscarUsuarioDTO(usuario))
                .collect(Collectors.toList());
    }

    @Override
    public void deletarUsuario(UUID idusuario) throws Exception {
        logger.info("Validando se o usuario existe");
        buscarUsuarioPorId(idusuario);
        usuarioRepository.deletarCadastroDeUsuario(idusuario);
    }

    private BuscarUsuarioDTO getBuscarUsuarioDTO(Usuario usuario) {
        BuscarUsuarioDTO usuarioDTO = usuarioMapper.fromEntityToDtoBuscar(usuario);
        return usuarioDTO;
    }

}
