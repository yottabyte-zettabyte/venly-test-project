package com.venly.testproject.controllers;

import com.venly.testproject.dto.WordDTO;
import com.venly.testproject.dto.input.WordRelationInputDTO;
import com.venly.testproject.enums.RelationType;
import com.venly.testproject.services.WordRelationService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("/word")
@RequiredArgsConstructor
public class WordController {

    private final WordRelationService wordRelationService;

    @PostMapping("/relation")
    public ResponseEntity createWordRelation(@RequestBody WordRelationInputDTO requestBody) {
        wordRelationService.createWordRelation(requestBody);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/relations")
    public ResponseEntity<List<WordDTO>> getWordRelations(@RequestParam(name = "type", required = false) RelationType type) {
        return new ResponseEntity<>(wordRelationService.getAllWordsWithRelations(type), HttpStatus.OK);
    }
}
