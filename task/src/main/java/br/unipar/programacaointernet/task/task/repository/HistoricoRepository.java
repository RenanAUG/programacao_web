package br.unipar.programacaointernet.task.task.repository;

import br.unipar.programacaointernet.task.task.model.Historico;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

@Stateless
public class HistoricoRepository {

    @PersistenceContext(unitName = "HibernateMaven")
    private EntityManager em;

    public void salvar(Historico historico) {
        em.persist(historico);
    }
}
