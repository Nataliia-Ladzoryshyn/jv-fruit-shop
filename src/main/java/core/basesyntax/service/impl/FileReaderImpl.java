package core.basesyntax.service.impl;

import core.basesyntax.service.FileRead;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class FileReaderImpl implements FileRead {

    @Override
    public List<String> fileReader(String lineText) {
        List<String> lines = new ArrayList<>();
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(lineText))) {
            String s = bufferedReader.readLine();
            while (s != null) {
                lines.add(s);
                s = bufferedReader.readLine();
            }
        } catch (IOException e) {
            throw new RuntimeException("Can't get data from file " + lineText, e);
        }
        return lines;
    }
}

