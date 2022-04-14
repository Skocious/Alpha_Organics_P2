package src.Samantha.Dal;

import src.Samantha.Entities.Producer;

public interface ProducerDal {

    Producer selectProducerId(int ProducerId, String ProducerName, int LoginId);

}
