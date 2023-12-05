package models.services.Localizacion;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.NaturalId;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Setter
@Getter
@Entity
@Table(name = "provincia")
public class Provincia {
    @Id
    @NaturalId
    public int id;
    @Column(name = "nombre")
    public String nombre;

    public Provincia() {}
}