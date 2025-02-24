package fr.noether.quoter.infra.quote;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class FileLister implements QuoteFileLister{
    @Override
    public List<String> listAll() {
        String workingDirectory = System.getProperty("user.dir");
        List<String> fileList = new ArrayList<>();
        try(Stream<Path> paths =  Files.walk(Paths.get (workingDirectory + "/quotes"))) {
            fileList = paths.filter(Files::isRegularFile)
                    .map(Path::getFileName)
                    .map(Path::toString)
                    .toList();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return fileList;
    }
}
