package fr.noether.quoter.infra.mock;

import fr.noether.quoter.core.shell.QuoteCategory;
import fr.noether.quoter.infra.quote.QuoteFileReader;

import java.util.Map;

public class FakeQuoteFileContent implements QuoteFileReader {

    private final Map<String, String> content;

    public FakeQuoteFileContent(Map<String, String> content) {
        this.content = content;
    }

    @Override
    public String read(QuoteCategory category) {
        return this.content.getOrDefault(category.title(), "");
    }
}
