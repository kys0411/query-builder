package util;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static util.constant.Table.PERSON;

class InsertTest {

    @Test
    @DisplayName("Insert문 테스트")
    void insertTest() {
        String[] columns = new String[]{"id", "name", "age", "email"};
        String[] values = new String[]{"1", "aaa", "20", "hello@gmail.com"};

        Insert insert = new Insert.Builder()
                .insert(PERSON)
                .values(columns, values)
                .build();

        String sql = insert.getQuery();

        Assertions.assertEquals(sql, "INSERT INTO PERSON (id,name,age,email) VALUES (1,aaa,20,hello@gmail.com)");
    }
}