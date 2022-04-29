package Api;

import Api.Controllers.*;
import DataAccessLayer.*;
import ServiceAccessLayer.*;
import io.javalin.Javalin;


public class Apps {

    public static void main(String[] args) {
        Javalin app = Javalin.create(config -> {
            config.enableCorsForAllOrigins();
            config.enableDevLogging();
        }).start();


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

        app.delete("/items/{itemId}", itemsController.deleteItemsById);

        app.post("/username", loginControllers.selectLoginName);

        app.post("/transactions", transactionsController.createTransaction);

        app.get("/transactions/{Username}", transactionsController.getAllTransactionsByUserName);

    }
}