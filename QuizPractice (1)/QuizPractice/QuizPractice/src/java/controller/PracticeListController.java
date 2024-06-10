/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import dal.PracticeDAO;
import dal.Subject2DAO;
import dto.MyRegisterDTO;
import dto.PracticeListDTO;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;
import model.User;

/**
 *
 * @author Admin
 */
public class PracticeListController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        List<PracticeListDTO> lst = new ArrayList<>();
        List<String> listSubjectName = new ArrayList<>();
        PracticeDAO practiceDAO = PracticeDAO.getInstance();
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

        lst = practiceDAO.getPaginationPracticeList(user.getUserId(), page, recordsPerPage);
        int totalRecords = practiceDAO.getTotalRecords(user.getUserId());
        int totalPages = (int) Math.ceil(totalRecords * 1.0 / recordsPerPage);
        
        listSubjectName = practiceDAO.getListSubjectName();
        request.setAttribute("subjects", listSubjectName);
         
        request.setAttribute("practices", lst);
        request.setAttribute("currentPage", page);
        request.setAttribute("totalPages", totalPages);

        request.getRequestDispatcher("/practiceList.jsp").forward(request, response);
    }

   
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String subject = request.getParameter("subject");
        
        List<PracticeListDTO> lst = new ArrayList<>();
        List<String> listSubjectName = new ArrayList<>();
        PracticeDAO practiceDAO = PracticeDAO.getInstance();
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

        lst = practiceDAO.getPaginationPracticeListSearch(user.getUserId(), page, recordsPerPage,subject);
        int totalRecords = practiceDAO.getTotalRecordsSearch(user.getUserId(),subject);
        int totalPages = (int) Math.ceil(totalRecords * 1.0 / recordsPerPage);
        
        listSubjectName = practiceDAO.getListSubjectName();
        request.setAttribute("subjects", listSubjectName);
         
        request.setAttribute("practices", lst);
        request.setAttribute("currentPage", page);
        request.setAttribute("totalPages", totalPages);

        request.getRequestDispatcher("/practiceList.jsp").forward(request, response);
    }

}
