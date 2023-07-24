package util;

import util.constant.Table;

public class Delete {

    private String query;

    private Delete(String query) {
        this.query = query;
    }

    public String getQuery() {
        return query;
    }

    static public class Builder {

        private StringBuilder query = new StringBuilder();

        public Builder delete(Table table) {
            String statement = String.format("DELETE FROM %s", table);
            query.append(statement);

            return this;
        }

        public Builder where(Where where) {
            query.append(where.getQuery());

            return this;
        }

        public Delete build() {
            return new Delete(query.toString());
        }
    }
}
