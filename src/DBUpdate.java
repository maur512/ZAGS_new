
import javax.swing.plaf.nimbus.State;
import java.sql.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;




// Запросы для обновления таблицы

public class DBUpdate {

    private static final String putWomanSql = "INSERT INTO womans (name, last_name, surname, passport_number, passport_serial, adress, birth, number) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
    private static final String putManSql = "INSERT INTO mans (name, last_name, surname, passport_number, passport_serial, adress, birth, number) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";

    private static final String putSORMSql = "insert into svidet_o_rozd_mans(is_terminate,registry,man_id,vidano,descript) values(?,?,(SELECT id FROM mans where (passport_number = ? and passport_serial = ?)),?, ?)";

    private static final String putSORWSql = "insert into svidet_o_rozd_womans(is_terminate,registry,woman_id,vidano,descript) values(?,?,(SELECT id FROM womans where (passport_number = ? and passport_serial = ?)),?, ?)";

    private static final String putSODMSql = "insert into svidet_o_smerti_mans(is_terminate,registry,man_id,vidano,descript) values(?,?,(SELECT id FROM mans where (passport_number = ? and passport_serial = ?)),?, ?)";

    private static final String putSODWSql = "insert into svidet_o_smerti_womans(is_terminate,registry,woman_id,vidano,descript) values(?,?,(SELECT id FROM womans where (passport_number = ? and passport_serial = ?)),?, ?)";


    //    method to update table "mans"
    public static void putMan(Person man) {
        try {
            PreparedStatement putManStatement = DBConnector.getConnection().prepareStatement(putManSql);

//            person name
            putManStatement.setString(1, man.name);
//            person last name
            putManStatement.setString(2, man.last_name);
//            person surname
            putManStatement.setString(3, man.surname);
//            person passport number
            putManStatement.setInt(4, man.passport_number);
//            person passport serial
            putManStatement.setString(5, man.passport_serial);
//            person adress
            putManStatement.setString(6, man.adress);
//            person birth date
            putManStatement.setDate(7, man.birth);
//            person phone number
            putManStatement.setString(8, man.number);
            putManStatement.executeUpdate();

        } catch (SQLException exception) {
            exception.printStackTrace();
            System.out.println("Connection failed.");
        }
    }

    public static void putWoman(Person woman) {
        try {
            PreparedStatement putWomanStatement = DBConnector.getConnection().prepareStatement(putWomanSql);
//            person name
            putWomanStatement.setString(1, woman.name);
//            person last name
            putWomanStatement.setString(2, woman.last_name);
//            person surname
            putWomanStatement.setString(3, woman.surname);
//            person passport number
            putWomanStatement.setInt(4, woman.passport_number);
//            person passport serial
            putWomanStatement.setString(5, woman.passport_serial);
//            person adress
            putWomanStatement.setString(6, woman.adress);
//            person birth date
            putWomanStatement.setDate(7, woman.birth);
//            person phone number
            putWomanStatement.setString(8, woman.number);
            putWomanStatement.executeLargeUpdate();

        } catch (SQLException exception) {
            exception.printStackTrace();
            System.out.println("Connection failed.");
        }
    }

    public static void putSOR(SOR so, String mainL) throws SQLException {

        PreparedStatement putSoStatement = null;
        switch (mainL){
            case (AddSvidetFrame.SORM):
                putSoStatement = DBConnector.getConnection().prepareStatement(putSORMSql);
                    break;
            case (AddSvidetFrame.SORW):
                 putSoStatement = DBConnector.getConnection().prepareStatement(putSORWSql);
                break;
            case (AddSvidetFrame.SODM):
                putSoStatement = DBConnector.getConnection().prepareStatement(putSODMSql);
                break;
            case (AddSvidetFrame.SODW):
                putSoStatement = DBConnector.getConnection().prepareStatement(putSODWSql);
                break;
        }


//            person name
        putSoStatement.setBoolean(1, so.is_terminate);
//            person last name
        putSoStatement.setDate(2, so.registry);
//            person surname
        putSoStatement.setInt(3, so.person.passport_number);
//            person passport number
        putSoStatement.setString(4, so.person.passport_serial);
//            person passport serial
        putSoStatement.setString(5,  so.vidano);
//            person adress
        putSoStatement.setString(6, so.descript);
        putSoStatement.executeLargeUpdate();


    }
}
