package testsDAL;
import Api.Apps;
import entities.Login;
import DataAccessLayer.LoginImp;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class testLogin {
    public static Logger logger = LogManager.getLogger(testLogin.class);
    LoginImp loginDAO = new LoginImp();

    @Test
    public void selectLoginIdServiceSuccess() {

        Login login = loginDAO.selectLoginName("customer1", "one111");
        Assert.assertEquals(login.getUsername(), "customer1");
        logger.info("Login dal tests running ");
    }

}