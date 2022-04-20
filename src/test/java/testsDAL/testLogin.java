package testsDAL;
import entities.Login;
import DataAccessLayer.LoginImp;
import org.testng.Assert;
import org.testng.annotations.Test;

public class testLogin {

    LoginImp loginDAO = new LoginImp();

    @Test
    public void selectLoginId() {
        Login login = loginDAO.selectLoginId(4, "Hand456", "456art");
        Assert.assertEquals(login.getLoginId(), 4);
    }

    @Test
    public void selectLoginIdFailure() {
        Login login = loginDAO.selectLoginId(4, "Hand456", "456art");
        Assert.assertFalse(login.getLoginId() == 0);
    }
}