
import java.sql.*;
import java.util.Vector;


// SORM - свидетельства о рождении мужчины
// SORW - свидетельства о рождении женщины
// SOB  - свидетельства о браке


public class DBQuiery {


    public static final String GET_ALL_MAN_PREPARED_STATEMENT = "SELECT * FROM mans";
    public static final String GET_ALL_WOMAN_PREPARED_STATEMENT = "SELECT * FROM womans";
    public static final String GET_ALL_SORM_PREPARED_STATEMENT = "SELECT mans.name, mans.last_name,mans.surname,mans.passport_number,mans.passport_serial,mans.adress,mans.birth,mans.number,svidet_o_rozd_mans.registry," +
            "svidet_o_rozd_mans.is_terminate,svidet_o_rozd_mans.num,svidet_o_rozd_mans.vidano,svidet_o_rozd_mans.descript FROM mans LEFT JOIN svidet_o_rozd_mans ON mans.id = svidet_o_rozd_mans.man_id where registry is not null";
    public static final String GET_ALL_SORW_PREPARED_STATEMENT = "SELECT womans.name, womans.last_name,womans.surname,womans.passport_number,womans.passport_serial,womans.adress,womans.birth,womans.number,svidet_o_rozd_womans.registry," +
            "svidet_o_rozd_womans.is_terminate,svidet_o_rozd_womans.num,svidet_o_rozd_womans.vidano,svidet_o_rozd_womans.descript FROM womans LEFT JOIN svidet_o_rozd_womans ON womans.id = svidet_o_rozd_womans.woman_id where registry is not null";
    public static final String GET_ALL_SODM_PREPARED_STATEMENT = "SELECT mans.name, mans.last_name,mans.surname,mans.passport_number,mans.passport_serial,mans.adress,mans.birth,mans.number,svidet_o_smerti_mans.registry," +
            "svidet_o_smerti_mans.is_terminate,svidet_o_smerti_mans.id,svidet_o_smerti_mans.vidano,svidet_o_smerti_mans.descript FROM mans LEFT JOIN svidet_o_smerti_mans ON mans.id = svidet_o_smerti_mans.man_id where registry is not null";
    public static final String GET_ALL_SODW_PREPARED_STATEMENT = "SELECT womans.name, womans.last_name,womans.surname,womans.passport_number,womans.passport_serial,womans.adress,womans.birth,womans.number,svidet_o_smerti_womans.registry," +
            "svidet_o_smerti_womans.is_terminate,svidet_o_smerti_womans.id,svidet_o_smerti_womans.vidano,svidet_o_smerti_womans.descript FROM womans LEFT JOIN svidet_o_smerti_womans ON womans.id = svidet_o_smerti_womans.woman_id where registry is not null";
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

    public static Vector<Vector<String>> getAllSO(String quiery){

        Vector<Vector<String>> vector_SO = new Vector<>();
        SOR sor;

        try {
            PreparedStatement preparedStatementGetMan = DBConnector.getConnection().prepareStatement(quiery);
            ResultSet resultSet = preparedStatementGetMan.executeQuery();
            while (resultSet.next())
            {

                System.out.println(resultSet.getDate(7));
                System.out.println(resultSet.getDate(9));
                if (resultSet.getDate(9) == null) break;
                sor = new SOR(resultSet.getString(1),resultSet.getString(2),resultSet.getString(3),
                        resultSet.getInt(4),resultSet.getString(5),resultSet.getString(6),
                        resultSet.getDate(7),resultSet.getString(8),resultSet.getInt(11),resultSet.getBoolean(10),
                        resultSet.getDate(9),resultSet.getString(12),resultSet.getString(13));
                vector_SO.add(sor.toStringVector());
            }
            return vector_SO;
        } catch (SQLException ex)
        {
            ex.printStackTrace();
        }
        return null;
    }

    public static Vector<Vector<String>> getAllSORW(){
        return null;
    }

    public static Vector<Vector<String>> getAllSOB(){
        return null;
    }
}
