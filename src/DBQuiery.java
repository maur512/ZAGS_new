
import java.sql.*;
import java.util.Vector;


// SORM - свидетельства о рождении мужчины
// SORW - свидетельства о рождении женщины
// SOB  - свидетельства о браке


public class DBQuiery {


    public static final String GET_ALL_MAN_PREPARED_STATEMENT = "SELECT * FROM mans";
    public static final String GET_ALL_WOMAN_PREPARED_STATEMENT = "SELECT * FROM womans";
    public static final String GET_ALL_SORM_PREPARED_STATEMENT = "SELECT * FROM svidet_o_rozd_mans";
    public static final String GET_ALL_SORW_PREPARED_STATEMENT = "SELECT * FROM svidet_o_rozd_womans";
    public static final String GET_ALL_SOB_PREPARED_STATEMENT = "SELECT * FROM svidet_o_brake";

    public static Vector<Vector<String>> getAllpersons(String quiery){
        Vector<Vector<String>> person_vector = new Vector<>();
        Person pers;

        try {
            PreparedStatement preparedStatementGetMan = DBConnector.getConnection().prepareStatement(quiery);
            ResultSet resultSet = preparedStatementGetMan.executeQuery();
            while (resultSet.next())
            {
                pers = new Person(resultSet.getInt(1),resultSet.getString(2),resultSet.getString(3),resultSet.getString(4),
                        resultSet.getInt(5),resultSet.getString(6)
                        ,resultSet.getString(7),resultSet.getDate(8),resultSet.getString(9));
                person_vector.add(pers.getStringPerson());
            }
            return person_vector;
        } catch (SQLException ex)
        {
            ex.printStackTrace();
        }
        return null;
    }

    public static Vector<Vector<String>> getAllSORM(){

        return null;
    }

    public static Vector<Vector<String>> getAllSORW(){
        return null;
    }

    public static Vector<Vector<String>> getAllSOB(){
        return null;
    }
}
