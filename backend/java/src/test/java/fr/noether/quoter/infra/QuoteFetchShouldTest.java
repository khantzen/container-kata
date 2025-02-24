package fr.noether.quoter.infra;

import fr.noether.quoter.core.shell.Quote;
import fr.noether.quoter.core.shell.QuoteCategory;
import fr.noether.quoter.core.shell.QuoteInventory;
import fr.noether.quoter.infra.mock.FakeQuoteFileContent;
import fr.noether.quoter.infra.mock.FakeQuoteFileList;
import fr.noether.quoter.infra.quote.QuoteFileRepository;
import org.junit.jupiter.api.Test;

import java.util.HashMap;

import static org.assertj.core.api.Assertions.*;

public class QuoteFetchShouldTest {

    @Test
    void returnQuoteInventoryOneFile() {
        var fakeQuotesFile = new FakeQuoteFileList("unit_test");
        var unitTestMap = new HashMap<String, String>();
        unitTestMap.put("unit_test", unitTestFileContent());
        var quoteFileContent = new FakeQuoteFileContent(unitTestMap);

        var quoteFileRepo = new QuoteFileRepository(fakeQuotesFile, quoteFileContent);

        var actualQuoteInventory = quoteFileRepo.fetchAll();

        var expectedQuoteInventory = QuoteInventory.Builder.empty()
                        .append(QuoteCategory.Builder.from("unit_test"),
                                Quote.Builder.with("A passing unit test should be green."))
                        .append(QuoteCategory.Builder.from("unit_test"),
                                Quote.Builder.with("A non passing unit test should be red.\n" +
                                                         "    So you should make it pass."))
                .append(QuoteCategory.Builder.from("unit_test"), Quote.Builder.with("A non compiling unit test should be red."));

        assertThat(actualQuoteInventory).isEqualTo(expectedQuoteInventory);
    }

    @Test
    void returnQuoteInventoryMultiFile() {
        var fakeQuotesFile = new FakeQuoteFileList("unit_test", "star_wars");
        var unitTestMap = new HashMap<String, String>();
        unitTestMap.put("unit_test", unitTestFileContent());
        unitTestMap.put("star_wars", starWarsFileContent());

        var quoteFileContent = new FakeQuoteFileContent(unitTestMap);

        var quoteFileRepo = new QuoteFileRepository(fakeQuotesFile, quoteFileContent);
        var actualQuoteInventory = quoteFileRepo.fetchAll();

        var expectedQuoteInventory = QuoteInventory.Builder.empty()
                .append(QuoteCategory.Builder.from("unit_test"),
                        Quote.Builder.with("A passing unit test should be green."))
                .append(QuoteCategory.Builder.from("star_wars"),
                        Quote.Builder.with("May the force be with you."))
                .append(QuoteCategory.Builder.from("star_wars"),
                        Quote.Builder.with("Always two, there are. No more. No less. A Master and an apprentice."))
                .append(QuoteCategory.Builder.from("unit_test"),
                        Quote.Builder.with("A non passing unit test should be red.\n" +
                                "    So you should make it pass."))
                .append(QuoteCategory.Builder.from("unit_test"), Quote.Builder.with("A non compiling unit test should be red."));

        assertThat(actualQuoteInventory).isEqualTo(expectedQuoteInventory);
    }

    private String starWarsFileContent() {
        return """
                May the force be with you.
                %
                Always two, there are. No more. No less. A Master and an apprentice.
                %""";
    }

    private String unitTestFileContent() {
        return """
                A passing unit test should be green.
                %
                A non passing unit test should be red.
                    So you should make it pass.
                %
                A non compiling unit test should be red.
                %""";
    }
}

