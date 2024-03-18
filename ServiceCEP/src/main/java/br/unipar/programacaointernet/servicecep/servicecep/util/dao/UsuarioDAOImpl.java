package br.unipar.programacaointernet.servicecep.servicecep.util.dao;

import br.unipar.programacaointernet.servicecep.servicecep.util.EntityManagerUtil;
import br.unipar.programacaointernet.servicecep.servicecep.util.model.Usuario;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;

import java.util.List;

public class UsuarioDAOImpl implements UsuarioDAO {

    private EntityManager entityManager = EntityManagerUtil.getManager();

    public UsuarioDAOImpl(EntityManager em) {
        this.entityManager = em;
    }

    @Override
    public void save(Usuario usuario) {
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();

        entityManager.persist(usuario);
        transaction.commit();

        System.out.println("Usuário " + usuario.getNome() +
                " salvo com sucesso!");
    }

    @Override
    public void update(Usuario usuario) {
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();

        entityManager.merge(usuario);
        transaction.commit();

        System.out.println("Usuário " + usuario.getNome() +
                " atualizado com sucesso!");
    }

    @Override
    public void delete(Usuario usuario) {
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();

        entityManager.remove(usuario);
        transaction.commit();

        System.out.println("Usuário " + usuario.getNome() +
                " deletado com sucesso!");
    }

    @Override
    public Usuario findById(Long id) {
        return entityManager.find(Usuario.class, id);
    }

    @Override
    public List<Usuario> findAll() {
        return entityManager.createQuery("SELECT u FROM Usuario u", Usuario.class).getResultList();
    }
}
