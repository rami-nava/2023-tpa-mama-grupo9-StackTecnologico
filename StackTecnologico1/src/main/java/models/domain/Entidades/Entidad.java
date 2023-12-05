package models.domain.Entidades;

import lombok.Getter;
import lombok.Setter;
import models.persistence.Persistente;

import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
@Setter
@Getter
@Entity
@Table(name = "entidad")
public class Entidad extends Persistente {
    @Column(name = "nombre")
    private String nombre;
    @OneToMany(cascade = {CascadeType.REMOVE, CascadeType.PERSIST, CascadeType.MERGE})
    @JoinColumn(name="entidad_id")
    private List<Establecimiento> establecimientos;
    @Enumerated(EnumType.STRING)
    private TipoEntidad tipoEntidad;

    public Entidad() {
        this.establecimientos = new ArrayList<>();
    }
    public void agregarEstablecimiento(Establecimiento unEstablecimiento) {
        establecimientos.removeIf(establecimiento -> establecimiento.igualito(unEstablecimiento));
        establecimientos.add(unEstablecimiento);
    }

    public boolean igualito(Entidad entidad) {
        if (this == entidad) {
            return true;
        }
        if (entidad == null || getClass() != entidad.getClass()) {
            return false;
        }
        Entidad otro = entidad;
        return Objects.equals(nombre, otro.nombre)
            && Objects.equals(tipoEntidad, otro.tipoEntidad);
    }

    public int cantidadEstablecimientos(){
        return this.establecimientos.size();
    }
    public String tipo(){
        return this.tipoEntidad.toString();
    }

}
