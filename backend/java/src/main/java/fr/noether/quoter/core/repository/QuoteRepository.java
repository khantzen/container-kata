package fr.noether.quoter.core.repository;

import fr.noether.quoter.core.shell.QuoteInventory;

public interface QuoteRepository {
    QuoteInventory fetchAll();
}
