package com.zemelya.domain;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.atomic.AtomicInteger;

public class Client implements Comparable<Client>{

    private static final AtomicInteger COUNTER = new AtomicInteger(1);
    private int id;
    private int priority;

    public Client(int priority) {

        id = COUNTER.getAndIncrement();
        this.priority = priority;
    }

    public int getId() {
        return id;
    }

    public static AtomicInteger getCOUNTER() {
        return COUNTER;
    }

    public int getPriority() {
        return priority;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }

    @Override
    public int compareTo(Client o) {
        return Integer.valueOf(o.getPriority()).compareTo(this.getPriority());
    }
}
