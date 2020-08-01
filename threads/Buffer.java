package threads;

import java.util.LinkedList;
import java.util.Queue;

public class Buffer {
    private Queue<Integer> list;
    private int size;
    public Buffer(int size) {
        this.list = new LinkedList<>();
        this.size = size;
    }
    public void produce() throws InterruptedException {
        while (true) {
            synchronized (this) {
                for (int i = 0; i < (int) (Math.random() * 3) + 1; i++) {
                    int value = (int) (Math.random() * 10) + 3;
                    list.add(value);
                    System.out.println(Thread.currentThread().getName() + " produced " + value);
                    while (list.size() >= size) {
                        wait();
                    }
                }
                notify();
                Thread.sleep(1000);
            }
        }
    }
    public void consume() throws InterruptedException {
        while (true) {
            synchronized (this) {
                while (list.size() == 0) {
                    wait();
                }
                int value = list.poll();
                System.out.println(Thread.currentThread().getName() + " consume " + value);
                notify();
                Thread.sleep(1000);
            }
        }
    }
}
