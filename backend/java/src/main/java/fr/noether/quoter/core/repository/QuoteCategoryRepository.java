package fr.noether.quoter.core.repository;

import fr.noether.quoter.core.shell.QuoteCategory;

import java.util.List;

public interface QuoteCategoryRepository {
    List<QuoteCategory> listAll();
}
