package Lesson_5;

public class RaceApp {

    public static void main(String[] args) throws InterruptedException {
        Counter counter = new Counter();
        Object lock = new Object();
        Object lock2 = new Object();
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i=0; i<1000; i++){
                    synchronized (lock){
                        synchronized (lock2){

                    counter.inc();
                    }
                    }
                }
            }
        });

        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
//                try {
//                    thread.join();
//                } catch (InterruptedException e) {
//                    throw new RuntimeException(e);
//                }
                for (int i=0; i<1000; i++) {
                    synchronized (lock2) {
                        synchronized (lock){
                            counter.inc();
                        }
                    }
                }
            }
        });

        thread.start();
        thread2.start();
        thread.join();
        thread2.join();


        System.out.println(counter.getCount());
    }



    private static class Counter {
        private int count = 0;

        public int getCount() {
            return count;
        }

        public void inc(){

                count++;

        }

        public  static synchronized void method(){

        }

        public void dec(){
            count--;
        }
    }
}
