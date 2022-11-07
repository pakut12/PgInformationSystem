/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import java.io.IOException;
import java.util.ArrayList;
import service.InformationSystem.*;
import java.sql.*;

/**
 *
 * @author pakutsing
 */
public class ProgramFunction {

    public static ArrayList FindProgram(String ListProgram, String ListProgramx86) throws IOException, SQLException {
        String Programx86 = ListProgramx86;
        String Program = ListProgram;
        ArrayList<String> ArrList = new ArrayList<String>();
        String CheckProgram = "";

        Connection con = null;
        PreparedStatement ps = null;
        ResultSet re = null;

        try {
            String sql = "SELECT * FROM is_program";
            con = database.ConnectDatabase.getConnectDatabase();
            ps = con.prepareStatement(sql);
            re = ps.executeQuery();

            while ((re.next()) && re != null) {
                if (Program.contains(re.getString("program_name")) || Programx86.contains(re.getString("program_name"))) {
                    CheckProgram += "<i class='bi bi-check'></i>";
                    CheckProgram += re.getString("program_name");
                    CheckProgram += "<br>";
                    ArrList.add(CheckProgram);
                    CheckProgram = "";
                }
                
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            re.close();
            ps.close();
            con.close();
        }

        return ArrList;
    }
}