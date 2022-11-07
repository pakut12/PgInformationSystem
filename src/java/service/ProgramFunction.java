/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import java.io.IOException;
import java.util.ArrayList;
import service.InformationSystem.*;

/**
 *
 * @author pakutsing
 */
public class ProgramFunction {

    public static ArrayList FindProgram(String ListProgram, String ListProgramx86) throws IOException {
        String Programx86 = ListProgramx86;
        String Program = ListProgram;
        ArrayList<String> ArrList = new ArrayList<String>();
        String CheckProgram = "";
        if (Program.contains("Microsoft Office") || Programx86.contains("Microsoft Office")) {
            CheckProgram += "<i class='bi bi-check'></i>";
            CheckProgram += "Microsoft Office";
            CheckProgram += "<br>";
            ArrList.add(CheckProgram);
            CheckProgram = "";
        } 
        if (Program.contains("ESET") || Programx86.contains("ESET")) {
            CheckProgram += "<i class='bi bi-check'></i>";
            CheckProgram += "ESET";
            CheckProgram += "<br>";
            ArrList.add(CheckProgram);
            CheckProgram = "";
        }
        return ArrList;
    }
}