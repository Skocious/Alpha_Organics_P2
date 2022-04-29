package Api.Controllers;

import ServiceAccessLayer.*;
import com.google.gson.Gson;
import customExceptions.*;
import entities.*;
import io.javalin.http.Handler;

public class LoginControllers {
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
        }catch(LoginError e){
            ctx.result(e.getMessage());
            ctx.status(400);
        }
    };
};
