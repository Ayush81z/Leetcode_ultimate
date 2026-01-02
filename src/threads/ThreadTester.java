package threads;

public class ThreadTester {
    public static void main(String[] args) {
        //runs first
        System.out.println("main is starting...");

        //runs third (jvm finishes the main then checks for child thread)
        Thread t1 = new threads1();//user thread
        t1.start();



        //runs second
        System.out.println("main is exiting...");
    }
}
