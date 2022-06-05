package com.zemelya.util;

import com.zemelya.domain.Client;

public class Generators {

  public static Client generateClient(){

    int min_priority = 1;
    int max_priority = 5;
    int currentPriority = (int) (min_priority + Math.random() * max_priority);

    return new Client(currentPriority);

  }
}
