package com.zemelya.domain;

import java.lang.ref.Cleaner;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.atomic.AtomicInteger;

public class Operator implements Runnable {

  BlockingQueue<Client> queue;
  private static final AtomicInteger COUNTER = new AtomicInteger(1);
  private int id;

  public Operator(BlockingQueue<Client> queue) {
    this.queue = queue;
    this.id = COUNTER.getAndIncrement();
  }

  public BlockingQueue<Client> getQueue() {
    return queue;
  }

  public void setQueue(BlockingQueue<Client> queue) {
    this.queue = queue;
  }

  public int getId() {
    return id;
  }

  @Override
  public void run() {
    try {
      while (true) {
        Client client = queue.take();
        System.out.println("");

        try {
          Thread.sleep(1000);
        } catch (InterruptedException ex) {
          System.out.println("Operator Read INTERRUPTED");
        }
      }
    } catch (InterruptedException ex) {
      System.out.println("OPERATOR INTERRUPTED");
    }
  }
}
