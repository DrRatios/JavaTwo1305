package Lesson_5;

public class MyApp {

    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(new MyRunnable());
        Thread thread2 = new MyThread();
        Thread thread3 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i<5; i++){
                    System.out.println(i);
                }
            }
        });
        thread.setDaemon(true);
        thread.start();
        thread2.start();
        thread3.start();
        thread3.setPriority(10);
        thread.join();
        thread2.join();
        thread3.join();
        System.out.println("Main End");
    }

    private static class MyRunnable implements Runnable {

        @Override
        public void run() {
            for (int i = 0; i<10; i++){
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                   e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName() + i);
            }
        }
    }

    private static class MyThread extends Thread{
        @Override
        public void run() {
            for (int i = 0; i<10; i++){
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName() + " " + i);

            }
        }
    }
}
