/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package src;

import database.ConnectDatabase;
import database.DatabaseFunction;
import java.io.*;
import java.net.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.*;
import javax.servlet.http.*;
import service.InformationSystem;
import service.ProgramFunction;

/**
 *
 * @author pakutsing
 */
public class AddDataInformationSystem extends HttpServlet {

    /** 
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code> methods.
     * @param request servlet request
     * @param response servlet response
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, SQLException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try {

            ProgramFunction Pg = new ProgramFunction();
            InformationSystem info = new InformationSystem();

            String Status = request.getParameter("Status").trim();

            if (Status.equals("I1")) {
                try {
                    String pcuser = request.getHeader("USER-AGENT");
                    Boolean CheckInsert = DatabaseFunction.InsertInformationSystem(pcuser);
                    if (CheckInsert) {
                        out.print("true");
                    } else {
                        out.print("false");
                    }

                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        } finally {
            out.close();
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /** 
     * Handles the HTTP <code>GET</code> method.
     * @param request servlet request
     * @param response servlet response
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(AddDataInformationSystem.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /** 
     * Handles the HTTP <code>POST</code> method.
     * @param request servlet request
     * @param response servlet response
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(AddDataInformationSystem.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /** 
     * Returns a short description of the servlet.
     */
    public String getServletInfo() {
        return "Short description";
    }
    // </editor-fold>
}
