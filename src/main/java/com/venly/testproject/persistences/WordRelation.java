package com.venly.testproject.persistences;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

@Getter
@Setter
@Entity
@Table(name = "word_relations")
@SuppressWarnings("PersistenceUnitPresent")
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class WordRelation implements Serializable {

    @Id
    @EqualsAndHashCode.Include
    private String id;

    @Column(name = "word_id")
    private Integer wordId;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "relation_id")
    @OnDelete(action = OnDeleteAction.NO_ACTION)
    private Relation relation;

    @Column(name = "relation_word", nullable = false)
    private String relationWord;
}
