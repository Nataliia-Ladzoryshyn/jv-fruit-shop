package core.basesyntax.service;
import java.util.List;

public interface FileWriter {
    void write(List<String> data, String filePath); //the method writes data to the filePath.csv
}
