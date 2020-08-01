package threads;

public class Consumer implements Runnable {

    private Buffer buffer;

    public Consumer(Buffer buffer) {
        this.buffer = buffer;
    }

    @Override
    public void run() {
        try {
            buffer.consume();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
