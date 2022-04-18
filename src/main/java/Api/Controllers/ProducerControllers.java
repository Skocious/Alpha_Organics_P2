package Api.Controllers;

import entities.Producer;
import io.javalin.core.util.Header;

public class ProducerControllers {

    public Header getProducerId =ctx ->{
        ctx.result(Producer);
        ctx.result(200);
    };
}
