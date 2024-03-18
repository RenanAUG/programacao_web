package br.unipar.programacaointernet.servicecep.servicecep.util.dao;

import br.unipar.programacaointernet.servicecep.servicecep.util.EntityManagerUtil;
import br.unipar.programacaointernet.servicecep.servicecep.util.model.Endereco;
import br.unipar.programacaointernet.servicecep.servicecep.util.model.Usuario;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.NoResultException;

import java.util.List;

public class EnderecoDaoImpl implements EnderecoDAO {

    private EntityManager entityManager = EntityManagerUtil.getManager();

    public EnderecoDaoImpl(EntityManager em) {
        this.entityManager = em;
    }

    @Override
    public void save(Endereco endereco) {
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();

        entityManager.persist(endereco);
        transaction.commit();

        System.out.println("Endereço " + endereco.getCep() +
                " salvo com sucesso!");
    }

    @Override
    public void update(Endereco endereco) {
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();

        entityManager.merge(endereco);
        transaction.commit();

        System.out.println("Endereço " + endereco.getCep() +
                " atualizado com sucesso!");
    }

    @Override
    public void delete(Endereco endereco) {
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();

        entityManager.remove(endereco);
        transaction.commit();

        System.out.println("Endereço " + endereco.getCep() +
                " deletado com sucesso!");
    }

    @Override
    public Endereco findById(Long id) {
        return entityManager.find(Endereco.class, id);
    }

    @Override
    public Endereco consultaCep(String cep) {
         try {
             return entityManager.createQuery("select e from Endereco e where e.cep = :cep", Endereco.class)
                     .setParameter("cep", cep)
                     .getSingleResult();
         } catch (NoResultException e) {
             return  null;
         }
    }

    @Override
    public List<Endereco> findAll() {
        return entityManager.createQuery("SELECT e FROM Endereco e", Endereco.class).getResultList();
    }
}
