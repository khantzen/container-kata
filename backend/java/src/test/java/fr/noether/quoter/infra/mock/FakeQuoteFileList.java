package fr.noether.quoter.infra.mock;

import fr.noether.quoter.infra.quote.QuoteFileLister;

import java.util.Arrays;
import java.util.List;

public record FakeQuoteFileList(String... fileList) implements QuoteFileLister {
    @Override
    public List<String> listAll() {
        return Arrays.stream(fileList).toList();
    }
}
