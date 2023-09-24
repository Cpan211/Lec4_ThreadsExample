package ThreadsUsingThreadClass;

class Hello extends Thread{

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
class Hi extends Thread{
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


public class UsingClassThreads {

    public static void main(String[] args) {
        long startTime = System.currentTimeMillis(); // Record the start time

        Hello hello = new Hello();
        Hi hi = new Hi();
        hello.start();
        hi.start();

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
