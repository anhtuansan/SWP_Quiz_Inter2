/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import dal.Subject2DAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
/**
 *
 * @author Admin
 */
public class DeleteRegisterSubjectServlet extends HttpServlet {

    @Override
      protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Lấy id của mục cần xóa từ request
        int id = Integer.parseInt(request.getParameter("id"));

        // Thực hiện xóa mục trong cơ sở dữ liệu
        Subject2DAO subject2DAO = Subject2DAO.getInstance();
        boolean deleted = subject2DAO.deleteRegister(id);

        if (deleted) {
            // Nếu xóa thành công, cập nhật lại dữ liệu và trả về response thành công
            response.getWriter().write("Deleted successfully");
            response.setStatus(HttpServletResponse.SC_OK);
        } else {
            // Nếu xóa không thành công, trả về response lỗi
            response.getWriter().write("Failed to delete");
            response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
        }
    }

   
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }
}
