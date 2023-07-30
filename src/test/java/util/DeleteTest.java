package util;

import domain.Person;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static util.operator.Operator.LESS_THAN;

class DeleteTest {

    @Test
    @DisplayName("Delete문 테스트")
    void deleteTest() {

        Where where = Where.builder("id", LESS_THAN, 10).build();

        Delete delete = Delete.builder()
                .delete(Person.class)
                .where(where)
                .build();

        String sql = delete.getQuery();

        Assertions.assertEquals(sql, "DELETE FROM Person WHERE id < 10");
    }
}