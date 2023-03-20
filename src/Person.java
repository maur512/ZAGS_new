import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Vector;

public class Person {

    int id;
    String name;
    String last_name;
    String surname;
    int passport_number;
    String passport_serial;
    String adress;
    Date birth;
    String number;


    Person (
            int id,
            String name,
            String last_name,
            String surname,
            int passport_number,
            String passport_serial,
            String adress,
            Date birth,
            String number)


    {
        this.id = id;
        this.name = name;
        this.last_name = last_name;
        this.surname = surname;
        this.passport_number = passport_number;
        this.passport_serial = passport_serial;
        this.adress = adress;
        this.birth = birth;
        this.number = number;
    }


    Vector<String> getStringPerson () {

        DateFormat dateFormat = new SimpleDateFormat("yyyy-mm-dd hh:mm:ss");
        Vector<String> vec1 = new Vector<>();
        vec1.add(Integer.toString(id));
        vec1.add(name);
        vec1.add(last_name);
        vec1.add(surname);
        vec1.add(Integer.toString(passport_number));
        vec1.add(passport_serial);
        vec1.add(adress);
        vec1.add(dateFormat.format(birth));
        vec1.add(number);
        return  vec1;
    }
}


