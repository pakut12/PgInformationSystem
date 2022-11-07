/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package database;

import java.sql.*;
import database.ConnectDatabase.*;

/**
 *
 * @author pakutsing
 */
public class DatabaseFunction {

    public static Boolean InsertInformationSystem() throws SQLException {

        Connection con = null;
        PreparedStatement ps = null;
        Boolean status = null;
        try {
            String sql = "";
            con = database.ConnectDatabase.getConnectDatabase();
            ps = con.prepareStatement(sql);



        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            con.close();
            con = null;
            ps.close();
        }

        return status;
    }
}
