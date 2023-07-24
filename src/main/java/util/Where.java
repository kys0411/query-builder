package util;

public class Where {
    private static final String WHERE = "WHERE";

    private String query;

    private Where(String query) {
        this.query = query;
    }

    String getQuery() {
        return query;
    }

    static public class Builder {
        private StringBuilder query = new StringBuilder();

        public Builder() {
           query.append(" " + WHERE);
        }

        public Builder equals(String column, String value) {
            String statement = String.format(" %s = %s", column, value);
            query.append(statement);

            return this;
        }

        public Builder greater(String column, String value) {
            String statement = String.format(" %s > %s", column, value);
            query.append(statement);

            return this;
        }

        public Builder greaterOrEqual(String column, String value) {
            String statement = String.format(" %s >= %s", column, value);
            query.append(statement);

            return this;
        }

        public Builder less(String column, String value) {
            String statement = String.format(" %s < %s", column, value);
            query.append(statement);

            return this;
        }

        public Builder lessOrEqual(String column, String value) {
            String statement = String.format(" %s <= %s", column, value);
            query.append(statement);

            return this;
        }

        public Builder like(String column, String pattern) {
            String statement = String.format(" %s LIKE %s", column, pattern);
            query.append(statement);

            return this;
        }

        public Builder between(String column, String lessNum, String greaterNum) {
            String statement = String.format(" %s BETWEEN %s AND %s", column, lessNum, greaterNum);
            query.append(statement);

            return this;
        }

        public Builder and() {
            String statement = String.format(" AND");
            query.append(statement);

            return this;
        }

        public Builder or() {
            String statement = String.format(" OR");
            query.append(statement);

            return this;
        }

        public Where build() {
            return new Where(query.toString());
        }
    }
}
