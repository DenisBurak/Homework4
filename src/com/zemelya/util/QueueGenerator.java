package com.zemelya.util;

import com.zemelya.domain.Client;

import java.util.concurrent.BlockingQueue;

public class QueueGenerator implements Runnable {

    BlockingQueue<Client> queue;
    private int sizeOfClients;

    public QueueGenerator(BlockingQueue<Client> queue, int sizeOfClients) {
        this.sizeOfClients = sizeOfClients;
        this.queue = queue;
    }

    public BlockingQueue<Client> getQueue() {
        return queue;
    }

    public void setQueue(BlockingQueue<Client> queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        try {
            for (int i = 0; i < sizeOfClients; i++) {
                Client client = Generators.generateClient();
                queue.put(client);
                System.out.println("Клиент " + client.getId() + " в ожидании ответа.");

                try{
                    Thread.sleep(200);
                }
                catch (InterruptedException ex){
                    System.out.println("Client Write INTERRUPTED");
                }
            }
        } catch (InterruptedException ex) {
            System.out.println("CLIENT INTERRUPTED");
        }
    }
}
