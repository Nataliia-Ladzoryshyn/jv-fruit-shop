package core.basesyntax.strategy;

import core.basesyntax.model.FruitTransaction;
import java.util.Map;

public class BalanceOperationHandler implements OperationHandler {

    @Override
    public void getActivities(Map<String, Integer> storage, FruitTransaction fruit) {
        storage.put(fruit.getFruit(), fruit.getQuantity());
    }
}
