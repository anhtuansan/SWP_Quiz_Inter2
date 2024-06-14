/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import com.google.gson.Gson;
import dal.Subject2DAO;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Dimension;

/**
 *
 * @author Admin
 */
public class ChangePackageStatus extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int packageId = Integer.parseInt(request.getParameter("id"));
        String status = request.getParameter("status");
        int subjectId = Integer.parseInt(request.getParameter("subjectId"));
        System.out.println(packageId+status+subjectId);
         Subject2DAO subject2DAO = Subject2DAO.getInstance();
          boolean result = false;
        if(status.equalsIgnoreCase("active")){
             result = subject2DAO.addSubjectPricePackage(packageId,subjectId);
        }else{
             result = subject2DAO.deleteSubjectPricePackage(packageId,subjectId);
        }
        
       
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        response.getWriter().write(new Gson().toJson(new JsonResponse(result, null)));
    }

    private class JsonResponse {
        boolean success;
        Dimension dimension;

        public JsonResponse(boolean success, Dimension dimension) {
            this.success = success;
            this.dimension = dimension;
        }
    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }

}
