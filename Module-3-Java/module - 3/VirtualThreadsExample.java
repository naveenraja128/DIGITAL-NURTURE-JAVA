public class VirtualThreadsExample {

    public static void main(String[] args) throws Exception {

        for (int i = 1; i <= 10; i++) {

            int threadNumber = i;

            Thread.startVirtualThread(() -> {
                System.out.println("Virtual Thread " + threadNumber);
            });
        }

        Thread.sleep(1000);
    }
}