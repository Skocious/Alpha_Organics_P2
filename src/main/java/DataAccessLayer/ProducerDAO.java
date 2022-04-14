package DataAccessLayer;

import entities.Producer;

public interface ProducerDAO {

    Producer selectProducerId(int ProducerId, String ProducerName, int LoginId);

}

    
    