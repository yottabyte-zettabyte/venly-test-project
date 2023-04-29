package com.venly.testproject.services.txns;

import com.venly.testproject.persistences.Word;
import com.venly.testproject.persistences.WordRelation;
import com.venly.testproject.repositories.WordRelationRepository;
import com.venly.testproject.repositories.WordRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class WordRelationServiceTxn {

    private final WordRepository wordRepository;
    private final WordRelationRepository wordRelationRepository;

    public void createWordRelation(Word word, WordRelation wordRelation) {
        wordRepository.save(word);

        wordRelation.setWordId(word.getId());
        wordRelationRepository.save(wordRelation);
    }
}
