package com.venly.testproject.persistences;

import com.venly.testproject.enums.RelationType;
import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "word_relations")
@SuppressWarnings("PersistenceUnitPresent")
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class WordRelation implements Serializable {

    @Id
    @EqualsAndHashCode.Include
    @SequenceGenerator(name = "word_relations_id_seq", sequenceName = "word_relations_id_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "word_relations_id_seq")
    private Integer id;

    @Column(name = "word_id")
    private Integer wordId;

    @Enumerated(EnumType.STRING)
    @Column(name = "relation_type", nullable = false)
    private RelationType relationType;

    @Column(name = "relation_word", nullable = false)
    private String relationWord;

    public WordRelation() {}

    public WordRelation(RelationType relationType, String relationWord) {
        this.relationType = relationType;
        this.relationWord = relationWord;
    }
}
