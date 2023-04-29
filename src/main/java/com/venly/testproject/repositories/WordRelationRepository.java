package com.venly.testproject.repositories;

import com.venly.testproject.persistences.WordRelation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WordRelationRepository extends JpaRepository<WordRelation, Integer> {

}
