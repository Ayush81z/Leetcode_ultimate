package threads;

public class threads1 extends Thread {
    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {
            System.out.println("inside the thread class: " + i);
        }
    }
}
