package fr.noether.quoter.core.shell;

public record QuoteCategory(String title) {


    public static class Builder {
        public static QuoteCategory from(String title) {
            return new QuoteCategory(title);
        }
    }
}


