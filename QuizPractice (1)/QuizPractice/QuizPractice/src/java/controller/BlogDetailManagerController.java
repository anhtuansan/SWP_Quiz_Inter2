/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import dal.BlogDAO;
import dto.BlogManagerDetailDTO;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.util.List;
import model.Category;
import model.User;

/**
 *
 * @author Admin
 */
public class BlogDetailManagerController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String idParam = request.getParameter("id");
        int id = -1;

        try {
            if (idParam != null && !idParam.isEmpty()) {
                id = Integer.parseInt(idParam);
            }
        } catch (NumberFormatException e) {
            // Log lỗi nếu cần thiết
        }

        if (id == -1) {
            // ID không hợp lệ hoặc không được truyền vào
            // Chuyển hướng đến trang lỗi hoặc trang mặc định
            String message = "ID BLOG NOT FOUND!";
             response.sendRedirect("/QuizPractice?error=true&message=" + message);
          
            return;
        }
        
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");
        if (user == null || user.getRoleId()!=5) {
             String message = "Permission granted! Login with role marketing to access page.";
             response.sendRedirect("/QuizPractice?error=true&message=" + message);
            return;
        }

        BlogDAO blogDao = BlogDAO.getInstance();
        BlogManagerDetailDTO blog = blogDao.getBlogDetailDTOById(id);

        if (blog == null) {
            // Blog không tồn tại với ID đã cho
            response.sendRedirect("errorPage.jsp"); // hoặc trang mặc định
            return;
        }

        List<Category> listCategory = blogDao.getAllCategories();

        request.setAttribute("listCategory", listCategory);
        request.setAttribute("blog", blog);
        request.getRequestDispatcher("blogDetailManager.jsp")
                .forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String status2 = request.getParameter("status");
        boolean status = (status2 != null && status2.equalsIgnoreCase("on")) ? true : false;
        System.out.println(status);

        int id = Integer.parseInt(request.getParameter("id"));
        String title = request.getParameter("title");
        String categoryName = request.getParameter("categoryName");
        String content = request.getParameter("content");
       // boolean status = Boolean.parseBoolean(request.getParameter("status"));
        String thumbnail = request.getParameter("thumbnail");
        String briefinfo = request.getParameter("briefinfo");

        BlogManagerDetailDTO blog = new BlogManagerDetailDTO(id, title, categoryName, content, status,thumbnail, briefinfo);
        //System.out.println(blog);

        BlogDAO blogDao = BlogDAO.getInstance();
        boolean updated = blogDao.updateBlog(blog);

        if (updated) {
            // Cập nhật thành công, chuyển hướng đến trang thành công
            response.sendRedirect("blogManager.jsp");
        } else {
            // Cập nhật thất bại, chuyển hướng đến trang lỗi
            response.sendRedirect("errorPage.jsp");
        }
    }

}
