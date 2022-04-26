package Api.Controllers;

import DataAccessLayer.*;
import ServiceAccessLayer.*;
import com.google.gson.Gson;
import entities.*;
import io.javalin.core.util.Header;
import io.javalin.http.Handler;

import javax.security.auth.login.FailedLoginException;

public class LoginControllers {
    public LoginSO loginSO;
    public LoginControllers(LoginSO loginSO){
        this.loginSO = loginSO;
    };

    public Handler selectLoginName = ctx ->{
        String body = ctx.body();
        Gson gson = new Gson();
        Login login = gson.fromJson(body, Login.class);
        try {
            loginSO.serviceSelectLoginName(login.getUsername(), login.getPassword());
            ctx.result(Username).status;
            ctx.status(201);
        } catch (FailedLoginException e){
            ctx.result(e.getMessage());
            ctx.status(400);
        };
    };


    public Header selectLoginName = ctx ->{
        ctx.result(LoginImp.Login);
        ctx.status(200);
    };
};