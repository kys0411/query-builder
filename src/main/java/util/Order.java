package util;

public class Order {
    public enum Type {
        ASC, DESC
    }

    private String query;

    private Order(String query) {
        this.query = query;
    }

    public String getQuery() {
        return query;
    }

    static public class Builder {
        private StringBuilder query = new StringBuilder();

        public Builder() {
            String statement= String.format(" ORDER BY");
            query.append(statement);
        }

        public Builder query(String column, Type type) {
            String statement= String.format(" %s %s,", column, type);
            query.append(statement);

            return this;
        }

        public Builder query(String column) {
            String statement= String.format(" %s,", column);
            query.append(statement);

            return this;
        }

        public Order build() {
            query.deleteCharAt(query.length() - 1);

            return new Order(query.toString());
        }
    }
}
