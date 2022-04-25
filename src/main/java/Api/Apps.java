//package Api;
//
//import Api.Controllers.*;
//import DataAccessLayer.*;
//import ServiceAccessLayer.*;
//import io.javalin.Javalin;
//import org.apache.logging.log4j.LogManager;
//import org.apache.logging.log4j.Logger;
//
//public class Apps {
//
//    public static Logger logger = LogManager.getLogger(Apps.class);
//
//    public static void main(String[] args){
//        Javalin app = Javalin.create(config ->{
//            config.enableCorsForAllOrigins();
//            config.enableDevLogging();
//        });
//
//        LoginDAO loginDAO = new LoginImp();
//        LoginSO loginSO = new LoginSImp(loginDAO);
//        LoginControllers loginControllers = new LoginControllers(loginSO);
//
//        ItemsImp itemsDAO = new ItemsImp();
//        ItemsSO itemsSO = new ItemsSImp(itemsDAO);
//        ItemsController itemsController = new ItemsController(itemsSO);
//
//        TransactionDAO transactionDAO = new TransactionImp();
//        TransactionSO transactionsSO = new TransactionSImp(transactionDAO);
//        TransactionsController transactionsController = new TransactionsController(transactionsSO);
//
//        app.post("/items", itemsController.createItems);
//
//        app.get("/items", itemsController.selectAllItems);
//
//        app.put("/items", itemsController.updateItemsById);
//
//        app.delete("/items/{id}", itemsController.deleteItemsById);
//
//        app.post("/customer", loginControllers.selectLoginName);
//
//        app.post("/transactions", transactionsController.createTransaction);
//
//        app.get("/transactions/{producerId}", transactionsController.getAllTransactionByUserName);
//
//        app.post("/items", itemsController.mockCreateItems);
//
//        app.get("/items", itemsController.mockSelectAllItems);
//
//        app.put("/items", itemsController.mockUpdateItemsBYId);
//
//        app.delete("/items/{id}", itemsController.mockDeleteItemsById);
//
//
//    }
//}
