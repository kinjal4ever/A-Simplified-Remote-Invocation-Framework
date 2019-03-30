
import java.io.Serializable;

public interface Task extends Serializable {

    public void executeTask();

    public Object getResult();

}
