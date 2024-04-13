package br.unipar.programacaointernet.task.task.service;

import br.unipar.programacaointernet.task.task.model.Usuario;
import br.unipar.programacaointernet.task.task.repository.UsuarioRepository;
import jakarta.ejb.Stateless;
import jakarta.inject.Inject;

import java.util.List;

@Stateless
public class UsuarioService {

    @Inject
    private UsuarioRepository usuarioRepository;

    public List<Usuario> listar() {
        return usuarioRepository.listarTodos();
    }

    public void cadastrar(Usuario usuario) throws Exception {
        usuarioRepository.cadastrar(usuario);
    }

    public Usuario buscarPorId(Integer id) {
        return usuarioRepository.buscarPorID(id);
    }

    public void deletarUsuario(Integer id) throws Exception {
        usuarioRepository.deletarUsuario(id);
    }

    public void atualizarUsuario(Integer id, String nome, String cargo) throws Exception {
        Usuario usuarioAtual = usuarioRepository.buscarPorID(id);

        if (cargo != null) {
            usuarioAtual.setCargo(cargo);
        }

        if (nome != null) {
            usuarioAtual.setNome(nome);
        }

        usuarioRepository.editarUsuario(usuarioAtual);
    }
}
