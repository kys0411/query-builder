package util;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static util.Order.Type.ASC;
import static util.Order.Type.DESC;

class OrderTest {

    @Test
    @DisplayName("order by문 테스트")
    void orderTest() {

        Order order = new Order.Builder()
                .query("id", DESC)
                .build();

        Order order2 = new Order.Builder()
                .query("age", ASC)
                .build();

        String orderQuery = order.getQuery();
        String orderQuery2 = order2.getQuery();

        Assertions.assertEquals(orderQuery, " ORDER BY id DESC");
        Assertions.assertEquals(orderQuery2, " ORDER BY age ASC");
    }

    @Test
    @DisplayName("여러 조건의 order by문 테스트")
    void orderTest2() {

        Order order = new Order.Builder()
                .query("id", DESC)
                .query("age", ASC)
                .build();

        String orderQuery = order.getQuery();

        Assertions.assertEquals(orderQuery, " ORDER BY id DESC, age ASC");
    }
}