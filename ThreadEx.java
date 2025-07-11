public class ThreadEx {

    public static class MyThread extends Thread {
        public void run(){
            System.out.println("Running the thread");
        }
    }

    public static void main(String[] args) {
        System.out.println("Hello");
        MyThread myThread = new MyThread();
        myThread.start();
    }
}