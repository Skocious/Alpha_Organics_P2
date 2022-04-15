package ServiceAccessLayer;

import entities.Producer;

public interface ProducerServiceInterface {

    Producer serviceSelectProducerId(int ProducerId, String ProducerName, int LoginId);
}
