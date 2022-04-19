package ServiceAccessLayer;
import DataAccessLayer.ProducerDAO;
import customExceptions.InvalidId;
import entities.Producer;

public class ProducerSImp implements ProducerSO{
    ProducerDAO producerDAO;

    public ProducerSImp(ProducerDAO producerDAO) {
        this.producerDAO = producerDAO;
    }

    @Override
    public Producer serviceSelectProducerId(int ProducerId, String ProducerName, int LoginId) {
        try {
            return this.producerDAO.selectProducerId(ProducerId, ProducerName, LoginId);
        }catch (InvalidId e) {
            throw new InvalidId("Producer Id is not correct, please try again.");
        }
    }
}
