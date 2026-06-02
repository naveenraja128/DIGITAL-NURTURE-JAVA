import java.util.concurrent.*;

public class ExecutorServiceExample {

    public static void main(String[] args) throws Exception {

        ExecutorService executor =
                Executors.newFixedThreadPool(3);

        Callable<Integer> task1 = () -> 10;
        Callable<Integer> task2 = () -> 20;
        Callable<Integer> task3 = () -> 30;

        Future<Integer> result1 = executor.submit(task1);
        Future<Integer> result2 = executor.submit(task2);
        Future<Integer> result3 = executor.submit(task3);

        System.out.println("Result 1: " + result1.get());
        System.out.println("Result 2: " + result2.get());
        System.out.println("Result 3: " + result3.get());

        executor.shutdown();
    }
}