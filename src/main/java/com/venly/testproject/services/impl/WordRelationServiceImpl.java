package com.venly.testproject.services.impl;

import com.venly.testproject.dto.input.WordRelationInputDTO;
import com.venly.testproject.exceptions.BadRequestException;
import com.venly.testproject.exceptions.GenericException;
import com.venly.testproject.exceptions.handler.ErrorCode;
import com.venly.testproject.persistences.Word;
import com.venly.testproject.persistences.WordRelation;
import com.venly.testproject.services.WordRelationService;
import com.venly.testproject.services.txns.WordRelationServiceTxn;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class WordRelationServiceImpl implements WordRelationService {

    private final WordRelationServiceTxn wordRelationServiceTxn;

    @Override
    public void createWordRelation(WordRelationInputDTO input) {
        if (input == null) {
            throw new BadRequestException(ErrorCode.ERROR_EMPTY_PARAMS);
        }

        try {
            Word word = new Word(input.getMainWord());
            WordRelation wordRelation = new WordRelation(input.getRelationType(), input.getRelatedWord());
            wordRelationServiceTxn.createWordRelation(word, wordRelation);
        }
        catch (final Exception ex) {
            log.error("Error while creating a word relation [{}]: ", input.toString(), ex);
            throw new GenericException(ErrorCode.ERROR_GENERIC, ex);
        }
    }
}
