package fr.noether.quoter.core;

import fr.noether.quoter.core.repository.QuoteRepository;
import fr.noether.quoter.core.repository.RandomPicker;
import fr.noether.quoter.core.shell.Quote;
import fr.noether.quoter.core.shell.QuoteCategory;
import fr.noether.quoter.core.shell.QuoteInventory;

public class QuotePicker {
    private final QuoteRepository quoteRepository;
    private final RandomPicker randomPicker;

    public QuotePicker(QuoteRepository quoteRepository, RandomPicker randomPicker) {
        this.quoteRepository = quoteRepository;
        this.randomPicker = randomPicker;
    }

    public Quote pickOne(QuoteCategory quoteCategory) {
        QuoteInventory inventory = quoteRepository.fetchAll();
        return inventory.quoteFrom(quoteCategory, randomPicker);
    }

    public QuoteInventory allQuotes() {
        return quoteRepository.fetchAll();
    }
}
