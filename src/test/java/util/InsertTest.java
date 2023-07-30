package util;

import domain.Person;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

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
                .insert(Person.class)
                .values(map)
                .build();

        String sql = insert.getQuery();
    }
}