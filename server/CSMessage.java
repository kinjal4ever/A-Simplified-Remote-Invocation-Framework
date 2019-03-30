
import java.io.*;

public class CSMessage implements Task, Serializable {

    private String finalResult;

    public CSMessage() {
    }

    public Object getResult() {
        return finalResult;
    }

    public void setMessage(String msg) {
        finalResult = msg;
    }

    public void executeTask() {
    }
}
