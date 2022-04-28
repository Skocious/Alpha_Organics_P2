package Api.Controllers;

import ServiceAccessLayer.*;
import com.google.gson.Gson;
import customExceptions.LoginError;
import entities.*;
import io.javalin.http.Handler;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class LoginControllers {
    public static Logger logger = LogManager.getLogger(LoginControllers.class);
    public LoginSO loginSO;
    public LoginControllers(LoginSO loginSO){
        this.loginSO = loginSO;
    };

    public Handler selectLoginName = ctx -> {
        String body = ctx.body();
        Gson gson = new Gson();
        Login login = gson.fromJson(body, Login.class);
        try {
            loginSO.serviceSelectLoginName(login.getUsername(), login.getPassword());
            ctx.result(login.getUsername()).status();
            ctx.status(201);
            logger.info("Successful Login");
        }catch(LoginError e){
            ctx.status(400);
            logger.info("Failed Login");
        }
    };
}
