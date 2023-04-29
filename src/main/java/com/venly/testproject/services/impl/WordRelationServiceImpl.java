package com.venly.testproject.services.impl;

import com.venly.testproject.dto.WordDTO;
import com.venly.testproject.dto.input.WordRelationInputDTO;
import com.venly.testproject.exceptions.BadRequestException;
import com.venly.testproject.exceptions.GenericException;
import com.venly.testproject.exceptions.handler.ErrorCode;
import com.venly.testproject.persistences.Word;
import com.venly.testproject.persistences.WordRelation;
import com.venly.testproject.repositories.WordRepository;
import com.venly.testproject.services.WordRelationService;
import com.venly.testproject.services.txns.WordRelationServiceTxn;
import java.util.Collections;
import java.util.List;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

@Slf4j
@Service
@RequiredArgsConstructor
public class WordRelationServiceImpl implements WordRelationService {

    private final ModelMapper modelMapper;
    private final WordRepository wordRepository;
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

    public List<WordDTO> getAllWordsWithRelations() {
        List<Word> words = wordRepository.findAll(Sort.by(Sort.Direction.ASC, "id"));
        if (CollectionUtils.isEmpty(words)) {
            return Collections.<WordDTO>emptyList();
        }
        return modelMapper.map(words, new TypeToken<List<WordDTO>>(){}.getType());
    }
}
