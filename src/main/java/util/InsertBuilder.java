package util;

import util.statement.Insert;
import util.statement.Values;

import static util.constant.Symbol.BLANK;

public class InsertBuilder {
    private static final String INSERT = "INSERT INTO";

    private StringBuilder query = new StringBuilder();

    public InsertBuilder insert(Insert insert) {
        query.append(INSERT)
                .append(BLANK.getSymbol())
                .append(insert.getTable());

        return this;
    }

    public InsertBuilder values(Values values) {
        query.append(values.getQuery());
        return this;
    }

    public String build() {
        return query.toString();
    }
}
