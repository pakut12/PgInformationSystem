/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package database;

import com.mysql.jdbc.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author pakutsing
 */
public class ConnectDatabase {

    public static Connection getConnectDatabase() {
        Connection con = null;
        try {
//            Class.forName("oracle.jdbc.driver.OracleDriver");
//            con = DriverManager.getConnection("jdbc:oracle:thin:@10.0.62.18:1521:stock", "comp", "pmoc4");
            Class.forName("com.mysql.jdbc.Driver");
            String portwork = "4306";
            String porthome = "3306";
            con = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:" + portwork + "/test?characterEncoding=UTF-8" +
                    "&user=root&password=");
        } catch (Exception e) {
            e.printStackTrace();
        }

        return con;
    }

    public static void CloseConnect(Connection con) throws SQLException {
        con.close();
        con = null;
    }
}
