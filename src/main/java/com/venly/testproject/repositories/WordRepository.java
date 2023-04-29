package com.venly.testproject.repositories;

import com.venly.testproject.enums.RelationType;
import com.venly.testproject.persistences.Word;
import com.venly.testproject.repositories.specs.WordSpecification;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface WordRepository extends JpaRepository<Word, Integer>, JpaSpecificationExecutor<Word> {

    default Page<Word> findAll(Pageable pageable, RelationType relationType) {
        return findAll(WordSpecification.getByRelationType(relationType), pageable);
    }
}
