package util;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import util.operator.Operator;

import static util.constant.Table.PERSON;
import static util.operator.Operator.EQUALS;
import static util.operator.Operator.GREATER_THAN;

class SelectTest {

    @Test
    @DisplayName("select문 테스트")
    void selectTest() {
        Where where = Where.builder("age", GREATER_THAN, 10)
                .and("name", EQUALS, "aaa")
                .build();


        Order order = Order.builder()
                .desc("id")
                .build();

        Select select = Select.builder()
                .select("*")
                .from(PERSON)
                .where(where)
                .orderBy(order)
                .build();

        String sql = select.getQuery();
        Assertions.assertEquals(sql, "SELECT * FROM PERSON WHERE age > 10 AND name = aaa ORDER BY id DESC");
    }
}