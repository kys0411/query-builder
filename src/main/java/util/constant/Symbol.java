package util.constant;

public enum Symbol {
    BLANK(" "),
    EQUAL("="),
    QUESTION_MARK("?"),
    LEFT_PARENTHESIS("("),
    RIGHT_PARENTHESIS(")"),
    COMMA(","),
    LESS_THAN_SIGN("<"),
    GREATER_THAN_SIGN(">"),
    LESS_OR_EQUAL("<="),
    GREATER_OR_EQUAL(">=")
    ;

    private final String symbol;

    Symbol(String symbol) {
        this.symbol = symbol;
    }

    public String getSymbol() {
        return symbol;
    }
}
