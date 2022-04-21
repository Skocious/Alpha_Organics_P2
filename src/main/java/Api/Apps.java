package Api;

import Api.Controllers.*;
import DataAccessLayer.*;
import ServiceAccessLayer.*;
import io.javalin.Javalin;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Apps {

    public static Logger logger = LogManager.getLogger(Apps.class);

    public static void main(String[] args){
        Javalin app = Javalin.create(config ->{
            config.enableCorsForAllOrigins();
            config.enableDevLogging();
        });
        Logger.info("Javalin object created");

        ProducerDAO producerDAO = new ProducerImp();
        ProducerSO producerSO = new ProducerSImp(producerDAO);
        ProducerControllers producerControllers = new ProducerControllers(producerSO);

        LoginDAO loginDAO = new LoginImp();
        LoginSO loginSO = new LoginSImp(loginDAO);
        LoginControllers loginControllers = new LoginControllers(loginSO);

        ItemsImp itemsDAO = new ItemsImp();
        ItemsSO itemsSO = new ItemsSImp(itemsDAO);
        ItemsController itemsController = new ItemsController(itemsSO);

        TransactionDAO transactionDAO = new TransactionImp();
        TransactionSO transactionsSO = new TransactionSImp(transactionDAO);
        TransactionsController transactionsController = new TransactionsController(transactionsSO);

        app.post("/items", itemsController.createItems);

        app.get("/items", itemsController.selectAllItems);

        app.put("/items", itemsController.updateItemsById);

        app.delete("/items/{id}", itemsController.deleteItemsById);

        app.post("/producer", loginControllers.selectProducerId);

        app.post("/customer", LoginControllers.selectCustomerId);

        app.post("/transactions", transactionsController.createTransaction);

        app.get("/transactions/{producerId}", transactionsController.getAllTransactionByCustomerId);

        app.get("/transactions/{customerId}", transactionsController.getAllTransactionsByProducerId);

        app.get("/producer", producerControllers.getProducerId);
    }
}
