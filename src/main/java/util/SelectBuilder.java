package util;

import util.statement.From;
import util.statement.Select;

import static util.constant.Symbol.BLANK;
import static util.constant.Symbol.COMMA;

public class SelectBuilder {
    private static final String SELECT = "SELECT";
    private static final String FROM = "FROM";

    private StringBuilder query = new StringBuilder();

    public SelectBuilder select(Select select) {
        query.append(SELECT);

        for (String column : select.getColumns()) {
            query.append(BLANK.getSymbol())
                    .append(column)
                    .append(COMMA.getSymbol());
        }

        query.deleteCharAt(query.length() - 1);

        return this;
    }

    public SelectBuilder from(From from) {
        query.append(BLANK.getSymbol())
                .append(FROM)
                .append(BLANK.getSymbol())
                .append(from.getTable());

        return this;
    }

    public SelectBuilder where(Where where) {
        query.append(where.getQuery());
        return this;
    }

    public SelectBuilder orderBy(Order order) {
        query.append(order.getQuery());
        return this;
    }

    public String build() {
        return query.toString();
    }
}
