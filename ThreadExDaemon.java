public class ThreadExDaemon {

    public static void main(String[] args) {

        Runnable runnable = () -> {
            while(true){
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                System.out.println(Thread.currentThread().getName() + " Running");
            }
        };

        Thread thread = new Thread(runnable);

        // if not set Daemon to true, then it will run even if the main thread terminates
        thread.setDaemon(true);
        thread.start();
        try {
            Thread.sleep(3100);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
