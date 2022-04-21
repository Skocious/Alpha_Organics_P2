package Api.Controllers;

import DataAccessLayer.*;
import ServiceAccessLayer.*;
import com.google.gson.Gson;
import entities.Producer;
import io.javalin.core.util.Header;
import io.javalin.http.Handler;

public class ProducerControllers {
    ProducerDAO producerDAO = new ProducerImp();
    ProducerSImp producerSImp = new ProducerSImp();

    public Handler getProducerId = ctx ->{
        String body = ctx.body();
        Gson gson = new Gson();
        Producer producer = gson.fromJson(body, Producer.class);
        ProducerSImp.serviceSelectProducerId();
        ctx.result();
        ctx.status(200);
    };

    public Header getProducerId =ctx ->{
        ctx.result(Producer);
        ctx.result(200);
    };
}
