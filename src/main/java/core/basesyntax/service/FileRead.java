package core.basesyntax.service;
import java.util.List;

public interface FileRead {
    List<String> readFileContents(String filePath); //the method reads data from a file
}
