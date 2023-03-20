
import javax.swing.plaf.nimbus.State;
import javax.xml.transform.Result;
import java.sql.*;

//  геттеры коннектора и стейтмента для подключения



public class DBConnector {

    private static final String url = "jdbc:MySQL://localhost:3307/zags?characterEncoding=UTF8";
    private static final String user = "root";
    private static final String password = "root";

    private static Connection con;
    private static Statement stmt;
    private static ResultSet rs;


    DBConnector() {
        try {
            con = DriverManager.getConnection(url, user, password);
            stmt = con.createStatement();
        } catch (SQLException sqlEx) {
            sqlEx.printStackTrace();
        }


    }


    public static Connection getConnection() {
        return con;
    }



    public static Statement getStatement() {
        return stmt;
    }


    /*public static ResultSet getResultSet(String sql) {
        try {
            return stmt.getResultSet();
        } catch (SQLException sqlEx) {
            sqlEx.printStackTrace();
        }


    }*/

}







