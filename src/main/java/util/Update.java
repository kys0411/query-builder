package util;

import util.constant.Table;

import java.util.ArrayList;
import java.util.List;

public class Update {

    private String query;

    private Update(String query) {
        this.query = query;
    }

    public String getQuery() {
        return query;
    }

    public static Builder builder() {
        return new Builder();
    }

    static public class Builder {

        private static final String UPDATE = "UPDATE";
        private static final String SET = "SET";

        private List<String> query = new ArrayList<>();

        private Builder() {

        }

        public Builder update(Table table) {
            query.add(table.name());

            return this;
        }

        public Builder set(String column, Object value) {
            String statement = String.format("%s %s = %s", SET, column, value);
            query.add(statement);

            return this;
        }

        public Builder where(Where where) {
            query.add(where.getQuery());
            return this;
        }

        public Update build() {
            String join = String.join(" ", query);
            return new Update("%s %s".formatted(UPDATE, join));
        }
    }
}
