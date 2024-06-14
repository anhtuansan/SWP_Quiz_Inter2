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
public class EditDimensionController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Get dimensionId from request parameter
        int dimensionId = Integer.parseInt(request.getParameter("id"));

        Subject2DAO subject2DAO = Subject2DAO.getInstance();
        // Retrieve dimension from service layer
        Dimension dimension = subject2DAO.getDimensionById(dimensionId);

        if (dimension != null) {
            response.setContentType("application/json");
            response.setCharacterEncoding("UTF-8");
            response.getWriter().write(new Gson().toJson(new JsonResponse(true, dimension)));
        } else {
            response.setContentType("application/json");
            response.setCharacterEncoding("UTF-8");
            response.getWriter().write(new Gson().toJson(new JsonResponse(false, null)));
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("dimensionId"));

        String name = request.getParameter("dimensionName");
        String type = request.getParameter("type");
        String description = request.getParameter("description");
        System.out.println(id + name + description + type);

        Subject2DAO subject2DAO = Subject2DAO.getInstance();
        boolean result = subject2DAO.updateDimension(id, name, type, description);
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
