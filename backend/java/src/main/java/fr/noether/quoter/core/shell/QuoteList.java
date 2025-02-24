package fr.noether.quoter.core.shell;

import fr.noether.quoter.core.repository.RandomPicker;

import java.util.ArrayList;
import java.util.List;

public record QuoteList(List<Quote> quoteList) {
    public QuoteList append(Quote quote) {
        var newQuoteList = new ArrayList<>(quoteList);
        newQuoteList.add(quote);
        return new QuoteList(newQuoteList);
    }

    public Quote random(RandomPicker random) {
        return quoteList.isEmpty() ? Quote.Builder.empty() : quoteList().get(random.nextInt(0, quoteList.size()));
    }

    public static class Builder {
        public static QuoteList empty() {
            return new QuoteList(new ArrayList<Quote>());
        }
    }
}
