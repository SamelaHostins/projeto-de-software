package salao.online.application.services.interfaces;

import java.util.List;
import java.util.Map;
import java.util.UUID;

import projeto.software.application.dtos.CriarUsuarioDTO;

public interface UsuarioService {

    public CriarUsuarioDTO cadastrarUsuario(CriarUsuarioDTO UsuarioDTO) throws Exception;

    public BuscarUsuarioDTO buscarUsuarioPorId(UUID idUsuario) throws Exception;

    public void deletarUsuario(UUID idUsuario) throws Exception;

    public List<BuscarUsuarioDTO> buscarUsuarios();

}
