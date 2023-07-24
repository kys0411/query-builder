package util;

import util.statement.Set;
import util.statement.Update;

import static util.constant.Symbol.BLANK;

public class UpdateBuilder {
    private static final String UPDATE = "UPDATE";

    private StringBuilder query = new StringBuilder();

    public UpdateBuilder update(Update update) {
        query.append(UPDATE)
                .append(BLANK.getSymbol())
                .append(update.getTable());
        return this;
    }

    public UpdateBuilder set(Set set) {
        query.append(set.getQuery());
        return this;
    }

    public UpdateBuilder where(Where where) {
        query.append(where.getQuery());
        return this;
    }

    public String build() {
        return query.toString();
    }
}
