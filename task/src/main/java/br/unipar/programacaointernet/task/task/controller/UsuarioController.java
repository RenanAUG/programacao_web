package br.unipar.programacaointernet.task.task.controller;

import br.unipar.programacaointernet.task.task.model.Usuario;
import br.unipar.programacaointernet.task.task.service.UsuarioService;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import javax.print.attribute.standard.Media;

@Path("/usuario")
public class UsuarioController {

    @Inject
    private UsuarioService usuarioService;

    @GET
    @Produces(value = MediaType.APPLICATION_JSON)
    public Response listarUsuarios() {
        return Response.ok(usuarioService.listar()).build();
    }

    @POST
    @Consumes(value = MediaType.APPLICATION_JSON)
    @Produces(value = MediaType.APPLICATION_JSON)
    public Response inserirUsuario(Usuario usuario) {
        try {
            usuarioService.cadastrar(usuario);

            return Response.status(200)
                    .entity("Usuario cadastrado com sucesso")
                    .build();
        } catch (Exception e) {
            return Response.status(500).entity(e.getMessage()).build();
        }
    }

    @GET
    @Produces(value = MediaType.APPLICATION_JSON)
    public Response buscarUsuarioPorId(@PathParam("id") Integer id) {
        return Response.ok(usuarioService.buscarPorId(id)).build();
    }

    @DELETE
    @Produces(value = MediaType.APPLICATION_JSON)
    public Response deletarUsuario(@PathParam("id") Integer id) {
        try {
            usuarioService.deletarUsuario(id);

            return Response.status(200)
                    .entity("Usuario deletado com sucesso")
                    .build();
        } catch (Exception e) {
            return Response.status(500).entity(e.getMessage()).build();
        }
    }

    @PUT
    @Produces(value = MediaType.APPLICATION_JSON)
    public Response editarUsuario(
            @PathParam("id") Integer id,
            String nome,
            String cargo
    ) {
        try {
            usuarioService.atualizarUsuario(id, nome, cargo);
            return Response.status(200)
                        .entity("Usuário editado com sucesso.")
                        .build();
        } catch (Exception exception) {
            return Response.status(500).entity(exception.getMessage()).build();
        }
    }
}
