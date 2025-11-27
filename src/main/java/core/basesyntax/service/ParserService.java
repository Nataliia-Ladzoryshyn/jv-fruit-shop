package core.basesyntax.service;

import core.basesyntax.model.FruitTransaction;
import java.util.List;

public interface ParserService {
    List<FruitTransaction> getFromCsvRow(List<String> csvRows);
    //the method parses the lines of the source file
}
