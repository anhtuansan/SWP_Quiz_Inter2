package controller;

// Import necessary classes
import dal.BlogDAO;
import dal.SliderDAO;
import dal.SubjectDAO;
import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.util.List;
import model.Blog;
import model.Slider;
import model.Subject;

// Servlet class for handling requests to the home page
@WebServlet("/home")
public class HomeController extends HttpServlet {

    // Handles GET requests
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Kiểm tra và nhận tham số lỗi từ URL
        String errorMessage = request.getParameter("error");
        String successMessage = request.getParameter("success");
        String message = request.getParameter("message");

        if (errorMessage != null && errorMessage.equals("true")) {
            request.setAttribute("error", "true");
            request.setAttribute("errorMessage", message);
        } else if (successMessage != null && successMessage.equals("true")) {
            request.setAttribute("success", "true");
            request.setAttribute("successMessage", message);
        }

        // Forward the request to the home.jsp page
        BlogDAO blogDAO = BlogDAO.getInstance();
        SliderDAO sliderDAO = SliderDAO.getInstance();
        SubjectDAO subjectDAO = SubjectDAO.getInstance();

        List<Blog> top8Blog = blogDAO.listTop8Blog();
        List<Slider> top8Slider = sliderDAO.listTop8Slider();
        List<Subject> top8Subject = subjectDAO.listTop8Subject();
        List<Subject> top3Subject = subjectDAO.find3FeatureSubject();

        HttpSession session = request.getSession();

        // Đặt các danh sách vào phạm vi request
        request.setAttribute("top8Blog", top8Blog);
        request.setAttribute("top8Slider", top8Slider);
        request.setAttribute("top8Subject", top8Subject);
        session.setAttribute("top3Subject", top3Subject);

        // Chuyển hướng đến trang home.jsp
        request.getRequestDispatcher("/home.jsp").forward(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method. This method is currently not
     * implemented.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Currently, no implementation for POST requests.
        // Typically, you might forward to doGet(request, response) or handle POST-specific logic.
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "HomeServlet handles requests to the home page.";
    }

}
