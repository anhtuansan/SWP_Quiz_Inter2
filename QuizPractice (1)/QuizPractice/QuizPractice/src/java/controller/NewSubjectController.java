/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import dal.Subject2DAO;
import dto.DimensionDTO;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import model.User;

/**
 *
 * @author Admin
 */
public class NewSubjectController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Subject2DAO subject2DAO = Subject2DAO.getInstance();
        List<DimensionDTO> dimensionDTOs = new ArrayList<>();
        dimensionDTOs = subject2DAO.getListDimensionDTO();
        request.setAttribute("dimensions", dimensionDTOs);
        request.getRequestDispatcher("newSubject.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Subject2DAO subject2DAO = Subject2DAO.getInstance();
        String img = request.getParameter("img");
        System.out.println(img);
        String name = request.getParameter("name");
        System.out.println(name);
        int dimensionId = Integer.parseInt(request.getParameter("dimensionId"));
        System.out.println(dimensionId);
        String description = request.getParameter("description");
        System.out.println(description);

        //creator_id
        //creater_at
        //status=1
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");
        if (user == null) {
            response.sendRedirect("/QuizPractice/"); // Thay đổi đường dẫn này tùy theo trang đăng nhập của bạn
            return;
        } else {
            int creator_id = user.getUserId();
            int status = 1;

            boolean row = subject2DAO.insert(name, img, dimensionId, creator_id, status,description);
            if (row) {
                response.sendRedirect("lessonManager"); // Thay đổi đường dẫn này tùy theo trang đăng nhập của bạn
                return;
            }else{
                response.sendRedirect("/QuizPractice/error.jsp");
            }
        }

    }

}
