package util;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static util.Order.Type.DESC;
import static util.constant.Table.PERSON;

class SelectTest {

    @Test
    @DisplayName("select문 테스트")
    void selectTest() {
        Where where = new Where.Builder()
                .greater("age", "10")
                .and()
                .equals("name", "aaa")
                .build();

        Order order = new Order.Builder()
                .query("id", DESC)
                .build();

        Select select = new Select.Builder()
                .select("*")
                .from(PERSON)
                .where(where)
                .orderBy(order)
                .build();

        String sql = select.getQuery();
        Assertions.assertEquals(sql, "SELECT * FROM PERSON WHERE age > 10 AND name = aaa ORDER BY id DESC");
    }
}