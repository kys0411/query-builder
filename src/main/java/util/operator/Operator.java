package util.operator;

public enum Operator {
    EQUALS("="),
    GREATER_THAN(">"),
    LESS_THAN("<");

    private final String symbol;

    Operator(String symbol) {
        this.symbol = symbol;
    }

    public String getSymbol() {
        return symbol;
    }
}
