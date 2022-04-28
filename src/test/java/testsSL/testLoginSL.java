package testsSL;

import DataAccessLayer.LoginImp;
import ServiceAccessLayer.LoginSImp;
import customExceptions.InvalidLogin;
import entities.Login;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.mockito.Mockito;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class testLoginSL {
    public static Logger logger = LogManager.getLogger(testLoginSL.class);
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
        logger.info("started Login Tests");
    }
    @Test(expectedExceptions = InvalidLogin.class, expectedExceptionsMessageRegExp = "Please enter a valid loginId")
    public void serviceLoginIdNotInDB(){
        Mockito.doThrow(new InvalidLogin("Please enter a valid loginId")).when(loginDAO).selectLoginName(testMock.getUsername(), testMock.getPassword());
        Login result = loginSO.serviceSelectLoginName(testMock.getUsername(), testMock.getPassword());
    }

// login fail no password


}