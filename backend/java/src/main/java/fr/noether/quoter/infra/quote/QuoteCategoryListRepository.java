package fr.noether.quoter.infra.quote;

import fr.noether.quoter.core.repository.QuoteCategoryRepository;
import fr.noether.quoter.core.shell.QuoteCategory;

import java.util.List;

public record QuoteCategoryListRepository(QuoteFileLister fileLister)
        implements QuoteCategoryRepository {

    @Override
    public List<QuoteCategory> listAll() {
        return fileLister.listAll().stream()
                .map(QuoteCategory.Builder::from)
                .toList();
    }
}
