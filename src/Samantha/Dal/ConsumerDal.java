package src.Samantha.Dal;

import src.Samantha.Entities.Consumer;

public interface ConsumerDal {

    Consumer selectConsumerId(int ConsumerId, String ConsumerUsername, String ConsumerPassword, int LoginId);

}


