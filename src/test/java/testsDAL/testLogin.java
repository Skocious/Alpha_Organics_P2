package testsDAL;
import entities.Login;
import DataAccessLayer.LoginImp;
import org.testng.Assert;
import org.testng.annotations.Test;

public class testLogin {

    LoginImp loginDAO = new LoginImp();

    @Test
    public void selectLoginIdServiceSuccess() {
        Login login = loginDAO.selectLoginName("customer1", "one111");
        Assert.assertEquals(login.getUsername(), "customer1");
    }

    @Test
    public void selectLoginIdFailure() {
        Login login = loginDAO.selectLoginName("customer1", "one111");
        Assert.assertFalse(login.getUsername() == "customer4");
    }
}