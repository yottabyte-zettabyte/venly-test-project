package com.venly.testproject.dto;

import java.util.List;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class WordDTO {

    @EqualsAndHashCode.Include
    private Integer id;
    private String word;
    private List<WordRelationDTO> wordRelations;
}
