import com.ariezz.util.DBConnection;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Created by Admin on 27.11.16.
 */
public class Main {

    public static void main(String[] args) throws SQLException {
        Connection con = DBConnection.getConnection();

        System.out.println("in main");

        System.out.println();

        if (tableExist(con, "registration")){
            System.out.println("Table is in DB");
        } else {
            Statement stmt = con.createStatement();

            String sql = "CREATE TABLE REGISTRATION " +
                    "(id INTEGER not NULL, " +
                    " first VARCHAR(255), " +
                    " last VARCHAR(255), " +
                    " age INTEGER, " +
                    " PRIMARY KEY ( id ))";

            stmt.executeUpdate(sql);
            System.out.println("Created table in given database...");

        }
    }


    public static boolean tableExist(Connection conn, String tableName) {
        boolean tExists = false;
        try (ResultSet rs = conn.getMetaData().getTables(null, null, tableName, null)) {
            while (rs.next()) {
                String tName = rs.getString("TABLE_NAME");

                if (tName != null && tName.equals(tableName)) {
                    tExists = true;
                    break;
                }
            }
        } catch (SQLException e){
            System.out.println("ERROR!!");
            throw new RuntimeException();
        }
        return tExists;
    }
}
