package util;

import domain.Person;
import domain.PersonDto;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

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
                .select(PersonDto.class)
                .from(Person.class)
                .where(where)
                .orderBy(order)
                .build();

        String sql = select.getQuery();
        Assertions.assertEquals(sql, "SELECT id, name FROM Person WHERE age > 10 AND name = aaa ORDER BY id DESC");

    }
}