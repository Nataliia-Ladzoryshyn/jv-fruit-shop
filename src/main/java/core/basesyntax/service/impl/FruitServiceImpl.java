package core.basesyntax.service.impl;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.FruitService;
import core.basesyntax.strategy.OperationStrategy;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FruitServiceImpl implements FruitService {
    private final OperationStrategy strategyHandler;

    public FruitServiceImpl(OperationStrategy strategyHandler) {
        this.strategyHandler = strategyHandler;
    }

    @Override
    public Map<String, Integer> process(List<FruitTransaction> transaction) {
        Map<String, Integer> storage = new HashMap<>();

        for (FruitTransaction fruit : transaction) {
            strategyHandler.getStrategy(fruit.getOperation()).getActivities(storage, fruit);

        }
        return storage;
    }
}
