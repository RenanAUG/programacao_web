package br.unipar.programacaointernet.servicecep.servicecep.util.service;

import br.unipar.programacaointernet.servicecep.servicecep.util.model.Endereco;
import br.unipar.programacaointernet.servicecep.servicecep.util.model.Usuario;
import jakarta.jws.WebMethod;
import jakarta.jws.WebParam;
import jakarta.jws.WebService;

import java.util.List;

@WebService
public interface EnderecoSEI {

    @WebMethod
    Endereco consultaEndereco(@WebParam(name = "cep") String cep );

    @WebMethod
    List<Endereco> consultaTodosEndereco();

    @WebMethod
    String deletaEndereco(@WebParam (name = "idEndereco") Long idEndereco);

    @WebMethod
    String salvarEndereco(@WebParam (name = "cep") String cep) throws Exception;

    @WebMethod
    String editarEndereco(@WebParam (name = "idEndereco") Long idEndereco, @WebParam (name = "bairro") String bairro, @WebParam (name = "localidade") String localidade);

}
