package fr.noether.quoter.infra.quote;

import fr.noether.quoter.core.shell.Quote;
import fr.noether.quoter.core.shell.QuoteCategory;
import fr.noether.quoter.core.shell.QuoteInventory;
import fr.noether.quoter.core.repository.QuoteRepository;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;

public record QuoteFileRepository (
        QuoteFileLister quoteFileLister,
        QuoteFileReader quoteFileReader
) implements QuoteRepository  {

    @Override
    public QuoteInventory fetchAll() {
        List<InventoryEntry> allQuotes = fetchQuoteContent();
        return fillInventoryWithQuote(allQuotes);
    }

    private List<InventoryEntry> fetchQuoteContent() {
        return quoteFileLister.listAll()
                .stream()
                .map(QuoteCategory.Builder::from)
                .map(this::toInventoryEntry)
                .flatMap(Collection::stream)
                .toList();
    }

    private QuoteInventory fillInventoryWithQuote(List<InventoryEntry> entries) {
        QuoteInventory inventory = QuoteInventory.Builder.empty();

        for (InventoryEntry entry : entries) {
            inventory = inventory.append(entry.category(), entry.quote());
        }

        return inventory;
    }

    private List<InventoryEntry> toInventoryEntry(QuoteCategory quoteCategory) {
        var rawContent = quoteFileReader.read(quoteCategory);
        List<String> split = Arrays.stream(rawContent.split("%")).toList();

        return split.stream()
                .map(String::trim)
                .filter(it -> !it.isEmpty())
                .map(Quote.Builder::with)
                .map(it -> new InventoryEntry(quoteCategory, it))
                .toList();
    }
}
