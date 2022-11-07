/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package database;

import java.sql.*;
import database.ConnectDatabase.*;
import java.util.ArrayList;
import service.InformationSystem;
import service.ProgramFunction;

/**
 *
 * @author pakutsing
 */
public class DatabaseFunction {

    public static int GetIDInformationSystem(int number) throws SQLException {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet re = null;

        int ID = 0;
        try {
            String sql = "SELECT MAX(is_id) as id FROM is_systamuser;";
            con = database.ConnectDatabase.getConnectDatabase();
            ps = con.prepareStatement(sql);
            re = ps.executeQuery();
            while (re.next() && re != null) {
                ID = re.getInt("id") + number + 1;
            }
           
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            ps.close();
            re.close();
            con.close();

        }
        return ID;
    }

    public static String SelectProgram(String Program) throws SQLException {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet re = null;

        String ID = null;
        try {
            String sql = "SELECT * FROM is_program WHERE program_name = ?";
            con = database.ConnectDatabase.getConnectDatabase();
            ps = con.prepareStatement(sql);
            ps.setString(1, Program);
            re = ps.executeQuery();
            while (re.next() && re != null) {
                ID = re.getString("program_id");
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            ps.close();
            re.close();
            con.close();

        }
        return ID;
    }

    public static String SelectOS(String OS) throws SQLException {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet re = null;

        String ID = null;
        try {

            String sql = "SELECT * FROM is_os WHERE os_name = ?";
            con = database.ConnectDatabase.getConnectDatabase();
            ps = con.prepareStatement(sql);
            ps.setString(1, OS);
            re = ps.executeQuery();
            while (re.next() && re != null) {
                ID = re.getString("os_id");
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            ps.close();
            re.close();
            con.close();

        }
        return ID;
    }

    public static Boolean InsertInformationSystem(String user) throws SQLException {

        Connection con = null;
        PreparedStatement ps = null;
        Boolean status = null;
        try {
            ProgramFunction Pg = new ProgramFunction();
            InformationSystem info = new InformationSystem();

            String sql = "INSERT INTO is_systamuser(is_userid, is_computer, is_ip, os_id, program_id, program_key, os_key) VALUES (?,?,?,?,?,?,?)";
            con = database.ConnectDatabase.getConnectDatabase();

            ArrayList<String> list = ProgramFunction.FindProgram(info.GetProgramFiles(), info.GetProgramFilesx86());
            ps = con.prepareStatement(sql);
            for (int i = 0; i < list.size(); i++) {
                String ProgramName = list.get(i).replace("<i class='bi bi-check'></i>", "").replace("<br>", "");
               
                ps.setString(1, info.GetUserPc());
                ps.setString(2, info.GetComputerName());
                ps.setString(3, info.GetIp());
                ps.setString(4, SelectOS(info.GetOs(user)));
                ps.setString(5, SelectProgram(ProgramName));
                ps.setString(6, null);
                ps.setString(7, null);
                ps.addBatch();
            }
            ps.executeBatch();
            status = true;
        } catch (Exception e) {
            e.printStackTrace();
            status = false;
        } finally {
            con.close();
            con = null;
            ps.close();
        }

        return status;
    }
}
