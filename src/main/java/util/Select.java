package util;

import util.constant.Table;

public class Select {

    private String query;

    private Select(String query) {
        this.query = query;
    }

    public String getQuery() {
        return query;
    }

    static public class Builder {

        private StringBuilder query = new StringBuilder();

        public Builder select(String column) {
            String statement = String.format("SELECT %s", column);
            query.append(statement);

            return this;
        }

        public Builder from(Table table) {
            String statement = String.format(" FROM %s", table);
            query.append(statement);

            return this;
        }

        public Builder where(Where where) {
            query.append(where.getQuery());
            return this;
        }

        public Builder orderBy(Order order) {
            query.append(order.getQuery());
            return this;
        }

        public Select build() {
            return new Select(query.toString());
        }
    }
}
