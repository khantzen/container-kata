package fr.noether.quoter.core.shell;

import fr.noether.quoter.core.repository.RandomPicker;

import java.util.HashMap;
import java.util.Map;

public record QuoteInventory(Map<QuoteCategory, QuoteList> inventory) {
    public Quote quoteFrom(QuoteCategory category, RandomPicker random) {
        return this.inventory.getOrDefault(category, QuoteList.Builder.empty())
                .random(random);
    }

    public QuoteInventory append(QuoteCategory category, Quote quote) {
        var newQuoteList = newCategoryQuoteList(category, quote);
        return new QuoteInventory(currentInventoryWith(category, newQuoteList));
    }

    private QuoteList newCategoryQuoteList(QuoteCategory category, Quote quote) {
        return quoteListFor(category).append(quote);
    }

    private QuoteList quoteListFor(QuoteCategory category) {
        return this.inventory.getOrDefault(category, QuoteList.Builder.empty());
    }

    private HashMap<QuoteCategory, QuoteList> currentInventoryWith(QuoteCategory category, QuoteList newQuoteList) {
        var newInventory = new HashMap<>(this.inventory);
        newInventory.put(category, newQuoteList);
        return newInventory;
    }

    public static class Builder {
        public static QuoteInventory empty() {
            return new QuoteInventory(new HashMap<>());
        }
    }
}

