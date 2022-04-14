package src.Samantha.Service;

import src.Samantha.Entities.Consumer;

public interface ConsumerDal {

    Consumer serviceSelectConsumerId(int ConsumerId, String ConsumerUsername, String ConsumerPassword, int LoginId);

}
