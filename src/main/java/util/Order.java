package util;

import util.constant.OrderType;

import static util.constant.Symbol.*;
import static util.constant.Symbol.COMMA;

public class Order {

    private static final String ORDER_BY = "ORDER BY";

    private StringBuilder query;

    private Order(StringBuilder query) {
        this.query = query;
    }

    StringBuilder getQuery() {
        return query;
    }

    static public class Builder {
        private StringBuilder query = new StringBuilder();

        public Builder() {
            query.append(BLANK.getSymbol()).append(ORDER_BY);
        }

        public Builder query(String column, OrderType type) {
            query.append(BLANK.getSymbol())
                    .append(column)
                    .append(BLANK.getSymbol())
                    .append(type)
                    .append(COMMA.getSymbol());

            return this;
        }

        public Builder query(String column) {
            query.append(BLANK.getSymbol())
                    .append(column)
                    .append(COMMA.getSymbol());

            return this;
        }

        public Order build() {
            query.deleteCharAt(query.length() - 1);
            return new Order(query);
        }
    }
}
