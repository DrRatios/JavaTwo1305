package Lesson_5.HW;

import java.util.Arrays;

public class MyHomeworkApp {
    static final int size = 10000000;
    static final int h = size / 2;

    public static void main(String[] args) {
        Method_1();
        Method_2();

    }

    public static void Method_1() {

        float[] arr = new float[size];
        Arrays.fill(arr, 1);
        long startTime = System.currentTimeMillis();
        for (int i = 0; i < size; i++) {
            arr[i] = (float) (arr[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
        }
        long codeEndTime = System.currentTimeMillis();
        System.out.println("Время работы первого метода составило " + (codeEndTime - startTime) + " милисекунд");
    }

    public static void Method_2() {
        float[] arr = new float[size];
        Arrays.fill(arr, 1);
        float[] a1 = new float[size];
        float[] a2 = new float[size];
        long startTime = System.currentTimeMillis();
        System.arraycopy(arr, 0, a1, 0, h);
        System.arraycopy(arr, h, a2, 0, h);

        Thread t = new Thread(new Runnable() {
            @Override
            public synchronized void run() {
                for (int i = 0; i < h; i++) {
                    a1[i] = (float) (a1[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
                }

            }
        });

        Thread t2 = new Thread(new Runnable() {
            @Override
            public synchronized void run() {
                try {
                    t.join();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                for (int i = 0; i < h; i++) {
                    a2[i] = (float) (a2[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
                }
            }
        });
        t.start();
        t2.start();


        System.arraycopy(a1, 0, arr, 0, h);
        System.arraycopy(a2, 0, arr, h, h);
        long endCodeTime = System.currentTimeMillis();
        System.out.println("Время работы второго метода составило " + (endCodeTime - startTime) + " милисекунд");

    }

}
