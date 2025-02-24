package fr.noether.quoter.core.shell;

public record Quote(String text) {
    public String text() {
        return this.text;
    }

    public static class Builder {
        public static Quote empty() {
            return new Quote("");
        }

        public static Quote with(String text) {
            return new Quote(text);
        }
    }
}
