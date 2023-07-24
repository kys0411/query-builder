package util;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class WhereTest {

    @Test
    @DisplayName("where문 greater 메서드 테스트")
    void greaterTest() {
        Where where = new Where.Builder()
                .greater("age", "20")
                .build();

        Where where2 = new Where.Builder()
                .greaterOrEqual("age", "25")
                .build();

        String whereQuery = where.getQuery();
        String whereQuery2 = where2.getQuery();

        Assertions.assertEquals(whereQuery, " WHERE age > 20");
        Assertions.assertEquals(whereQuery2, " WHERE age >= 25");
    }

    @Test
    @DisplayName("where문 less 메서드 테스트")
    void lessTest() {
        Where where = new Where.Builder()
                .less("age", "40")
                .build();

        Where where2 = new Where.Builder()
                .lessOrEqual("age", "30")
                .build();

        String whereQuery = where.getQuery();
        String whereQuery2 = where2.getQuery();

        Assertions.assertEquals(whereQuery, " WHERE age < 40");
        Assertions.assertEquals(whereQuery2, " WHERE age <= 30");
    }

    @Test
    @DisplayName("where문 between 메서드 테스트")
    void betweenTest() {
        Where where = new Where.Builder()
                .between("age", "10", "20")
                .build();


        String whereQuery = where.getQuery();

        Assertions.assertEquals(whereQuery, " WHERE age BETWEEN 10 AND 20");
    }

    @Test
    @DisplayName("where문 like 메서드 테스트")
    void likeTest() {
        Where where = new Where.Builder()
                .like("email", "%gmail%")
                .build();

        String whereQuery = where.getQuery();

        Assertions.assertEquals(whereQuery, " WHERE email LIKE %gmail%");
    }

    @Test
    @DisplayName("where문 and 메서드 테스트")
    void andTest() {
        Where where = new Where.Builder()
                .greaterOrEqual("age", "20")
                .and()
                .like("email", "%naver%")
                .build();

        String whereQuery = where.getQuery();

        Assertions.assertEquals(whereQuery, " WHERE age >= 20 AND email LIKE %naver%");
    }

    @Test
    @DisplayName("where문 or 메서드 테스트")
    void orTest() {
        Where where = new Where.Builder()
                .greaterOrEqual("age", "20")
                .or()
                .like("name", "김%")
                .build();

        String whereQuery = where.getQuery();

        Assertions.assertEquals(whereQuery, " WHERE age >= 20 OR name LIKE 김%");
    }
}