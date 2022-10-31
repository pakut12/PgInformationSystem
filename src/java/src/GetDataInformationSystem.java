/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package src;

import java.io.*;


import java.net.URL;
import java.net.URLConnection;
import javax.servlet.*;
import javax.servlet.http.*;
import org.json.simple.JSONObject;
import service.InformationSystem;
import service.InformationSystem.*;

/**
 *
 * @author pakutsing
 */
public class GetDataInformationSystem extends HttpServlet {

    /** 
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code> methods.
     * @param request servlet request
     * @param response servlet response
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try {
            
            InformationSystem info = new InformationSystem();
            String pcuser = request.getHeader("USER-AGENT");

            JSONObject obj = new JSONObject();
            obj.put("User", info.GetUserPc());
            obj.put("ComputerName", info.GetComputerName());
            obj.put("Ip", info.GetIp());
            obj.put("OS", info.GetOs(pcuser));
            obj.put("ProgramFiles", info.GetProgramFiles());
            obj.put("ProgramFilesx86", info.GetProgramFilesx86());
            
            out.print(obj);

          


        } catch (Exception e) {
            e.printStackTrace();
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
        processRequest(request, response);
    }

    /** 
     * Handles the HTTP <code>POST</code> method.
     * @param request servlet request
     * @param response servlet response
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /** 
     * Returns a short description of the servlet.
     */
    public String getServletInfo() {
        return "Short description";
    }
// </editor-fold>
}
