package threads;

public class MainThread implements Runnable {

    public static void main(String[] args) throws InterruptedException {
        MainThread mainThread = new MainThread();
        Thread thread = new Thread(mainThread);
        thread.start();
    }

    @Override
    public void run() {
        FirstThread myThread = new FirstThread();
        Thread thread = new Thread(myThread);
        System.out.println(thread.getState());
        thread.start();
        System.out.println(thread.getState());
        try {
            Thread.sleep(200);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(thread.getState());
        try {
            // ожидаем смерти thread2
            thread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(thread.getState());
    }
}
