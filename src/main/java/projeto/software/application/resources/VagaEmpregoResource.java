package projeto.software.application.resources;

import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.eclipse.microprofile.openapi.annotations.Operation;
import org.eclipse.microprofile.openapi.annotations.parameters.RequestBody;
import org.eclipse.microprofile.openapi.annotations.responses.APIResponse;
import org.eclipse.microprofile.openapi.annotations.tags.Tag;
import projeto.software.application.dtos.dtosVagaEmprego.*;
import projeto.software.application.services.interfaces.VagaEmpregoService;

import java.util.List;
import java.util.UUID;

@Path("/vaga")
@Tag(name = "Endpoints de Vaga de Emprego")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class VagaEmpregoResource {

    @Inject
    VagaEmpregoService vagaEmpregoService;

    private static final org.jboss.logging.Logger LOG = org.jboss.logging.Logger.getLogger(VagaEmpregoResource.class);

    @Operation(summary = "Listar todas as Vagas de Emprego")
    @APIResponse(responseCode = "200", description = "Lista de vagas retornada com sucesso.")
    @GET
    public Response listarVagas() {
        try {
            LOG.info("Requisição recebida - Listar Vagas");
            List<VagaEmpregoDTO> vagas = vagaEmpregoService.listarVagas();
            return Response.status(200).entity(vagas).build();
        } catch (Exception ex) {
            return Response.status(500).entity("Erro ao listar vagas.").build();
        }
    }

    @Operation(summary = "Cadastrar nova Vaga de Emprego")
    @APIResponse(responseCode = "200", description = "Vaga criada com sucesso.")
    @APIResponse(responseCode = "500", description = "Erro ao criar vaga.")
    @POST
    @Transactional
    @Path("/cadastrar")
    public Response criarVaga(@Valid @RequestBody CriarVagaEmpregoDTO dto) {
        try {
            LOG.info("Requisição recebida - Cadastrar Vaga");
            vagaEmpregoService.criarVaga(dto);
            return Response.status(200).entity("Vaga criada com sucesso!").build();
        } catch (Exception ex) {
            return Response.status(500).entity("Erro ao cadastrar vaga.").build();
        }
    }

    @Operation(summary = "Deletar uma Vaga de Emprego por ID")
    @APIResponse(responseCode = "200", description = "Vaga deletada com sucesso.")
    @APIResponse(responseCode = "404", description = "Vaga não encontrada.")
    @DELETE
    @Transactional
    @Path("/deletar/{id_vaga}")
    public Response excluirVaga(@PathParam("id_vaga") UUID idVaga) {
        try {
            LOG.info("Requisição recebida - Excluir Vaga");
            vagaEmpregoService.excluirVaga(idVaga);
            return Response.status(200).entity("Vaga excluída com sucesso!").build();
        } catch (Exception ex) {
            return Response.status(404).entity(ex.getMessage()).build();
        }
    }

    @Operation(summary = "Buscar Vaga de Emprego com Usuários Inscritos")
    @APIResponse(responseCode = "200", description = "Detalhes da vaga retornados com sucesso.")
    @APIResponse(responseCode = "404", description = "Vaga não encontrada.")
    @GET
    @Path("/buscar-com-usuarios/{id_vaga}")
    public Response buscarVagaComUsuarios(@PathParam("id_vaga") UUID idVaga) {
        try {
            LOG.info("Requisição recebida - Buscar Vaga com Usuários");
            BuscarVagaEmpregoDTO vagaDTO = vagaEmpregoService.buscarVagaComUsuarios(idVaga);
            return Response.status(200).entity(vagaDTO).build();
        } catch (Exception ex) {
            return Response.status(404).entity(ex.getMessage()).build();
        }
    }
}
