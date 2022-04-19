//package Api.Controllers;
//
//import DataAccessLayer.*;
//import io.javalin.core.util.Header;
//
//public class ItemsController {
//
//    public Header createItems = ctx ->{
//        ctx.result(1, 1, "Milk", 3.00);
//        ctx.result(200);
//    };
//
//    public Header selectItemsById = ctx ->{
//        ctx.result(4, 1, "goat", "brown goat", 99.99);
//        ctx.result(200);
//    };
//
//    public Header selectAllItems = ctx -> {
//        ctx.result(ItemsImp.itemsList);
//        ctx.result(200);
//    };
//
//    public Header updateItemsById = ctx -> {
//        ctx.result(4, 1, "eggs", "dozen large grade eggs", 6.00);
//        ctx.result(200);
//    };
//
//    public Header deleteItemsById = ctx ->{
//        ctx.result("Item deleted");
//        ctx.result(200);
//    };
//}
