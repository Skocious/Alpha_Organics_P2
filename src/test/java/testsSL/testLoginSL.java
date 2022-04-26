package testsSL;

import DataAccessLayer.LoginImp;
import ServiceAccessLayer.LoginSImp;
import customExceptions.InvalidLogin;
import entities.Login;
import org.mockito.Mockito;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.sql.SQLException;

public class testLoginSL {
    public static LoginImp loginDAO = new LoginImp();
    public static LoginSImp loginSO = new LoginSImp(loginDAO);
    public static Login testMock = new Login("customer1", "one111");

    @BeforeClass
    public void setup(){
        loginDAO = Mockito.mock(LoginImp.class);
        loginSO = new LoginSImp(loginDAO);
    }

    @Test//(expectedExceptions = InvalidLogin.class, expectedExceptionsMessageRegExp = "Please enter a valid loginId")
    public void serviceLoginSuccess(){
        Mockito.doReturn(new Login("customer1", "one111")).when(loginDAO).selectLoginName(testMock.getUsername(), testMock.getPassword());
        Login result = loginSO.serviceSelectLoginName(testMock.getUsername(), testMock.getPassword());
        Assert.assertEquals(result.getUsername(), "customer1");
    }
    @Test(expectedExceptions = InvalidLogin.class, expectedExceptionsMessageRegExp = "Please enter a valid loginId")
    public void serviceLoginIdNotInDB(){
        Mockito.doThrow(new InvalidLogin("Please enter a valid loginId")).when(loginDAO).selectLoginName(testMock.getUsername(), testMock.getPassword());
        Login result = loginSO.serviceSelectLoginName(testMock.getUsername(), testMock.getPassword());
    }

// login fail no password


}