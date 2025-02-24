package fr.noether.quoter.api;

import com.google.gson.Gson;
import fr.noether.quoter.core.QuoteCategoryLister;
import fr.noether.quoter.core.QuotePicker;
import fr.noether.quoter.core.shell.Quote;
import fr.noether.quoter.core.shell.QuoteCategory;
import fr.noether.quoter.core.shell.QuoteInventory;
import fr.noether.quoter.infra.quote.FileLister;
import fr.noether.quoter.infra.quote.FileReader;
import fr.noether.quoter.infra.quote.QuoteCategoryListRepository;
import fr.noether.quoter.infra.quote.QuoteFileRepository;
import fr.noether.quoter.infra.random.RandomQuotePick;

import java.util.HashMap;
import java.util.List;

import static spark.Spark.get;

public class QuoteApi {
    public static void main(String[] args) {
        QuotePicker quotePicker = new QuotePicker(
                new QuoteFileRepository(new FileLister(), new FileReader()),
                new RandomQuotePick()
        );

        QuoteCategoryLister quoteCategoryLister = new QuoteCategoryLister(
                new QuoteCategoryListRepository(new FileLister())
        );

        Gson gson = new Gson();

        get("/api/v1/categories", (req, res) -> gson.toJson(quoteCategoryLister.listAll()));
        get("/api/v1/allQuotes", (req, res) -> {
            QuoteInventory inventory = quotePicker.allQuotes();
            var entryMap = new HashMap<String, List<Quote>>();

            inventory.inventory()
                    .forEach((key, value) -> entryMap.put(key.title(), value.quoteList()));

            return  gson.toJson(entryMap);
        });

        get("/api/v1/randomQuoteIn/:category", (req, res) -> {
            String category = req.params(":category");
            Quote quote = quotePicker.pickOne(QuoteCategory.Builder.from(category));
            return gson.toJson(quote);
        });
    }
}
