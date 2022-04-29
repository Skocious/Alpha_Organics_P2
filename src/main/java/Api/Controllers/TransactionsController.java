package Api.Controllers;

import ServiceAccessLayer.*;
import com.google.gson.Gson;
import customExceptions.BadConnectionError;
import entities.*;
import io.javalin.core.util.Header;
import io.javalin.http.Handler;

import java.util.ArrayList;
import java.util.List;

public class  TransactionsController {
    public TransactionSO transactionSO;

    public TransactionsController(TransactionSO transactionSO){
        this.transactionSO = transactionSO;
    };


    public Handler createTransaction = ctx ->{
        String body = ctx.body();
        Gson gson = new Gson();
        try{
            Transaction transaction = gson.fromJson(body, Transaction.class);
            transactionSO.serviceCreateTransaction(transaction);
            ctx.result("Transaction created");
            ctx.status(201);
        } catch(BadConnectionError e){
            ctx.result(e.getMessage());
            ctx.status(500);
        }
    };

    public Handler getAllTransactionsByUserName = ctx ->{
        String body = ctx.pathParam("Username");
        Gson gson = new Gson();
        try {
            List<Transaction> transactions = transactionSO.serviceGetAllTransactionByUsername(body);
            List<String> jsonTransaction = new ArrayList<>();
            for(Transaction t: transactions){
            String json = gson.toJson(t);
            jsonTransaction.add(json);}
            ctx.result(gson.toJson(jsonTransaction));
            ctx.status(200);
        }catch (BadConnectionError e){
            ctx.result(e.getMessage());
            ctx.status(404);
        }
    };

}
