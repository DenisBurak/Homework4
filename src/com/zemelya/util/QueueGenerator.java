package com.zemelya.util;

import com.zemelya.domain.Client;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.atomic.AtomicInteger;

public class QueueGenerator implements Runnable {

    BlockingQueue<Client> queue;
    private int sizeOfCleints;

    public QueueGenerator(BlockingQueue<Client> queue) {
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
            for (int i = 0; i < sizeOfCleints; i++) {
                Client client = Generators.generateClient();
                queue.put(client);
                System.out.println("Клиент " + client.getId() + " в ожидании ответа.");
            }
        } catch (InterruptedException ex) {
            System.out.println("CLIENT INTERRUPTED");
        }
    }
}
