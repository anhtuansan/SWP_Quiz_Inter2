/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import dal.Subject2DAO;
import dto.DimensionDTO;
import dto.SubjectPackagePriceDTO;
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
import model.Subject2;
import model.User;

/**
 *
 * @author Admin
 */
public class SubjectDetailExpertController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String tempId = request.getParameter("id");
        int id = 0;
        if(tempId != null){
            id = Integer.parseInt(tempId);
        }
        else{
           request.getRequestDispatcher("error.jsp").forward(request, response);
        }
        
        Subject2DAO subject2DAO = Subject2DAO.getInstance();
        List<DimensionDTO> dimensionDTOs = new ArrayList<>();
        dimensionDTOs = subject2DAO.getListDimensionDTO();
        request.setAttribute("dimensions", dimensionDTOs);
                
        List<Dimension> dimensionList = new ArrayList<>();
        dimensionList = subject2DAO.getListDimension();
        request.setAttribute("dimensionList", dimensionList);
        
        Subject2 subject = subject2DAO.getSubjectById(id);
        request.setAttribute("subject", subject);
        
        
        List<SubjectPackagePriceDTO> packageList = new ArrayList<>();
        packageList = subject2DAO.getListSubjectPackagePriceDTO(id);
         request.setAttribute("packageList", packageList);
        
        request.getRequestDispatcher("subjectDetailExpert.jsp").forward(request, response);
    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Subject2DAO subject2DAO = Subject2DAO.getInstance();
        String tempId = request.getParameter("id");
        int id = 0;
        if(tempId != null){
            id = Integer.parseInt(tempId);
        }
        else{
           request.getRequestDispatcher("error.jsp").forward(request, response);
        }
       
        System.out.println(id);
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
            boolean row = subject2DAO.updateSubject(id,name, img, dimensionId,description);
            if (row) {
                response.sendRedirect("subjectDetailExpert?id=" + id); // Thay đổi đường dẫn này tùy theo trang đăng nhập của bạn
                return;
            }else{
                response.sendRedirect("/QuizPractice/error.jsp");
            }
        }
    }

}
