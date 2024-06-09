/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import dal.Subject2DAO;
import dal.SubjectDAO;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.Map;
import model.PricePackage2;
import model.User;

/**
 *
 * @author Admin
 */
public class SubjectRegisterController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            int subjectId = Integer.parseInt(request.getParameter("subjectId"));
            String subjectName = request.getParameter("subjectName");

            Subject2DAO subject2DAO = Subject2DAO.getInstance();
            List<PricePackage2> listPricePackage = subject2DAO.getPricePackageBySubjectId(subjectId);

            // Đặt listPricePackage vào request attribute
            request.setAttribute("listPricePackage", listPricePackage);
            request.setAttribute("subjectName", subjectName);
            request.setAttribute("subjectId", subjectId);

            // Chuyển tiếp request tới JSP để hiển thị modal
            request.getRequestDispatcher("/layout/subjectRegisterPopUp.jsp").forward(request, response);
        } catch (NumberFormatException e) {
            e.printStackTrace();
            response.sendError(HttpServletResponse.SC_BAD_REQUEST, "Invalid subject ID format");
        } catch (Exception e) {
            e.printStackTrace();
            response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "An unexpected error occurred");
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Subject2DAO subject2DAO = Subject2DAO.getInstance();
        int pricePackageId = Integer.parseInt(request.getParameter("pricePackageId"));
        int subjectId = Integer.parseInt(request.getParameter("subjectId"));

        //Neu user logged in thì add luôn vào bảng
        User user = (User) request.getSession().getAttribute("user");
        if (user != null) {
            try {
                subject2DAO.addNewSubjectRegister(subjectId, user.getUserId(), pricePackageId);
            } catch (Exception ex) {
                 PrintWriter out = response.getWriter();
                 out.println("<p>" + ex + "</p>");
            }
        } 
        
        //Nếu chưa logged in thì tạo user vơi thông tin nhập vào và lấy id cho vào bảng
        else {
            String userName = request.getParameter("userName");
            String email = request.getParameter("email");
            String phoneNumber = request.getParameter("phoneNumber");
            String gender = request.getParameter("gender");
            
            try {
                subject2DAO.addNewUser(userName, email, phoneNumber, gender);
                int userId = subject2DAO.getLastUserId(); 
                subject2DAO.addNewSubjectRegister(subjectId, userId, pricePackageId);
                PrintWriter out = response.getWriter();
                out.println("<p>" + "Register successfully"+ "</p>");
                
            } catch (Exception ex) {
                 PrintWriter out = response.getWriter();
                 out.println("<p>" + ex + "</p>");
            }

        }

    }

}
