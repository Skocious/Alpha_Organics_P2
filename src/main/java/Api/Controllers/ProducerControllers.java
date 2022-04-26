package Api.Controllers;

import ServiceAccessLayer.*;
import com.google.gson.Gson;
import entities.Producer;
import io.javalin.core.util.Header;
import io.javalin.http.Handler;

public class ProducerControllers {
    public ProducerSO producerSO;
    public ProducerControllers(ProducerSO producerSO){
        this.producerSO = producerSO;
    };

    public Handler getProducerId = ctx ->{
        String body = ctx.body();
        Gson gson = new Gson();
        Producer producer = gson.fromJson(body, Producer.class);
        producerSO.serviceSelectProducerId(producerId);
        ctx.result(Producer);
        ctx.status(200);
    };

    public Header getProducerId =ctx ->{
        ctx.result(Producer);
        ctx.result(200);
    };
}
