
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

public class ComputeServer extends UnicastRemoteObject implements Compute {

    public ComputeServer() throws RemoteException {
    }

    public Object executeTask(int no, ArrayList al) {
        Object ob = null;
        try {
            if(no == 1) {
                CalculatePi cp = new CalculatePi(Integer.parseInt(al.get(0).toString()));
                cp.executeTask();
                ob = cp.getResult();
            }
            if(no == 2) {
                CalculatePrime cpr = new CalculatePrime(Integer.parseInt(al.get(0).toString()));
                cpr.executeTask();
                ob = cpr.getResult();
            }
            if(no == 3) {
                CalculateGCD cgcd = new CalculateGCD(Integer.parseInt(al.get(0).toString()), Integer.parseInt(al.get(1).toString()));
                cgcd.executeTask();
                ob = cgcd.getResult();
            }
        } catch (Exception e) {
            CSMessage cs = new CSMessage();
            cs.setMessage(e.getMessage());
            return cs.getResult();
        }
        return ob;
    }

    public static void main(String args[]) {
        try {
            System.setProperty("java.rmi.server.hostname","localhost");
            Compute compute = new ComputeServer();
            String url = "rmi://localhost:5000/test";
            Naming.rebind(url, compute);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
