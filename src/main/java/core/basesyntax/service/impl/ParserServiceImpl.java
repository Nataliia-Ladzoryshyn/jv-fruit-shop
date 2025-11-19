package core.basesyntax.service.impl;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.model.Operation;
import core.basesyntax.service.ParserService;
import java.util.ArrayList;
import java.util.List;

public class ParserServiceImpl implements ParserService {
    @Override
    public List<FruitTransaction> getFromCsvRow(List<String> line) {
        List<FruitTransaction> result = new ArrayList<>();

        for (int i = 1; i < line.size(); i++) {
            String[] parts = line.get(i).split(",");

            if (parts.length != 3) {
                throw new IllegalArgumentException(" " + line.get(i));
            }
            Operation operation = Operation.fromCode(parts[0]);
            String fruit = parts[1];
            int quantity = Integer.parseInt(parts[2]);

            if (quantity < 0) {
                throw new IllegalArgumentException("Quantity can't be negative: " + quantity);
            }
            result.add(new FruitTransaction(operation, fruit, quantity));
        }
        return result;
    }
}

