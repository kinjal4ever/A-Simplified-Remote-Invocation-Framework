

public class CalculateGCD implements Task {

    private int result;
    private int first;
    private int second;
   
    public CalculateGCD(int first, int second) {
        this.first = first;
        this.second = second;
    }
    
    @Override
    public void executeTask(){
        System.out.println("Performing a client task of CalculateGCD");
        this.result = calculateGcd(this.first,this.second);
    }

    int calculateGcd(int a, int b)
    {
        // Everything divides 0 
        if (a == 0 || b == 0)
           return 0;
      
        // base case
        if (a == b)
            return a;
      
        // a is greater
        if (a > b)
            return calculateGcd(a-b, b);
        return calculateGcd(a, b-a);
    }
    
    @Override
    public Object getResult(){
        return new Integer(this.result);
    }
    
}
