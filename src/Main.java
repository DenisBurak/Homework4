import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {
  public static void main(String[] args) {

    int numClients = 100;
    int numOperators = 5;
    ExecutorService executor = Executors.newFixedThreadPool(numOperators);

    System.out.println("Колл - центр начал работу");



    System.out.println("Колл - центр закончил работу");

  }
}
