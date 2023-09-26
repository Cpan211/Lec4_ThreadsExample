package ThreadPool;



import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

class Hello implements Runnable {
    public void printHello() {
        for (int i = 0; i < 5; i++) {
            System.out.println("Hello From **Hello** Thread: " + i);
            try {
                Thread.sleep(500); // Sleep for 1000 milliseconds/ 1sec
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void run() {
        printHello();
    }
}

class Hi implements Runnable {
    public void run() {
        for (int i = 0; i < 5; i++) {
            System.out.println("Hello From **Hi** Thread: " + i);
            try {
                Thread.sleep(500); // Sleep for 1000 milliseconds/ 1sec
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
class Greetings implements Runnable {

    private String name;
    public Greetings(String name){
        this.name = name;
    }
    public void printGreetings(){
        for (int i = 0; i < 5; i++) {
            System.out.println("Hello From **Greetings** Thread: "+ " " + i +" "+name);
            try {
                Thread.sleep(500); // Sleep for 1000 milliseconds/ 1sec
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
    public void run() {

    }
}

public class UsingTreadPools {

    public static void main(String[] args) {
        long startTime = System.currentTimeMillis(); // Record the start time

        Hello helloRunnable = new Hello();
        Hi hiRunnable = new Hi();
//        Greetings greetings = new Greetings("Cpan211");
//        Greetings g = new Greetings("Christin");
        ExecutorService executorService = Executors.newFixedThreadPool(2); // Create a thread pool with 2 threads

        executorService.execute(helloRunnable); // Execute the Hello task
        executorService.execute(hiRunnable);    // Execute the Hi task
//        executorService.execute(greetings); // Execute the Greetings task
//        executorService.execute(g); // Execute the Greetings task
        executorService.shutdown(); // Shutdown the thread pool after tasks are submitted

        while (!executorService.isTerminated()) {
            // Wait for all tasks to complete
        }


        long endTime = System.currentTimeMillis(); // Record the end time
        long executionTimeMillis = endTime - startTime; // Calculate the execution time in milliseconds
        double executionTimeSeconds = executionTimeMillis / 1000.0; // Convert to seconds

        System.out.println("Total execution time: " + executionTimeSeconds + " seconds");
    }

}
