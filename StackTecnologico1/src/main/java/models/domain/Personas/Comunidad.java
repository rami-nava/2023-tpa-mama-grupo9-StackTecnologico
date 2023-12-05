package models.domain.Personas;

import lombok.Getter;
import lombok.Setter;
import models.domain.Incidentes.Incidente;
import models.domain.Incidentes.ReporteDeIncidente;
import models.domain.Notificaciones.EmisorDeNotificaciones;
import models.persistence.Persistente;
import models.persistence.Repositorios.RepositorioComunidad;
import models.persistence.Repositorios.RepositorioDeIncidentes;

import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name="comunidad")
public class Comunidad extends Persistente {
    @Column(name = "nombre")
    private String nombre;
    @Column(name = "gradosDeConfianza")
    private String gradosDeConfianza;
    @ManyToMany(mappedBy = "comunidades")
    private List<MiembroDeComunidad> miembros;
    @OneToMany(cascade = {CascadeType.MERGE,CascadeType.REMOVE})
    @JoinColumn(name = "comunidad_id")
    private List<ReporteDeIncidente> reportesDeLaComunidad;
    @Transient
    private EmisorDeNotificaciones emisorDeNotificaciones;
    @Transient
    private RepositorioComunidad repositorioComunidad;
    @Transient
    private RepositorioDeIncidentes repositorioDeIncidentes;

    public Comunidad() {
        this.miembros = new ArrayList<>();
        this.reportesDeLaComunidad = new ArrayList<>();
        //this.repositorioComunidad = RepositorioComunidad.getInstancia();
        //this.repositorioDeIncidentes = RepositorioDeIncidentes.getInstancia();
    }
    public void agregarMiembro(MiembroDeComunidad unMiembro) {
        this.miembros.add(unMiembro);
    }
    public boolean cerroIncidente(Incidente incidente) {
        return this.reportesDeLaComunidad.stream().anyMatch(r -> incidente.getReportesDeCierre().contains(r));
    }
    public boolean abrioIncidente(Incidente incidente) {
        return this.reportesDeLaComunidad.stream().anyMatch(r -> incidente.getReportesDeApertura().contains(r));
    }
    public List<Incidente> getIncidentesDeComunidad(List<Incidente> incidentes) {
        return incidentes.stream().filter(i -> this.incidenteEsDeComunidad(i)).toList();
    }
    public boolean incidenteEsDeComunidad(Incidente incidente) {
        return this.reportesDeLaComunidad.stream().anyMatch(r -> incidente.getReportesDeApertura().contains(r));
    }
    public void agregarReporte(ReporteDeIncidente reporteDeIncidente){
        this.reportesDeLaComunidad.add(reporteDeIncidente);
        this.getMiembros().forEach(m -> m.recibirNotificacion(reporteDeIncidente));
    }
    public List<Incidente> incidentesAbiertos(List<Incidente> incidentes){
        return this.getIncidentesDeComunidad(incidentes).stream().filter(i -> !i.cerrado()).toList();
    }

    public int cantidadMiembros(){
        return  this.miembros.size();
    }

    public void eliminarReportesAEliminar(List<ReporteDeIncidente> reportesAEliminar) {
        for (ReporteDeIncidente reporteDeIncidente:reportesAEliminar)
        {
            if(this.reportesDeLaComunidad.contains(reporteDeIncidente))
            {
                reportesDeLaComunidad.remove(reportesAEliminar);
            }
        }
    }
}