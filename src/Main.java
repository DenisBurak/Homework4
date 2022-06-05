import com.zemelya.domain.Client;
import com.zemelya.domain.Operator;
import com.zemelya.util.QueueGenerator;

import java.util.concurrent.*;

public class Main {
  public static void main(String[] args) {

    int numClients = 20;
    int numOperators = 3;

    ExecutorService executorClient = Executors.newFixedThreadPool(1);
    ExecutorService executorOperators = Executors.newFixedThreadPool(numOperators);

    BlockingQueue<Client> queue = new PriorityBlockingQueue<>(10);
    QueueGenerator queueGenerator = new QueueGenerator(queue, numClients);

    System.out.println("Колл - центр начал работу");

    executorClient.submit(new Thread(queueGenerator));

    for (int i = 0; i < numOperators; i++) {
      executorOperators.submit(new Thread(new Operator(queue)));
    }

    executorClient.shutdown();
    executorOperators.shutdown();

    while (true) {
      if (executorOperators.isTerminated()) {
        System.out.println("Колл - центр закончил работу");
        break;
      }
    }
  }
}
