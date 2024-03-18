package br.unipar.programacaointernet.servicecep.servicecep.util;

import br.unipar.programacaointernet.servicecep.servicecep.util.dao.EnderecoDAO;
import br.unipar.programacaointernet.servicecep.servicecep.util.dao.EnderecoDaoImpl;
import br.unipar.programacaointernet.servicecep.servicecep.util.dao.UsuarioDAO;
import br.unipar.programacaointernet.servicecep.servicecep.util.dao.UsuarioDAOImpl;
import br.unipar.programacaointernet.servicecep.servicecep.util.model.Endereco;
import br.unipar.programacaointernet.servicecep.servicecep.util.model.Usuario;
import jakarta.persistence.EntityManager;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        try {
            EntityManagerUtil.getEntityManagerFactory();

//            salvarUsuario();
//            editarUsuario();
//            deletarUsuario();
//            buscarUsuarioPorId();
//            buscarTodosUsuario();

            salvarEndereco();

            EntityManagerUtil.closeEntityManagerFactory();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    private static void salvarUsuario() {
        UsuarioDAO usuarioDAO = new UsuarioDAOImpl(
                EntityManagerUtil.getManager()
        );
        Usuario usuario = new Usuario();

        usuario.setNome("erick");
        usuario.setLogin("erick_o_melhor");
        usuario.setSenha("erick1234");

        usuarioDAO.save(usuario);
    }

    public static void editarUsuario() {
        UsuarioDAO usuarioDAO = new UsuarioDAOImpl(
                EntityManagerUtil.getManager()
        );

        Usuario usuario = usuarioDAO.findById(1L);

        usuario.setSenha("nicolas1234567");

        usuarioDAO.update(usuario);
    }

    public static void deletarUsuario() {
        UsuarioDAO usuarioDAO = new UsuarioDAOImpl(
                EntityManagerUtil.getManager()
        );

        Usuario usuario = usuarioDAO.findById(1L);

        usuarioDAO.delete(usuario);
    }

    public static void buscarUsuarioPorId() {
        UsuarioDAO usuarioDAO = new UsuarioDAOImpl(
                EntityManagerUtil.getManager()
        );

        Usuario usuario = usuarioDAO.findById(2L);

        System.out.println("Usuario encontrado" + usuario.getNome() + " com sucesso!");
    }

    public static void buscarTodosUsuario() {
        UsuarioDAO usuarioDAO = new UsuarioDAOImpl(
                EntityManagerUtil.getManager()
        );

        List<Usuario> usuario = usuarioDAO.findAll();

        for (Usuario usuario1 : usuario) {
            System.out.println("Usuário: " + usuario1.getNome());
        }

    }

    private static void salvarEndereco() {
        try {
            EnderecoDAO enderecoDAO = new EnderecoDaoImpl(
                    EntityManagerUtil.getManager()
            );
//            enderecoDAO.save(getViaCep("85818157"));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }
}
