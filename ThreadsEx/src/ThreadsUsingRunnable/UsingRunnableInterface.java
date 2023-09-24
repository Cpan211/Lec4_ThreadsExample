package ThreadsUsingRunnable;

class Hello implements Runnable{

    public void printHello(){

        for (int i = 0; i < 5; i++) {
            System.out.println("Hello From **Hello** Class: " + i);
            try {
                Thread.sleep(1000); // Sleep for 1000 milliseconds/ 1sec
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
    public void run(){

        printHello();

    }



}
class Hi implements Runnable{
    public void run(){
        for (int i = 0; i < 5; i++) {
            System.out.println("Hello From **Hi** Class: " + i);
            try {
                Thread.sleep(1000); // Sleep for 1000 milliseconds/ 1sec
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }


}


public class UsingRunnableInterface {

    public static void main(String[] args) {
        long startTime = System.currentTimeMillis(); // Record the start time

        Hello helloRunnable = new Hello();
        Hi hiRunnable = new Hi();

        Thread helloThread = new Thread(helloRunnable); // Create a thread for Hello
        Thread hiThread = new Thread(hiRunnable);       // Create a thread for Hi

        helloThread.start(); // Start the Hello thread
        hiThread.start();    // Start the Hi thread

        for (int i = 1; i <= 5; i++) {
            System.out.println("Hello From Main: " + i);
            try {
                Thread.sleep(1000); // Sleep for 1000 milliseconds (1 second)
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        long endTime = System.currentTimeMillis(); // Record the end time
        long executionTimeMillis = endTime - startTime; // Calculate the execution time in milliseconds
        double executionTimeSeconds = executionTimeMillis / 1000.0; // Convert to seconds

        System.out.println("Total execution time: " + executionTimeSeconds + " seconds");


    }

}
