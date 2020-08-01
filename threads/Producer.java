package threads;

public class Producer implements Runnable {

    private Buffer buffer;

    public Producer(Buffer buffer) {
        this.buffer = buffer;
    }

    @Override
    public void run() {
        try {
            buffer.produce();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
