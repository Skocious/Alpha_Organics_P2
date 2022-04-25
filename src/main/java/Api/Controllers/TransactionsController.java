package Api.Controllers;

import DataAccessLayer.*;
import ServiceAccessLayer.*;
import com.google.gson.Gson;
import entities.*;
import io.javalin.core.util.Header;
import io.javalin.http.Handler;

public class TransactionsController {
    public TransactionSO transactionSO;

    public TransactionsController(TransactionSO transactionSO){
        this.transactionSO = transactionSO;
    };


    public Handler createTransaction = ctx ->{
        String body = ctx.body();
        Gson gson = new Gson();
        Transaction transaction = gson.fromJson(body, Transaction.class);
        transactionSO.serviceCreateTransaction(transaction);
        ctx.result("Transaction created");
        ctx.status(201);
    };

    public Handler getAllTransactionsByUserName = ctx ->{
        String body = ctx.body();
        Gson gson = new Gson();
        Transaction transaction = gson.fromJson(body, Transaction.class);
        String jsonString = gson.toJson(transactionSO.serviceGetAllTransactionByUsername(transaction.getUsername()));
        ctx.result(jsonString);
        ctx.status(200);
    };


//    public Header createTransaction = ctx ->{
//        ctx.result(1, 1, 1, 3.00, 1);
//        ctx.status(201);
//    };
//
//    public Header getAllTransactionsByProducerId = ctx->{
//        ctx.result(1, 1, 1, 3.00, 10);
//        ctx.status(200);
//    };
}
