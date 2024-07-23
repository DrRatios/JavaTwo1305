import java.util.concurrent.*;

public class DemoAPp {
    public static void main(String[] args) throws ExecutionException, InterruptedException {

        ExecutorService executorService = Executors.newFixedThreadPool(10);
        Future<?> future = executorService.submit(() -> System.out.println(Thread.currentThread().getName()));
        Future<String> futureString = executorService.submit(() -> Thread.currentThread().getName());

        System.out.println(futureString.get());


//        executorService.submit(() -> System.out.println(Thread.currentThread().getName()));
//        executorService.submit(() -> System.out.println(Thread.currentThread().getName()));
//        executorService.submit(new Runnable() {
//            @Override
//            public void run() {
//                System.out.println(Thread.currentThread().getName());
//
//            }
//        });

                //
                executorService.shutdown();
    }
}
