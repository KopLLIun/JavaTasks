package threads;

public class ProducerConsumerProblem {
    public static void main(String[] args) throws InterruptedException {
        Buffer buffer = new Buffer(5);
        Producer producer = new Producer(buffer);
        Consumer consumer1 = new Consumer(buffer);
        Consumer consumer2 = new Consumer(buffer);
        Thread producerThread = new Thread(producer);
        Thread consumerThread1 = new Thread(consumer1);
        Thread consumerThread2 = new Thread(consumer2);
        producerThread.start();
        consumerThread1.start();
        consumerThread2.start();
        producerThread.join();
        consumerThread1.join();
        consumerThread2.join();
    }
}