package util.statement;

import static util.constant.Symbol.*;

public class Set {
    private static final String SET = "SET";

    private StringBuilder query;

    private Set(StringBuilder query) {
        this.query = query;
    }

    public StringBuilder getQuery() {
        return query;
    }

    static public class Builder {
        private StringBuilder query = new StringBuilder();

        public Builder() {
            query.append(BLANK.getSymbol()).append(SET);
        }

        public Builder query(String column) {
            query.append(BLANK.getSymbol())
                    .append(column)
                    .append(EQUAL.getSymbol())
                    .append(QUESTION_MARK.getSymbol())
                    .append(COMMA.getSymbol());

            return this;
        }

        public Set build() {
            query.deleteCharAt(query.length() - 1);
            return new Set(query);
        }
    }
}
