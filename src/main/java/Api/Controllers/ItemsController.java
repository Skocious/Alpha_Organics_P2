//package Api.Controllers;
//
//import DataAccessLayer.*;
//import ServiceAccessLayer.*;
//import com.google.gson.Gson;
//import entities.Items;
//import io.javalin.core.util.Header;
//import io.javalin.http.Handler;
//
//
//
//public class ItemsController {
//    public ItemsSO itemsimp;
//
//    public ItemsController(ItemsSO itemsimp){
//
//        this.itemsimp = itemsimp;
//    }
//
//    public Handler createItems = ctx ->{
//        String body = ctx.body();
//        Gson gson = new Gson();
//        Items items = gson.fromJson(body, Items.class);
//        itemsimp.serviceCreateItems(items);
//        ctx.result("Item added to inventory");
//        ctx.status(201);
//    };
//
//    public Handler selectAllItemsById = ctx ->{};
//
//    public Handler updateItemsById = ctx ->{
//        String body = ctx.body();
//        Gson gson = new Gson();
//        Items items = gson.fromJson(body, Items.class);
//        for(Items i : items){
//            if(i.getItem_id() == items.getItem_id()){
//                int index = items.indexOf(i);
//                items.set(index, items);
//                String itemsJson = gson.toJson(items);
//                ctx.result(itemsJson);
//                ctx.status(200);
//            }
//        }
//    };
//
//    public Handler deleteItemsById = ctx ->{
//        int id = Integer.parseInt(ctx.pathParam("id"));
//        int index = -1;
//        for(Items i: items){
//            if(i.getItem_id() == id){
//                index = items.indexOf(i);
//            }
//        }if(index != -1){
//            items.remove(index);
//            ctx.result("Item removed");
//            ctx.status(200);
//        }
//    };
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
//    public Header selectAllItems = ctx ->{
//        ctx.result(ItemsImp.itemsList);
//        ctx.result(200);
//    };
//
//    public Header updateItemsById = ctx ->{
//        ctx.result(4, 1, "eggs", "dozen large grade eggs", 6.00);
//        ctx.result(200);
//    };
//
//    public Header deleteItemsById = ctx ->{
//        ctx.result("Item deleted");
//        ctx.result(200);
//    };
//}
