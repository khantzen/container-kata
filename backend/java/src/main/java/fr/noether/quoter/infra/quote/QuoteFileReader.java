package fr.noether.quoter.infra.quote;

import fr.noether.quoter.core.shell.QuoteCategory;

public interface QuoteFileReader {
    String read(QuoteCategory category);
}
