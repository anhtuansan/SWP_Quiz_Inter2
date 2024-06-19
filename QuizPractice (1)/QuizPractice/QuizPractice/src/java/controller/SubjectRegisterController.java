/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import dal.Subject2DAO;
import dal.SubjectDAO;
import dal.UserDAO;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.net.URLEncoder;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import model.PricePackage2;
import model.User;
import util.mail.Mail;
import util.security.CodeVerify;
import util.security.Security;

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
                response.sendRedirect("/QuizPractice?success=true");
            } catch (Exception ex) {
                String message = "Đăng ký không thành công!";
                response.sendRedirect("/QuizPractice?error=true&message=" + message);
            }
        } //Nếu chưa logged in thì tạo user vơi thông tin nhập vào và lấy id cho vào bảng
        else {

            String userName = request.getParameter("userName");
            String email = request.getParameter("email");
            String phoneNumber = request.getParameter("phoneNumber");
            String gender = request.getParameter("gender");
            String password = "123";//default
            String token = CodeVerify.generateVerificationCode();
            password = Security.encryptToSHA512(password);

            User user2 = new User();
            user2.setFullName(userName);
            user2.setEmail(email);
            user2.setPhoneNumber(phoneNumber);
            user2.setGender(Boolean.parseBoolean(gender));
            user2.setPassword(password);
            user2.setToken(token);
            try {
//                subject2DAO.addNewUser(userName, email, phoneNumber, gender, password);


                UserDAO userDAO = UserDAO.getInstance();
                userDAO.insert(user2);  // Insert the user into the database
                
                int userId = userDAO.getLastUserId();
                subject2DAO.addNewSubjectRegister(subjectId, userId, pricePackageId);
                
                // Create an activation link
                String activeLink = request.getScheme() + "://"
                        + request.getServerName()
                        + ":"
                        + request.getServerPort()
                        + "/QuizPractice/active";

                // Send a verification email
                boolean mailSent = Mail.sendMailVerify(email, token, activeLink);
                if (mailSent) {
                    response.sendRedirect("/QuizPractice?success=true&message=Registration successful./nCheck your email and login with password : 123");
                } else {
                    throw new Exception("Failed to send verification email.");
                }

            } catch (Exception ex) {
                ex.printStackTrace();
                // Mã hóa thông điệp lỗi để hiển thị trên URL
                String message = URLEncoder.encode("Đăng ký không thành công: " + ex.getMessage(), "UTF-8");
                response.sendRedirect("/QuizPractice?error=true&message=" + message);
            }

        }

    }

}
