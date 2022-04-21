package testsDAL;
import entities.Login;
import DataAccessLayer.LoginImp;
import org.testng.Assert;
import org.testng.annotations.Test;

public class testLogin {

    LoginImp loginDAO = new LoginImp();

    @Test
    public void selectLoginId() {
        Login login = loginDAO.selectLoginName("Hand456", "456art");
        Assert.assertEquals(login.getUsername(), "Hand456");
    }

    @Test
    public void selectLoginIdFailure() {
        Login login = loginDAO.selectLoginName("Hand456", "456art");
        Assert.assertFalse(login.getUsername() == "Hand456");
    }
}