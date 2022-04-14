package src.Samantha.Service;

import src.Samantha.Entities.Producer;

public interface ProducerDal {

    Producer serviceSelectProducerId(int ProducerId, String ProducerName, int LoginId);

}
