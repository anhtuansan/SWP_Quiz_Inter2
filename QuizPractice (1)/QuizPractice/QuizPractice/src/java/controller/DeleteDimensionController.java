/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import com.google.gson.Gson;
import dal.Subject2DAO;
import jakarta.servlet.RequestDispatcher;
import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Dimension;

/**
 *
 * @author Admin
 */
public class DeleteDimensionController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
      
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {      
        int id = Integer.parseInt(request.getParameter("id"));
        System.out.println(id);

        Subject2DAO subject2DAO = Subject2DAO.getInstance();
        boolean result = subject2DAO.deleteDimension(id);
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
}
