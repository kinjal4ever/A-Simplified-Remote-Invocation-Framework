
import java.util.ArrayList;



public class CalculatePrime implements Task {

    private String result;
    private int no;
    
    public CalculatePrime(int no) {
        this.no = no;
    }
    
    
    @Override
    public void executeTask(){
        System.out.println("Performing a client task of CalculatePrime");
        
        result = calculatePrimeNumber(no);
        
    }
    
    String calculatePrimeNumber(int maxCheck){
        int i;
        int num = 0;
        boolean isPrime = true;

        String primeNumbersFound = "";
        
        ArrayList al = new ArrayList();
        
		int count = 0;
        for (i = 2; i <= maxCheck; i++) {
            isPrime = CheckPrime(i);
            if (isPrime) {
                count++;
                primeNumbersFound = primeNumbersFound + i + ", ";
            }
        }
        result = "The number of primes is: "+count+" and they are: "+primeNumbersFound;
        return result.substring(0, result.length() - 2);

    }
    boolean CheckPrime(int numberToCheck) {
        int remainder;
        for (int i = 2; i <= numberToCheck / 2; i++) {
            remainder = numberToCheck % i;
            if (remainder == 0) {
                return false;
            }
        }
        return true;
    }

    @Override
    public Object getResult(){
        return new String(this.result);
    }
}
