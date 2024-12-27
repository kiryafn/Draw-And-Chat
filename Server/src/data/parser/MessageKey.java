package data.parser;

public enum MessageKey {
    TYPE("type"),
    PREFIX("prefix"),
    SENDER("sender"),
    MESSAGE("message"),
    X("x"),
    Y("y"),
    RED("red"),
    GREEN("green"),
    BLUE("blue"),
    SIZE("size");

    private final String key;

    MessageKey(String key) {
        this.key = key;
    }

    public String getKey() {
        return key;
    }

    @Override
    public String toString() {
        return key;
    }
}