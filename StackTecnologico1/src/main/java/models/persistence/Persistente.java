package models.persistence;

import lombok.Getter;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;

@MappedSuperclass
@Getter
public abstract class Persistente {
        @Id
        @GeneratedValue
        private Long id;
}