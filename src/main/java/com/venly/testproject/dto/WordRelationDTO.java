package com.venly.testproject.dto;

import com.venly.testproject.enums.RelationType;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class WordRelationDTO {

    @EqualsAndHashCode.Include
    private Integer id;
    private RelationType relationType;
    private String relationWord;
}
