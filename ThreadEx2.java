public class ThreadEx2 {

    public static void main(String[] args) {

        Runnable runnable = () -> {
            String ThreadName = Thread.currentThread().getName();
            System.out.println(ThreadName + " is running");

            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

            System.out.println("Finished running");
        };

        Thread thread = new Thread(runnable , "Akhand's Thread");
        thread.start();

        Thread thread2 = new Thread(runnable);
        thread2.start();
    }
}
