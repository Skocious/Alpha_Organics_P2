package Api.Controllers;

import ServiceAccessLayer.*;
import com.google.gson.Gson;
import entities.*;
import io.javalin.core.util.Header;
import io.javalin.http.Handler;

import java.util.ArrayList;
import java.util.List;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class TransactionsController {
    public static Logger logger = LogManager.getLogger(TransactionsController.class);
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
        logger.info("Good Transaction Created");
    };

    public Handler getAllTransactionsByUserName = ctx ->{
        String body = ctx.pathParam("username");
        Gson gson = new Gson();
//        Transaction transaction = gson.fromJson(body, Transaction.class);
        List<Transaction> transactions = transactionSO.serviceGetAllTransactionByUsername(body);
        List<String> jsonTransaction = new ArrayList<>();
        for(Transaction t: transactions){
        String json = gson.toJson(t);
        jsonTransaction.add(json);}
        ctx.result(gson.toJson(jsonTransaction));
        ctx.status(200);
        logger.info("Good get all transactions by Username");
    };
}
