import models.persistence.EntityManagerSingleton;
import models.persistence.Repositorios.RepositorioDeIncidentes;
import models.persistence.Repositorios.RepositorioDeUsuarios;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;

public class Prueba{
  private EntityManager entityManager = EntityManagerSingleton.getInstance();
  private EntityTransaction tx;

  @Test
  public void funciona() {
    RepositorioDeUsuarios repositorioDeUsuarios = RepositorioDeUsuarios.getInstancia();
    System.out.println(repositorioDeUsuarios.buscarTodos().get(0).getUsername());
    Assertions.assertTrue(true);
  }

  @Test
  public void listaIncidentes() {
    RepositorioDeIncidentes repositorioDeIncidentes = RepositorioDeIncidentes.getInstancia();
    System.out.println(repositorioDeIncidentes.buscarTodos().get(0).getId());
    Assertions.assertTrue(true);
  }
}