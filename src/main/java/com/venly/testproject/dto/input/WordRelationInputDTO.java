package com.venly.testproject.dto.input;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.venly.testproject.enums.RelationType;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class WordRelationInputDTO {

    @NotBlank
    @JsonProperty("w1")
    private String mainWord;

    @NotBlank
    @JsonProperty("w2")
    private String relatedWord;

    @NotNull
    @JsonProperty("r")
    private RelationType relationType;
}

