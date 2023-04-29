package com.venly.testproject.services;

import com.venly.testproject.dto.WordDTO;
import com.venly.testproject.dto.input.WordRelationInputDTO;
import com.venly.testproject.enums.RelationType;
import java.util.List;

public interface WordRelationService {

    void createWordRelation(WordRelationInputDTO input);

    List<WordDTO> getAllWordsWithRelations(RelationType type);
}
