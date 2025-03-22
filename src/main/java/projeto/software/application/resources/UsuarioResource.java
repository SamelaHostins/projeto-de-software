package projeto.software.application.resources;

import java.util.List;
import java.util.UUID;

import org.eclipse.microprofile.openapi.annotations.Operation;
import org.eclipse.microprofile.openapi.annotations.parameters.RequestBody;
import org.eclipse.microprofile.openapi.annotations.responses.APIResponse;
import org.eclipse.microprofile.openapi.annotations.tags.Tag;

import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import projeto.software.application.dtos.dtosUsuario.BuscarUsuarioDTO;
import projeto.software.application.dtos.dtosUsuario.CriarUsuarioDTO;
import projeto.software.application.services.interfaces.UsuarioService;

@Path("/usuario")
@Tag(name = "Endpoints do Usuario")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class UsuarioResource {

    @Inject
    UsuarioService usuarioService;

    private static final org.jboss.logging.Logger LOG = org.jboss.logging.Logger.getLogger(UsuarioResource.class);

    @Operation(summary = "Cadastrando um Usuario")
    @APIResponse(responseCode = "200", description = "Usuario criado com sucesso!")
    @APIResponse(responseCode = "500", description = "Ocorreu um erro na requisição.")
    @POST
    @Transactional
    @Path("/cadastrar")
    public Response cadastrarUsuario(@Valid @RequestBody CriarUsuarioDTO dto) {
        try {
            LOG.info("Requisição recebida - Cadastrar Usuario");
            CriarUsuarioDTO UsuarioDTO = usuarioService.cadastrarUsuario(dto);
            return Response.status(200).entity(UsuarioDTO).build();
        } catch (Exception ex) {
            return Response.status(500).entity("Ocorreu um erro na requisição.").build();
        }
    }

    @Operation(summary = "Buscando um Usuario")
    @APIResponse(responseCode = "200", description = "Busca realizada com sucesso!")
    @APIResponse(responseCode = "404", description = "O Usuario não foi encontrado")
    @GET
    @Path("/buscar/{id_Usuario}")
    public Response buscarUsuarioPorId(@PathParam("id_Usuario") UUID idUsuario)
            throws Exception {
        try {
            LOG.info("Requisição recebida - Buscar o Usuario");
            BuscarUsuarioDTO UsuarioDTO = usuarioService.buscarUsuarioPorId(idUsuario);
            return Response.status(200).entity(UsuarioDTO).build();
        } catch (Exception ex) {
            return Response.status(404).entity(ex.getMessage()).build();
        } catch (ExceptionInInitializerError ex) {
            return Response.status(500).entity("Ocorreu um erro na requisição.").build();
        }
    }

    @Operation(summary = "Buscando todos os Usuario")
    @APIResponse(responseCode = "200", description = "Busca realizada com sucesso!")
    @GET
    public Response buscarUsuarios() {
        try {
            LOG.info("Requisição recebida - Buscar o Usuario");
            List<BuscarUsuarioDTO> UsuarioDTO = usuarioService.buscarUsuarios();
            return Response.status(200).entity(UsuarioDTO).build();
        } catch (Exception ex) {
            return Response.status(500).entity("Ocorreu um erro na requisição.").build();
        }
    }

    @Operation(summary = "Deletando o cadastro de um Usuario")
    @APIResponse(responseCode = "200", description = "Cadastro deletado com sucesso!")
    @APIResponse(responseCode = "404", description = "O Usuario não foi encontrado")
    @DELETE
    @Transactional
    @Path("/deletar/{id_Usuario}")
    public Response deletarUsuario(@PathParam("id_Usuario") UUID idUsuario)
            throws Exception {
        try {
            LOG.info("Requisição recebida - Deletar o cadastro do Usuario");
            usuarioService.deletarUsuario(idUsuario);
            return Response.status(200).build();
        } catch (Exception ex) {
            return Response.status(404).entity(ex.getMessage()).build();
        }
    }
}
