package br.unipar.programacaointernet.task.task.repository;

import br.unipar.programacaointernet.task.task.model.Task;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.EntityManager;

import java.util.List;

public class TaskRepository {
    @PersistenceContext(unitName = "HibernateMaven")
    private EntityManager em;

    public List<Task> listarTasks(){
        String jpql = "SELECT t FROM Task t";
        return em.createQuery(jpql, Task.class).getResultList();
    }

    public Task buscarPorId(Integer id){
        return em.find(Task.class, id);
    }

    public void cadastrar(Task task) throws Exception{
        try{
            em.persist(task);
        }catch(Exception e){
            throw new Exception("Task não pôde ser cadastrada!");
        }
    }

    public void deletar(Integer id) throws Exception{
        try{
            Task task = em.find(Task.class, id);

            em.remove(task);
        }catch (Exception e){
            throw new Exception("Task não pôde ser deletada!");
        }
    }

    public void editarTask(Task task, Integer id) throws Exception{
        try{
            Task tarefa = em.find(Task.class, id);

            if(tarefa != null){
                tarefa.setDescricao(task.getDescricao());
                tarefa.setStatus(task.getStatus());
                tarefa.setUsuario(task.getUsuario());
                tarefa.setObservacao(task.getObservacao());
                tarefa.setPrioridade(task.getPrioridade());
                em.merge(tarefa);
            }else{
                throw new Exception("O ID está nulo");
            }
        }catch(Exception e){
            throw new Exception("Erro ao editar task");
        }
    }
}
