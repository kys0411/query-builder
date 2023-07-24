package util;

import util.constant.Table;

public class Insert {

    private String query;

    private Insert(String query) {
        this.query = query;
    }

    public String getQuery() {
        return query;
    }

    static public class Builder {

        private StringBuilder query = new StringBuilder();
        private StringBuilder subQuery = new StringBuilder();

        public Builder insert(Table table) {
            String statement = String.format("INSERT INTO %s", table);
            query.append(statement);

            return this;
        }

        public Builder values(String[] columns, String[] values) {

            query.append(" (");
            subQuery.append(" (");

            for (int i = 0; i < columns.length; i++) {
                query.append(columns[i] + ",");
                subQuery.append(values[i] + ",");
            }

            query.deleteCharAt(query.length() - 1);
            subQuery.deleteCharAt(subQuery.length() - 1);

            query.append(") ").append("VALUES");
            subQuery.append(")");

            query.append(subQuery);
           // "(%s, %s, %s) VALUES (%s, %s, %S)"

            return this;
        }

        public Insert build() {
            return new Insert(query.toString());
        }
    }
}
