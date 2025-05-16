package Lesson_5;

public class WaitApp {
    private  final Object LOCK = new Object();
    String current = "A";
    public static void main(String[] args) {

        WaitApp printApp = new WaitApp();

        Thread t = new Thread(printApp::printA);
        Thread t2 = new Thread(printApp::printB);

        t.start();
        t2.start();

    }
    public void printA(){
        synchronized (LOCK) {
            for (int i = 0; i < 10; i++) {
                while (!current.equals("A")){
                    try {
                        LOCK.wait();
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
                System.out.print("A");
                current = "B";
                LOCK.notify();
            }
        }

    }

    public void printB(){
        synchronized (LOCK) {
            for (int i = 0; i < 10; i++) {
                while (!current.equals("B")){
                    try {
                        LOCK.wait();
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
                System.out.print("B");
                current = "A";
                LOCK.notify();
            }
        }

    }

}
