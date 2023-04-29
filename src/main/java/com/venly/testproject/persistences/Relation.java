package com.venly.testproject.persistences;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "x_relations")
@SuppressWarnings("PersistenceUnitPresent")
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Relation implements Serializable {

    @Id
    @EqualsAndHashCode.Include
    private String id;

    @Column(name = "name", nullable = false)
    private String name;
}
