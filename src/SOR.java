import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Vector;

public class SOR {

        int num;
        boolean is_terminate;
        Date registry;
        int id;
        String vidano;
        String descript;

        Person person;
    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-mm-dd");
        SOR(String name,
            String last_name,
            String surname,
            int passport_number,
            String passport_serial,
            String adress,
            java.sql.Date birth,
            String number,
            int num,
            boolean is_terminate,
            Date registry,
            String vidano,
            String descript)
        {
            this.num = num;
            this.is_terminate = is_terminate;
            this.registry = registry;
            this.vidano = vidano;
            this.descript = descript;
            person.name = name;
            person.last_name = last_name;
            person.surname = surname;
            person.passport_number = passport_number;
            person.passport_serial = passport_serial;
            person.adress = adress;
            person.birth = birth;
            person.number = number;
        }

        Vector<String> toStringVector() {
            Vector<String> vec1 = new Vector<>();
            vec1.add(person.name);
            vec1.add(person.last_name);
            vec1.add(person.surname);
            vec1.add(Integer.toString(person.passport_number));
            vec1.add(person.passport_serial);
            vec1.add(person.adress);
            vec1.add(dateFormat.format(person.birth));
            vec1.add(person.number);
            vec1.add(Integer.toString(num));
            vec1.add(Boolean.toString(is_terminate));
            vec1.add(dateFormat.format(registry));
            vec1.add(vidano);
            vec1.add(descript);
            return vec1;
        }

}
