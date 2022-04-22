package testsSL;

import DataAccessLayer.LoginImp;
import ServiceAccessLayer.LoginSImp;
import entities.Login;
import org.mockito.Mockito;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class testLoginSL {
    public static LoginImp loginDAO = new LoginImp();
    public static LoginSImp loginSO = new LoginSImp(loginDAO);
    public static Login testMock = new Login("customer1", "one111");

    @BeforeClass
    public void setup(){
        loginDAO = Mockito.mock(LoginImp.class);
        loginSO = new LoginSImp(loginDAO);
    }

    @Test
    public void serviceLoginSuccess(){
        Mockito.doReturn(new Login("customer1", "one111")).when(loginDAO).selectLoginName(testMock.getUsername(), testMock.getPassword());
        Login result = loginSO.serviceSelectLoginName(testMock.getUsername(), testMock.getPassword());
        Assert.assertEquals(result.getUsername(), "customer1");
    }
//    @Test
//    public void serviceLoginIdNotInDB(Login login){
//        Mockito.doReturn(new Login("customer4", "pw")).when(loginDAO).selectLoginName(testMock.getUsername(), testMock.getPassword());
//        Login result = loginSO.serviceSelectLoginName(testMock.getUsername(), testMock.getPassword());
//        Assert.assertNotEquals(result.getUsername(), "customer4");
//    }



}