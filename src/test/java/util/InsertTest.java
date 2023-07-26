package util;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static util.constant.Table.PERSON;

class InsertTest {

    @Test
    @DisplayName("Insert문 테스트")
    void insertTest() {
        Map<String, Object> map = new HashMap<>();

        map.put("id", 1);
        map.put("name", "aaa");
        map.put("age", 20);
        map.put("email", "hello@gmail.com");

        Insert insert = Insert.builder()
                .insert(PERSON)
                .values(map)
                .build();

        String sql = insert.getQuery();
    }
}