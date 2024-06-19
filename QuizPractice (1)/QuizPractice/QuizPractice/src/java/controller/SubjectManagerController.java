package controller;

import dal.Subject2DAO;
import dto.DimensionDTO;
import dto.SubjectManagerDTO;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import model.User;

public class SubjectManagerController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        List<SubjectManagerDTO> lst = new ArrayList<>();
        Subject2DAO subject2DAO = Subject2DAO.getInstance();
        
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");
        if (user == null || (user.getRoleId() != 2 && user.getRoleId() != 3)) {
            String message = "Permission granted! Login with role marketing to access page.";
            response.sendRedirect("/QuizPractice?error=true&message=" + message);
            return;
        }

        // Get the current page from the request
        int page = 1;
        int recordsPerPage = 5;
        if (request.getParameter("page") != null) {
            page = Integer.parseInt(request.getParameter("page"));
        }

        // Get search data
        String name = "";
        if (request.getParameter("searchName") != null) {
            name = request.getParameter("searchName");
        }

        int dimensionId = -1;
        if (request.getParameter("searchDimensionId") != null && !request.getParameter("searchDimensionId").isEmpty()) {
            dimensionId = Integer.parseInt(request.getParameter("searchDimensionId"));
        }

        int status = -1;
        if (request.getParameter("searchStatus") != null && !request.getParameter("searchStatus").isEmpty()) {
            status = Integer.parseInt(request.getParameter("searchStatus"));
        }

        lst = subject2DAO.getPaginationExpertManagerSubjectAll(user.getUserId(), page, recordsPerPage, name, dimensionId == -1 ? null : dimensionId, status == -1 ? null : status);
        int totalRecords = subject2DAO.getTotalRecordsExpertManagerSubjectAll(user.getUserId(), name, dimensionId == -1 ? null : dimensionId, status == -1 ? null : status);
        int totalPages = (int) Math.ceil(totalRecords * 1.0 / recordsPerPage);

        List<DimensionDTO> dimensionDTOs = subject2DAO.getListDimensionDTO();
        request.setAttribute("dimensions", dimensionDTOs);

        request.setAttribute("listSubject", lst);
        request.setAttribute("currentPage", page);
        request.setAttribute("totalPages", totalPages);
        request.setAttribute("searchName", name);
        request.setAttribute("searchDimensionId", dimensionId);
        request.setAttribute("searchStatus", status);

        request.getRequestDispatcher("/subjectManager.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Handle POST request if needed
    }
}
