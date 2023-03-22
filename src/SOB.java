
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Vector;


public class SOB {



    int num;
    boolean is_terminate;
    Date registry;
    int man_id;
    int woman_id;
    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-mm-dd");
    SOB(int num,
        boolean is_terminate,
        Date registry,
        int man_id,
        int woman_id)
    {
        this.num = num;
        this.is_terminate = is_terminate;
        this.registry = registry;
        this.man_id =  man_id;
        this.woman_id =  woman_id;
    }

    public Vector<String> getStringPerson () {
        Vector<String> vec1 = new Vector<>();
        return  vec1;
    }
}
