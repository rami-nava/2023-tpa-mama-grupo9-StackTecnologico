package models.persistence.Repositorios;

import models.persistence.EntityManagerSingleton;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import java.util.List;

public abstract class RepositorioGenerico<T>{
    @PersistenceContext
    private Class<T> entityClass;
    private EntityManager entityManager;
    public RepositorioGenerico(Class<T> entityClass) { this.entityClass = entityClass; }
    public void agregar(T entity) {
        entityManager = EntityManagerSingleton.getInstance();
        entityManager.persist(entity);
    }
    public void eliminar(T entity) {
        entityManager = EntityManagerSingleton.getInstance();
        entityManager.remove(entity);
    }

    public T buscar(long id) {
        entityManager = EntityManagerSingleton.getInstance();
        return entityManager.find(entityClass, id);
    }

    public List<T> buscarTodos() {
        entityManager = EntityManagerSingleton.getInstance();
        String ss = "from " + entityClass.getSimpleName();
        return entityManager.createQuery(ss, entityClass).getResultList(); }
}
