public class ThreadStoppableRunnable {

    public static class StoppableRunnable implements Runnable {

        private boolean stopRequested = false;

        public synchronized void requestStop(){
            this.stopRequested = true;
        }

        public synchronized boolean isStopRequested(){
            return this.stopRequested;
        }

        private void sleep(long millis){
            try {
                Thread.sleep(millis);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }

        @Override
        public void run() {
            System.out.println(Thread.currentThread().getName() + " is Running");

            while(!isStopRequested()){
                sleep(1000);
                System.out.println("*****");
            }

            System.out.println(Thread.currentThread().getName() + " stopped Running");
        }
    }

    public static void main(String[] args) {

        StoppableRunnable runnable = new StoppableRunnable();
        Thread thread = new Thread(runnable, "Akhand's Thread");
        thread.start();

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        System.out.println("Requesting to stop the thread");
        runnable.requestStop();
    }
}
