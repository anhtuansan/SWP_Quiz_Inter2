/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import dal.Subject2DAO;
import dal.UserDAO;
import dto.DimensionDTO;
import dto.MyRegisterDTO;
import jakarta.servlet.RequestDispatcher;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;
import model.Dimension;
import model.User;

/**
 *
 * @author Admin
 */
public class MyRegisterServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        List<MyRegisterDTO> lst = new ArrayList<>();
        Subject2DAO subject2DAO = Subject2DAO.getInstance();
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");
        if (user == null) {
            response.sendRedirect("/QuizPractice/"); // Thay đổi đường dẫn này tùy theo trang đăng nhập của bạn
            return;
        }

        // Lấy trang hiện tại từ request
        int page = 1;
        int recordsPerPage = 5;
        if (request.getParameter("page") != null) {
            page = Integer.parseInt(request.getParameter("page"));
        }
        
          // lay ra data search
        String name = "";
        if (request.getParameter("searchName") != null) {
            name = request.getParameter("searchName");
        }
        String content = "";
        if (request.getParameter("searchContent") != null) {
            content = request.getParameter("searchContent");
        }
        int dimensionId = -1;
        if (request.getParameter("searchDimensionId") != null && !request.getParameter("searchDimensionId").isEmpty()) {
            dimensionId = Integer.parseInt(request.getParameter("searchDimensionId"));
        }

        lst = subject2DAO.getPaginationRegisterSubjectAll(user.getUserId(), page, recordsPerPage, dimensionId, name, content);
        int totalRecords = subject2DAO.getTotalRecords(user.getUserId(),dimensionId,name,content);
        int totalPages = (int) Math.ceil(totalRecords * 1.0 / recordsPerPage);

        request.setAttribute("listRegister", lst);
        request.setAttribute("currentPage", page);
        request.setAttribute("totalPages", totalPages);
                
        request.setAttribute("searchName", name);
        request.setAttribute("searchContent", content);
        request.setAttribute("searchDimensionId", dimensionId);
                
        List<DimensionDTO> listDimension = subject2DAO.getListDimensionDTO();
        request.setAttribute("listDimension", listDimension);
                
//        RequestDispatcher dispatcher = request.getRequestDispatcher("/myRegister.jsp");
//        dispatcher.include(request, response);
        request.getRequestDispatcher("/myRegister.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        // Nhận tham số từ form
//        String subjectName = request.getParameter("subjectName");
//        
//        List<MyRegisterDTO> lst = new ArrayList<>();
//        Subject2DAO subject2DAO = Subject2DAO.getInstance();
//        HttpSession session = request.getSession();
//        User user = (User) session.getAttribute("user");
//        if (user == null) {
//            response.sendRedirect("/QuizPractice/"); // Thay đổi đường dẫn này tùy theo trang đăng nhập của bạn
//            return;
//        }
//
//        // Lấy trang hiện tại từ request
//        int page = 1;
//        int recordsPerPage = 5;
//        if (request.getParameter("page") != null) {
//            page = Integer.parseInt(request.getParameter("page"));
//        }
//
//        lst = subject2DAO.getPaginationRegisterSubjectSearch(user.getUserId(), page, recordsPerPage,subjectName);
//        int totalRecords = subject2DAO.getTotalRecords(user.getUserId());
//        int totalPages = (int) Math.ceil(totalRecords * 1.0 / recordsPerPage);
//
//        request.setAttribute("listRegister", lst);
//        request.setAttribute("currentPage", page);
//        request.setAttribute("totalPages", totalPages);
//
//        request.getRequestDispatcher("/myRegister.jsp").forward(request, response);
//    }
    }
}
