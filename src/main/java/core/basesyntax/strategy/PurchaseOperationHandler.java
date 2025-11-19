package core.basesyntax.strategy;

import core.basesyntax.model.FruitTransaction;
import java.util.Map;

public class PurchaseOperationHandler implements OperationHandler {
    @Override
    public void getActivities(Map<String, Integer> storage, FruitTransaction fruit) {
        storage.put(fruit.getFruit(),
                storage.getOrDefault(fruit.getFruit(), 0) - fruit.getQuantity());
    }
}
