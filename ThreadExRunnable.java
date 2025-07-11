public class ThreadExRunnable {

    public static class MyRunnable implements Runnable {

        @Override
        public void run() {
            System.out.println("Running....");
        }
    }

    public static void main(String[] args) {

        // Thread thread = new Thread(new MyRunnable());
        // thread.start();

        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                System.out.println("Running hehe .....");
            }
        };

        // It can also be done using lambda expressions

        Thread thread = new Thread(runnable);
        thread.start();
    }
}
