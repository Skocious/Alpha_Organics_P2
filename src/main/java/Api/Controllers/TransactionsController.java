package Api.Controllers;

import ServiceAccessLayer.*;
import com.google.gson.Gson;
import entities.*;
import io.javalin.core.util.Header;
import io.javalin.http.Handler;

import java.util.ArrayList;
import java.util.List;

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
        List<Transaction> transactions = transactionSO.serviceGetAllTransactionByUsername(transaction.getUsername());
        List<String> jsonTransaction = new ArrayList<>();
        for(Transaction t: transactions){
        String json = gson.toJson(t);
        jsonTransaction.add(json);}
        ctx.result(jsonTransaction.get(transaction.getTransactionId()));
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
