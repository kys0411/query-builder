package util;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static util.constant.Table.PERSON;

class UpdateTest {

    @Test
    @DisplayName("update문 테스트")
    void updateTest() {
        Where where = new Where.Builder()
                .equals("id", "1")
                .build();

        Update update = new Update.Builder()
                .update(PERSON)
                .set("name", "bbb")
                .where(where)
                .build();

        String sql = update.getQuery();
        Assertions.assertEquals(sql, "UPDATE PERSON SET name = bbb WHERE id = 1");
    }
}