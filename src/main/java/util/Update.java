package util;

import util.constant.Table;

public class Update {

    private String query;

    private Update(String query) {
        this.query = query;
    }

    public String getQuery() {
        return query;
    }

    static public class Builder {

        private StringBuilder query = new StringBuilder();

        public Builder update(Table table) {
            String statement = String.format("UPDATE %s", table);
            query.append(statement);

            return this;
        }

        public Builder set(String column, String value) {
            String statement = String.format(" SET %s = %s", column, value);
            query.append(statement);

            return this;
        }

        public Builder where(Where where) {
            query.append(where.getQuery());
            return this;
        }

        public Update build() {
            return new Update(query.toString());
        }
    }
}
