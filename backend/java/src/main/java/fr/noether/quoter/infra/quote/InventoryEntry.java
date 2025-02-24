package fr.noether.quoter.infra.quote;

import fr.noether.quoter.core.shell.Quote;
import fr.noether.quoter.core.shell.QuoteCategory;

public record InventoryEntry(QuoteCategory category, Quote quote){
}
