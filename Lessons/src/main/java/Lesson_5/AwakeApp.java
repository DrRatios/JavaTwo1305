package Lesson_5;

public class AwakeApp {
    public static void main(String[] args) throws InterruptedException {
        var ref = new Object() {
            volatile boolean isRun = true;
        };
        Thread t = new Thread(new Runnable() {
            @Override
            public void run() {
                while (ref.isRun){
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                    System.out.println("Tick Tack");
                }
                System.out.println(Thread.currentThread().getName() + "Interrapted");
            }
        });
        t.start();
        Thread.sleep(5000);
        ref.isRun = false;
    }
}
