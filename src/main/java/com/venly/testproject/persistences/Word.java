package com.venly.testproject.persistences;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "words")
@SuppressWarnings("PersistenceUnitPresent")
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Word implements Serializable {

    @Id
    @EqualsAndHashCode.Include
    @SequenceGenerator(name = "words_id_seq", sequenceName = "words_id_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "words_id_seq")
    private Integer id;

    @Column(name = "word", nullable = false)
    private String word;

    @OneToMany(fetch = FetchType.LAZY)
    @JoinColumn(name = "word_id", referencedColumnName = "id")
    private List<WordRelation> wordRelations;

    public Word() {}

    public Word(String word) {
        this.word = word;
    }
}
