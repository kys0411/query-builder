package util;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static util.constant.Table.PERSON;

class DeleteTest {

    @Test
    @DisplayName("Delete문 테스트")
    void deleteTest() {

        Where where = new Where.Builder()
                .between("id", "5", "10")
                .build();

        Delete delete = new Delete.Builder()
                .delete(PERSON)
                .where(where)
                .build();

        String sql = delete.getQuery();

        Assertions.assertEquals(sql, "DELETE FROM PERSON WHERE id BETWEEN 5 AND 10");
    }
}