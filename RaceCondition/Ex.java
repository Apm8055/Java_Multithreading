package RaceCondition;

public class Ex {

    public static class MyRunnable implements Runnable{

        private int cnt = 0;

        @Override
        public void run() {

            for(int i=0;i<1000000;i++){
                synchronized (this){
                    cnt++;
                }
            }

            System.out.println(Thread.currentThread().getName() + " " + cnt);
        }
    }

    public static void main(String[] args) {

        Runnable runnable = new MyRunnable();

        Thread thread1 = new Thread(runnable, "Thread1");
        Thread thread2 = new Thread(runnable, "Thread2");

        thread1.start();
        thread2.start();
    }
}
