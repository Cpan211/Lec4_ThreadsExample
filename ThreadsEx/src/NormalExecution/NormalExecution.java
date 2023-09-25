package NormalExecution;

class Hello{

    public void printHello(){

        for (int i = 0; i < 4; i++) {
            System.out.println("Hello From Hello Thread: " + i);
            try {
                Thread.sleep(1000); // Sleep for 1000 milliseconds/ 1sec
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }

    }



}

class Hi{

    public void printHi(){

        for (int i = 0; i < 4; i++) {
            System.out.println("Hello From Hi Thread: " + i);
        }

        try {
            Thread.sleep(1000); // Sleep for 1000 milliseconds/ 1sec
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }



}

public class NormalExecution {

    //Normal Execution
    public static void main(String[] args) {

        long startTime = System.currentTimeMillis();


        System.out.println("Hello and welcome!\n");

        // Press Shift+F10 or click the green arrow button in the gutter to run the code.
        for (int i = 1; i <= 5; i++) {
            System.out.println("Hello From Main Thread: " + i);

            try {
                Thread.sleep(1000); // Sleep for 1000 milliseconds/ 1sec
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        Hello hello = new Hello();

        Hi hi = new Hi();


        hello.printHello();
        hi.printHi();


        long endTime = System.currentTimeMillis(); // Record the end time
        long executionTimeMillis = endTime - startTime; // Calculate the execution time in milliseconds
        double executionTimeSeconds = executionTimeMillis / 1000.0; // Convert to seconds

        System.out.println("Total execution time: " + executionTimeSeconds + " seconds");

    }
}