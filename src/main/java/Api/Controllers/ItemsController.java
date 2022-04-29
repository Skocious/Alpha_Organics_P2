package Api.Controllers;

import DataAccessLayer.*;
import ServiceAccessLayer.*;
import com.google.gson.Gson;
import customExceptions.BadConnectionError;
import entities.Items;
import io.javalin.core.util.Header;
import io.javalin.http.Handler;



public class ItemsController {


    public ItemsSO itemsSO;

    public ItemsController(ItemsSO itemsSO) {
        this.itemsSO = itemsSO;
    };

    public Handler createItems = ctx ->{
        String body = ctx.body();
        Gson gson = new Gson();
        try {
            Items items = gson.fromJson(body, Items.class);
            String jsonString = gson.toJson(itemsSO.serviceCreateItems(items));
            ctx.result(jsonString);
            ctx.status(201);
        }catch(BadConnectionError e){
            ctx.result(e.getMessage());
            ctx.status(500);
        };
    };

    public Handler selectAllItems = ctx ->{
        String body = ctx.body();
        Gson gson = new Gson();
        try {
            Items items = gson.fromJson(body, Items.class);
            String jsonString = gson.toJson(itemsSO.serviceSelectAllItems());
            ctx.result(jsonString);
            ctx.status(200);
        }catch(BadConnectionError e){
            ctx.result(e.getMessage());
            ctx.status(500);
        };
    };

    public Handler updateItemsById = ctx ->{
        String body = ctx.body();
        Gson gson = new Gson();
        try {
            Items item = gson.fromJson(body, Items.class);
            itemsSO.serviceUpdateItemsById(item);
            ctx.result("Item updated");
            ctx.status(200);
        }catch(BadConnectionError e){
            ctx.result(e.getMessage());
            ctx.status(500);
        };
    };

    public Handler deleteItemsById = ctx ->{
        int body =  Integer.parseInt(ctx.pathParam("itemId"));
        Gson gson = new Gson();
        try{
            itemsSO.serviceDeleteItemsById(body);
            ctx.result("Item deleted");
            ctx.status(200);
        }catch (BadConnectionError e){
            ctx.result(e.getMessage());
            ctx.status(500);
        };
    };
}
