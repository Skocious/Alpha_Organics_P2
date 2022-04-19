package Api.Controllers;

import DataAccessLayer.*;
import io.javalin.core.util.Header;

public class LoginControllers {

    public Header selectProducerId = ctx ->{
        ctx.result(LoginImp.Login);
        ctx.result(200);
    };

    public Header selectCustomerId = ctx ->{
        ctx.result(LoginImp.Login);
        ctx.result(200);
    };
}
