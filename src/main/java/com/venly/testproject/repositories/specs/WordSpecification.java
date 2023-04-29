package com.venly.testproject.repositories.specs;

import com.venly.testproject.enums.RelationType;
import com.venly.testproject.persistences.Word;
import lombok.experimental.UtilityClass;
import org.springframework.data.jpa.domain.Specification;

@UtilityClass
public class WordSpecification {

    public static Specification<Word> getByRelationType(final RelationType relationType) {
        return (root, criteriaQuery, criteriaBuilder) -> {
            if (relationType == null) {
                return null;
            }
            criteriaQuery.distinct(true);
            return criteriaBuilder.equal(root.joinList("wordRelations").get("relationType"), relationType);
        };
    }
}
