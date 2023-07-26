package util;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static util.constant.Table.PERSON;
import static util.operator.Operator.EQUALS;

class UpdateTest {

    @Test
    @DisplayName("update문 테스트")
    void updateTest() {
        Where where = Where.builder("id", EQUALS, 1).build();

        Update update = Update.builder()
                .update(PERSON)
                .set("name", "bbb")
                .where(where)
                .build();

        String sql = update.getQuery();
        Assertions.assertEquals(sql, "UPDATE PERSON SET name = bbb WHERE id = 1");
    }
}