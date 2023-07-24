import util.Order;
import util.SelectBuilder;
import util.Where;
import util.statement.From;
import util.statement.Select;

import static util.constant.OrderType.DESC;
import static util.constant.Table.PERSON;

public class Main {
    public static void main(String[] args) {
        Select select = new Select("*");

        From from = new From(PERSON);

        Where where = new Where.Builder()
                .greater("age")
                .and()
                .equals("name")
                .build();

        Order order = new Order.Builder()
                .query("id", DESC)
                .build();

        String sql = new SelectBuilder()
                .select(select)
                .from(from)
                .where(where)
                .orderBy(order)
                .build();

        System.out.println(sql);
    }
}
