/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import dal.PracticeDAO;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Admin
 */
public class NewPracticeController extends HttpServlet {

 
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PracticeDAO practiceDAO = PracticeDAO.getInstance();
        
        List<String> listDimension = practiceDAO.getListDimensionName();
        List<String> listSubject = practiceDAO.getListSubjectName();
        
        request.setAttribute("listDimension", listDimension);
        request.setAttribute("listSubject", listSubject);
        
        // Forward the request to newPractice.jsp
        request.getRequestDispatcher("newPractice.jsp").forward(request, response);
    }
   
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }

}
