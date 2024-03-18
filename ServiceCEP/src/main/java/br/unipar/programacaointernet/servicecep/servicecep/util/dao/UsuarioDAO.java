package br.unipar.programacaointernet.servicecep.servicecep.util.dao;

import br.unipar.programacaointernet.servicecep.servicecep.util.model.Usuario;

import java.util.List;

public interface UsuarioDAO {

    public void save(Usuario usuario);
    public void update(Usuario usuario);
    public void delete(Usuario usuario);

    public Usuario findById(Long id);
    public List<Usuario> findAll();
}
