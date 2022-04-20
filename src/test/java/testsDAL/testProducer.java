package testsDAL;

import DataAccessLayer.ProducerImp;
import entities.Producer;
import org.testng.Assert;
import org.testng.annotations.Test;

public class testProducer {
    ProducerImp producerDAO = new ProducerImp();

    @Test
    public void selectProducerByIdSuccess(){
        Producer producer = producerDAO.selectProducerId(1);
        Assert.assertEquals(producer.getProducerId(), 1);

    }

    @Test
    public void selectProducerByIdFailure(){
        Producer producer = producerDAO.selectProducerId(1);
        Assert.assertFalse(producer.getProducerId()==-1);

    }
}
