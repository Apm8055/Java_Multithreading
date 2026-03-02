package VirtualThreads;

public class Ex {

    public static void main(String[] args) {

        Runnable runnable = () -> System.out.println("Running ....");

        Thread vThread = Thread.ofVirtual().start(runnable);
        try {
            vThread.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        Thread vThreadUnstarted = Thread.ofVirtual().unstarted(runnable);
    }
}
