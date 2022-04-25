//package Api.Controllers;
//
//import DataAccessLayer.*;
//import ServiceAccessLayer.*;
//import com.google.gson.Gson;
//import entities.Items;
//import io.javalin.core.util.Header;
//import io.javalin.http.Handler;
//import org.apache.logging.log4j.LogManager;
//import org.apache.logging.log4j.Logger;
//
//
//public class ItemsController {
//
//    public static Logger logger = LogManager.getLogger(ItemsController.class);
//
//    public ItemsSO itemsSO;
//
//    public ItemsController(ItemsSO itemsSO) {
//        this.itemsSO = itemsSO;
//    };
//
//    public Handler createItems = ctx ->{
//        String body = ctx.body();
//        Gson gson = new Gson();
//        Items items = gson.fromJson(body, Items.class);
//        logger.info("Attempting to add item to inventory");
//        itemsSO.serviceCreateItems(items);
//        ctx.result("Item added to inventory");
//        ctx.status(201);
//        logger.info("Item added to inventory");
//    };
//
//    public Handler selectAllItems = ctx ->{
//        String body = ctx.body();
//        Gson gson = new Gson();
//        Items items = gson.fromJson(body, Items.class);
//        String jsonString = gson.toJson(itemsSO.serviceSelectAllItems());
//        ctx.result(jsonString);
//        ctx.status(200);
//    };
//
//    public Handler updateItemsById = ctx ->{
//        String body = ctx.body();
//        Gson gson = new Gson();
//        Items items = gson.fromJson(body, Items.class);
//        itemsSO.serviceUpdateItemsById(items);
//        ctx.result("Item updated");
//        ctx.status(200);
//    };
//
//    public Handler deleteItemsById = ctx ->{
//        String body = ctx.body();
//        Gson gson = new Gson();
//        Items items = gson.fromJson(body, Items.class);
//        itemsSO.serviceDeleteItemsById(items.getItemId());
//        ctx.result("Item deleted");
//        ctx.status(200);
//    };
//
//    public Header createItems = ctx ->{
//        ctx.result(1, 1, "Milk", 3.00);
//        ctx.status(200);
//    };
//
//    public Header selectAllItems = ctx ->{
//        ctx.result(4, 1, "goat", "brown goat", 99.99);
//        ctx.status(200);
//    };
//
//    public Header selectAllItems = ctx ->{
//        ctx.result(ItemsImp.itemsList);
//        ctx.status(200);
//    };
//
//    public Header updateItemsById = ctx ->{
//        ctx.result(4, 1, "eggs", "dozen large grade eggs", 6.00);
//        ctx.status(200);
//    };
//
//    public Header deleteItemsById = ctx ->{
//        ctx.result("Item deleted");
//        ctx.status(200);
//    };
//}
