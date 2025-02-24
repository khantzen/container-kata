package fr.noether.quoter.infra.quote;

import fr.noether.quoter.core.shell.QuoteCategory;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class FileReader implements QuoteFileReader {
    @Override
    public String read(QuoteCategory category) {
        String workingDirectory = System.getProperty("user.dir");
        String filePath = workingDirectory + "/quotes/" + category.title();
        try {
            return new String(Files.readAllBytes(Paths.get(filePath)));
        } catch (IOException e) {
            return "";
        }
    }
}
