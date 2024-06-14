/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import dal.Subject2DAO;
import dto.DimensionDTO;
import dto.SubjectManagerDTO;
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
public class SubjectManagerController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        List<SubjectManagerDTO> lst = new ArrayList<>();
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

        lst = subject2DAO.getPaginationExpertManagerSubject(user.getUserId(), page, recordsPerPage);
        int totalRecords = subject2DAO.getTotalRecordsExpertManagerSubject(user.getUserId());
        int totalPages = (int) Math.ceil(totalRecords * 1.0 / recordsPerPage);

        List<DimensionDTO> dimensionDTOs = new ArrayList<>();
        dimensionDTOs = subject2DAO.getListDimensionDTO();
        request.setAttribute("dimensions", dimensionDTOs);

        request.setAttribute("listSubject", lst);
        request.setAttribute("currentPage", page);
        request.setAttribute("totalPages", totalPages);

        request.getRequestDispatcher("/subjectManager.jsp").forward(request, response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String type = request.getParameter("typeSubmit");
        System.out.println(type);
        if (type.equalsIgnoreCase("submitName")) {
            String subjectName = request.getParameter("subjectName");
            System.out.println(subjectName);
            List<SubjectManagerDTO> lst = new ArrayList<>();
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

            lst = subject2DAO.getPaginationExpertManagerSubjectSearchBySubjectName(user.getUserId(), page, recordsPerPage, subjectName);
            int totalRecords = subject2DAO.getTotalRecordsExpertManagerSubjectSearchBySubjectName(user.getUserId(), subjectName);
            int totalPages = (int) Math.ceil(totalRecords * 1.0 / recordsPerPage);

            List<DimensionDTO> dimensionDTOs = new ArrayList<>();
            dimensionDTOs = subject2DAO.getListDimensionDTO();
            request.setAttribute("dimensions", dimensionDTOs);

            request.setAttribute("listSubject", lst);
            request.setAttribute("currentPage", page);
            request.setAttribute("totalPages", totalPages);

            request.getRequestDispatcher("/subjectManager.jsp").forward(request, response);
        }
        else if (type.equalsIgnoreCase("dimensionId")) {
            int dimensionId = Integer.parseInt(request.getParameter("dimensionId"));
            System.out.println(dimensionId);
            List<SubjectManagerDTO> lst = new ArrayList<>();
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

            lst = subject2DAO.getPaginationExpertManagerSubjectSearchByDimensionId(user.getUserId(), page, recordsPerPage, dimensionId);
            int totalRecords = subject2DAO.getTotalRecordsExpertManagerSubjectSearchByDimensionId(user.getUserId(), dimensionId);
            int totalPages = (int) Math.ceil(totalRecords * 1.0 / recordsPerPage);

            List<DimensionDTO> dimensionDTOs = new ArrayList<>();
            dimensionDTOs = subject2DAO.getListDimensionDTO();
            request.setAttribute("dimensions", dimensionDTOs);

            request.setAttribute("listSubject", lst);
            request.setAttribute("currentPage", page);
            request.setAttribute("totalPages", totalPages);

            request.getRequestDispatcher("/subjectManager.jsp").forward(request, response);
        }
        else if (type.equalsIgnoreCase("status")) {
            int status = request.getParameter("status").equalsIgnoreCase("true")?1:0;
            System.out.println(status);
            List<SubjectManagerDTO> lst = new ArrayList<>();
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

            lst = subject2DAO.getPaginationExpertManagerSubjectSearchByStatus(user.getUserId(), page, recordsPerPage, status);
            int totalRecords = subject2DAO.getTotalRecordsExpertManagerSubjectSearchByStatus(user.getUserId(), status);
            int totalPages = (int) Math.ceil(totalRecords * 1.0 / recordsPerPage);

            List<DimensionDTO> dimensionDTOs = new ArrayList<>();
            dimensionDTOs = subject2DAO.getListDimensionDTO();
            request.setAttribute("dimensions", dimensionDTOs);

            request.setAttribute("listSubject", lst);
            request.setAttribute("currentPage", page);
            request.setAttribute("totalPages", totalPages);

            request.getRequestDispatcher("/subjectManager.jsp").forward(request, response);
        }
    }

}
