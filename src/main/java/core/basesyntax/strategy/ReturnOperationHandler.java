package core.basesyntax.strategy;

import core.basesyntax.db.Storage;
import core.basesyntax.model.FruitTransaction;

public class ReturnOperationHandler implements OperationHandler {
    @Override
    public void handleTransaction(FruitTransaction fruitTransaction) {
        Storage.storageFruit.put(fruitTransaction.getFruit(),
                Storage.storageFruit.getOrDefault(fruitTransaction.getFruit(), 0)
                        + fruitTransaction.getQuantity());
    }
}
