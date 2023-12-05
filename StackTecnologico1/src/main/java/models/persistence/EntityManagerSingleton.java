package models.persistence;


import jakarta.persistence.EntityManager;
import jakarta.persistence.Persistence;

public class EntityManagerSingleton {
  private static EntityManager instancia = null;
  private EntityManagerSingleton(){}

  public static EntityManager getInstance(){
    if(instancia == null || !instancia.isOpen())
      instancia = Persistence.createEntityManagerFactory("simple-persistence-unit").createEntityManager();

    return instancia;
  }
}