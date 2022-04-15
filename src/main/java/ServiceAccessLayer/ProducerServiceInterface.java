package ServiceAccessLayer;
import DataAccessLayer.ProducerDAO;
import entities.Producer;

import java.util.List;

public interface ProducerSO extends ProducerDAO {

    Producer serviceSelectProducerId(int ProducerId, String ProducerName, int LoginId);
}
