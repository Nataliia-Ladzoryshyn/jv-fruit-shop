package core.basesyntax;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.model.Operation;
import core.basesyntax.service.FileRead;
import core.basesyntax.service.FileWriter;
import core.basesyntax.service.FruitService;
import core.basesyntax.service.ParserService;
import core.basesyntax.service.impl.FileReadImpl;
import core.basesyntax.service.impl.FileWriterImpl;
import core.basesyntax.service.impl.FruitServiceImpl;
import core.basesyntax.service.impl.ParserServiceImpl;
import core.basesyntax.strategy.BalanceOperationHandler;
import core.basesyntax.strategy.OperationHandler;
import core.basesyntax.strategy.OperationStrategy;
import core.basesyntax.strategy.PurchaseOperationHandler;
import core.basesyntax.strategy.ReturnOperationHandler;
import core.basesyntax.strategy.SupplyOperationHandler;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        Map<Operation, OperationHandler> strategyMap = Map.of(
                Operation.BALANCE, new BalanceOperationHandler(),
                Operation.SUPPLY, new SupplyOperationHandler(),
                Operation.PURCHASE, new PurchaseOperationHandler(),
                Operation.RETURN, new ReturnOperationHandler());

        OperationStrategy strategy = new OperationStrategy(strategyMap);

        FileRead reader = new FileReadImpl();
        ParserService parser = new ParserServiceImpl();
        FruitService fruitService = new FruitServiceImpl(strategy);
        FileWriter writer = new FileWriterImpl();

        List<String> lines = reader.readFileContents("src/main/resources/database.csv");
        List<FruitTransaction> transactions = parser.getFromCsvRow(lines);
        Map<String, Integer> report = fruitService.process(transactions);
        List<String> output = new ArrayList<>();
        output.add("fruit, quantity");

        report.forEach((fruit, quantity) -> output.add(fruit + "," + quantity));
        writer.write(output, "src/main/resources/result.csv");
        System.out.println("Report created: " + "result.csv");
    }
}
