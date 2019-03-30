
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class ComputeClient {

    static Scanner s;
    static ComputeClient testClient;

    public static void main(String args[]) {
        try {

            String host = "localhost";
            String port = "5000";

            if (args.length == 2) {
                if (args[0] != "" || args[0] != null) {
                    host = args[0];
                }

                if (args[1] != "" || args[1] != null) {
                    port = args[1];
                }
            }

            String url = "rmi://" + host + ":" + port + "/test";
            Compute compute = (Compute) Naming.lookup(url);
            testClient = new ComputeClient();

            while (true) {
                System.out.println("\n***************************************************");
                System.out.println("Calculate Pi -------------------------------------1");
                System.out.println("Calculate Primes ---------------------------------2");
                System.out.println("Calculate Greatest common Divisor ----------------3");
                System.out.println("Exit ---------------------------------------------4");
                System.out.println("***************************************************");

                System.out.print("\nPlease Enter Option: ");
                s = new Scanner(System.in);
                try {
                    int user = s.nextInt();
                    switch (user) {
                        case 1:
                            testClient.calculatePi(compute);
                            break;
                        case 2:
                            testClient.calculatePrimes(compute);
                            break;
                        case 3:
                            testClient.calculateGcd(compute);
                            break;
                        case 4:
                            System.exit(0);
                        default:
                            System.out.println("\nPlease Enter Valid Option \n");
                    }
                } catch (InputMismatchException e) {
                    System.out.println("\nPlease Enter Valid Input \n");
                }
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void calculatePi(Compute compute) throws RemoteException {
        System.out.print("Enter the number of digits after the decimal point of pi: ");
        s = new Scanner(System.in);
        int no = s.nextInt();

        ArrayList al = new ArrayList();
        al.add(no);
        System.out.println(compute.executeTask(1, al));
    }

    public void calculatePrimes(Compute compute) throws RemoteException {
        System.out.print("Enter the number till which is prime numbers are to be calculated: ");
        s = new Scanner(System.in);
        int no = s.nextInt();

        ArrayList al = new ArrayList();
        al.add(no);
        System.out.println(compute.executeTask(2, al));
    }

    public void calculateGcd(Compute compute) throws RemoteException {

        System.out.print("Enter the first integer: ");
        s = new Scanner(System.in);
        int first = s.nextInt();

        System.out.print("\nEnter the second integer: ");
        s = new Scanner(System.in);
        int second = s.nextInt();

        ArrayList al = new ArrayList();
        al.add(first);
        al.add(second);
        System.out.println("The Greatest Common Divisor Of " + first + " and " + second + " is " + compute.executeTask(3, al));
    }
}
