package br.unipar.programacaointernet.servicecep.servicecep.util.service;

import br.unipar.programacaointernet.servicecep.servicecep.util.model.Usuario;
import jakarta.jws.WebMethod;
import jakarta.jws.WebParam;
import jakarta.jws.WebService;

import java.util.List;

@WebService
public interface UsuarioSEI {

    @WebMethod
    String boasVindas(@WebParam(name = "nome") String nome);


    @WebMethod
    Usuario consultaUsuario(@WebParam (name = "idUsuario") Long idUsuario );

    @WebMethod
    List<Usuario> consultaTodosUsuario();

    @WebMethod
    String deletaUsuario(@WebParam (name = "idUsuario") Long idUsuario);

    @WebMethod
    String salvarUsuario(@WebParam (name = "usuario") Usuario usuario);

    @WebMethod
    String editarUsuario(@WebParam (name = "idUsuario") Long idUsuario, @WebParam (name = "login") String login, @WebParam (name = "nome") String nome, @WebParam (name = "senha") String sena);


}
