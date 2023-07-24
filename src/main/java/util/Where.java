package util;

import static util.constant.Symbol.*;
import static util.constant.WhereType.*;

public class Where {
    private static final String WHERE = "WHERE";

    private StringBuilder query;

    private Where(StringBuilder query) {
        this.query = query;
    }

    StringBuilder getQuery() {
        return query;
    }

    static public class Builder {
        private StringBuilder query = new StringBuilder();

        public Builder() {
           query.append(BLANK.getSymbol()).append(WHERE);
        }

        public Builder equals(String column) {
            query.append(BLANK.getSymbol())
                    .append(column)
                    .append(BLANK.getSymbol())
                    .append(EQUAL.getSymbol())
                    .append(BLANK.getSymbol())
                    .append(QUESTION_MARK.getSymbol());

            return this;
        }

        public Builder greater(String column) {
            query.append(BLANK.getSymbol())
                    .append(column)
                    .append(BLANK.getSymbol())
                    .append(GREATER_THAN_SIGN.getSymbol())
                    .append(BLANK.getSymbol())
                    .append(QUESTION_MARK.getSymbol());

            return this;
        }

        public Builder greaterOrEqual(String column) {
            query.append(BLANK.getSymbol())
                    .append(column)
                    .append(BLANK.getSymbol())
                    .append(GREATER_OR_EQUAL.getSymbol())
                    .append(BLANK.getSymbol())
                    .append(QUESTION_MARK.getSymbol());

            return this;
        }

        public Builder less(String column) {
            query.append(BLANK.getSymbol())
                    .append(column)
                    .append(BLANK.getSymbol())
                    .append(LESS_THAN_SIGN.getSymbol())
                    .append(BLANK.getSymbol())
                    .append(QUESTION_MARK.getSymbol());

            return this;
        }

        public Builder lessOrEqual(String column) {
            query.append(BLANK.getSymbol())
                    .append(column)
                    .append(BLANK.getSymbol())
                    .append(LESS_OR_EQUAL.getSymbol())
                    .append(BLANK.getSymbol())
                    .append(QUESTION_MARK.getSymbol());

            return this;
        }

        public Builder like(String column) {
            query.append(BLANK.getSymbol())
                    .append(column)
                    .append(BLANK.getSymbol())
                    .append(LIKE)
                    .append(BLANK.getSymbol())
                    .append(QUESTION_MARK.getSymbol());

            return this;
        }

        public Builder between(String column) {
            greaterOrEqual(column);
            and();
            lessOrEqual(column);

            return this;
        }

        public Builder and() {
            query.append(BLANK.getSymbol())
                    .append(AND);

            return this;
        }

        public Builder or() {
            query.append(BLANK.getSymbol())
                    .append(OR);

            return this;
        }

        public Where build() {
            return new Where(query);
        }
    }
}
