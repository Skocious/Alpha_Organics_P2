//package Api;
//
//import Api.Controllers.*;
//import DataAccessLayer.*;
//import ServiceAccessLayer.*;
//import io.javalin.Javalin;
//
//public class Apps {
//    public static void main(String[] args){
//        Javalin app = Javalin.create(config ->{
//            config.enableCorsForAllOrigins();
//            config.enableDevLogging();
//        });
//        CustomerDAO customerDAO = new CustomerImp();
//        CustomerSO customerSO = new CustomerSImp(customerDAO);
//        CustomerControllers customerControllers = new CustomerControllers(customerSO);
//
//        ProducerDAO producerDAO = new ProducerImp();
//        ProducerSO producerSO = new ProducerSImp(producerDAO);
//        ProducerControllers producerControllers = new ProducerControllers(producerSO);
//
//        LoginDAO loginDAO = new LoginImp();
//        LoginSO loginSO = new LoginSImp(loginDAO);
//        LoginControllers loginControllers = new LoginControllers(loginSO);
//
//        ItemsDAO itemsDAO = new ItemsImp();
//        ItemsSO itemsSO = new ItemsSImp(itemsDAO);
//        ItemsController itemsController = new ItemsController(itemsSO);
//
//        app.post("/items", itemsController.createItems);
//
//        app.get("/items/:itemId", itemsController.selectItemsById);
//
//        app.get("/items", itemsController.selectAllItems);
//
//        app.put("/items/update", itemsController.updateItemsbyId);
//
//        app.delete("/items/delete", itemsController.deleteItemsById);
//
//    }
//}
