package server.SpringBoot.controllers;

import models.domain.Incidentes.Incidente;
import models.persistence.EntityManagerSingleton;
import models.persistence.Repositorios.RepositorioDeIncidentes;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import jakarta.persistence.EntityManager;

import java.util.List;

@Controller
class IncidentesController {
  RepositorioDeIncidentes repositorioDeIncidentes = RepositorioDeIncidentes.getInstancia();

    @GetMapping({"/","/incidentes"})
    public String getIncidentes(Model model){
      EntityManager em = EntityManagerSingleton.getInstance();
      List<Incidente> incidentes = repositorioDeIncidentes.buscarTodos();
      em.close();

      model.addAttribute("listadoIncidentes",incidentes);


      return "Incidentes";
    }

}
