package fr.noether.quoter.core;


import fr.noether.quoter.core.repository.QuoteCategoryRepository;
import fr.noether.quoter.core.shell.QuoteCategory;

import java.util.List;

public record QuoteCategoryLister(QuoteCategoryRepository categoryRepository) {

    public List<QuoteCategory> listAll() {
        return this.categoryRepository.listAll();
    }
}
