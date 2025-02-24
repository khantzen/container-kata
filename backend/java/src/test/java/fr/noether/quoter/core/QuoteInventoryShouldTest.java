package fr.noether.quoter.core;

import fr.noether.quoter.core.mock.FakeRandom;
import fr.noether.quoter.core.shell.Quote;
import fr.noether.quoter.core.shell.QuoteCategory;
import fr.noether.quoter.core.shell.QuoteInventory;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class QuoteInventoryShouldTest {

    @Test
    void giveNoQuoteWhenContainingNoQuote() {
        var quoteInventory = QuoteInventory.Builder.empty();
        var quote = quoteInventory.quoteFrom(QuoteCategory.Builder.from("Unit-Test"), new FakeRandom(0));
        Assertions.assertThat(quote.text()).isEmpty();
    }

    @Test
    void giveTheQuoteBelongingToTheCategory() {
        var quoteInventory =
                QuoteInventory.Builder.empty()
                        .append(QuoteCategory.Builder.from("Unit-Test"),
                                Quote.Builder.with("Green Unit-Test pass")
                        );

        var quote = quoteInventory.quoteFrom(QuoteCategory.Builder.from("Unit-Test"), new FakeRandom(0));
        Assertions.assertThat(quote).isEqualTo(Quote.Builder.with("Green Unit-Test pass"));
    }

    @Test
    void returnEmptyQuoteWhenCategoryDoesNotExists() {
        var quoteInventory =
                QuoteInventory.Builder.empty()
                        .append(QuoteCategory.Builder.from("Unit-Test"),
                                Quote.Builder.with("Green Unit-Test pass")
                        );

        var quote = quoteInventory.quoteFrom(QuoteCategory.Builder.from("Star Wars"), new FakeRandom(0));
        Assertions.assertThat(quote).isEqualTo(Quote.Builder.empty());
    }

    @Test
    void shouldReturnRandomQuoteWhenMultipleArePresent() {
        var random = new FakeRandom(1);
        var quoteInventory =
                QuoteInventory.Builder.empty()
                        .append(QuoteCategory.Builder.from("Star Wars"),
                                Quote.Builder.with("May the force be with you."))
                        .append(QuoteCategory.Builder.from("Star Wars"),
                                Quote.Builder.with("Always two, there are. No more. No less. A Master and an apprentice.")
                        );

        var quote = quoteInventory.quoteFrom(QuoteCategory.Builder.from("Star Wars"), random);
        Assertions.assertThat(quote).isEqualTo(Quote.Builder.with("Always two, there are. No more. No less. A Master and an apprentice."));
    }
}
