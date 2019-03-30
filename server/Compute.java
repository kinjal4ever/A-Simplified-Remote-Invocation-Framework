

import java.rmi.*;
import java.util.ArrayList;
public interface Compute extends Remote 
{ 
    Object executeTask(int no, ArrayList al) throws RemoteException; 
} 