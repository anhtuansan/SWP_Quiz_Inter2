/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dal;

import context.DBContext;
import dto.MyRegisterDTO;
import java.beans.Statement;
import java.sql.Date;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import model.PricePackage2;
import model.Subject;

/**
 *
 * @author Admin
 */
public class Subject2DAO extends DBContext {
    // Singleton instance of UserDAO

    private static Subject2DAO instance;
    // Lock object for thread-safe singleton instantiation
    private static Object lockPad = new Object();

    // Private constructor to prevent instantiation
    private Subject2DAO() {
    }

    // Returns the singleton instance of UserDAO
    public static Subject2DAO getInstance() {
        if (instance == null) {
            synchronized (lockPad) {
                if (instance == null) {
                    instance = new Subject2DAO();
                }
            }
        }
        return instance;
    }

    public List<MyRegisterDTO> getPaginationRegisterSubjectSearch(int userId, int page, int recordsPerPage, String searchName) {
        List<MyRegisterDTO> lst = new ArrayList<>();
        int start = (page - 1) * recordsPerPage + 1;
        int end = start + recordsPerPage - 1;

        try {
            String query = "WITH PagedResults AS (\n"
                    + "    SELECT r.id,s.name AS subject_name, r.CreatedAt, p.name AS package_name, p.original_price, r.Status,\n"
                    + "           ROW_NUMBER() OVER (ORDER BY r.CreatedAt) AS row_num\n"
                    + "    FROM Subject_Register r \n"
                    + "    LEFT JOIN subjects s ON r.SubjectId = s.id \n"
                    + "\n"
                    + "    LEFT JOIN package_price p ON p.id = r.PackageId\n"
                    + "    WHERE r.UserId = ? and s.name like ?\n"
                    + ")\n"
                    + "SELECT * \n"
                    + "FROM PagedResults\n"
                    + "WHERE row_num BETWEEN ? AND ?\n"
                    + "ORDER BY row_num;";

            ps = connection.prepareStatement(query);
            ps.setInt(1, userId); // Thay đổi UserId tương ứng
            ps.setString(2, "%" + searchName + "%");
            ps.setInt(3, start);
            ps.setInt(4, end);
            rs = ps.executeQuery();

            while (rs.next()) {
                int id = rs.getInt(1);
                String subjectName = rs.getString(2);
                Date duration = rs.getDate(3);
                String packageName = rs.getString(4);
                double originalPrice = rs.getDouble(5);
                String status = rs.getString(6);

                MyRegisterDTO p = new MyRegisterDTO(id, subjectName, duration, packageName, originalPrice, status);
                lst.add(p);
            }
        } catch (SQLException ex) {
        }
        return lst;
    }

    public boolean deleteRegister(int id) {
        // SQL query with placeholders for parameterized input
        String query = "delete from Subject_Register where id = ?";

        try {
            // Prepare the SQL query for execution
            ps = connection.prepareStatement(query);

            // Set parameters for the PreparedStatement
            ps.setInt(1, id);
            ps.executeUpdate();
            return true;
        } catch (SQLException e) {
            // Log the exception (if a logging framework is available)
            e.printStackTrace(); // Replace with logger in real application
            return false;
        }

    }

    public List<MyRegisterDTO> getPaginationRegisterSubject(int userId, int page, int recordsPerPage) {
        List<MyRegisterDTO> lst = new ArrayList<>();
        int start = (page - 1) * recordsPerPage + 1;
        int end = start + recordsPerPage - 1;

        try {
            String query = "WITH PagedResults AS ("
                    + "    SELECT r.id,s.name AS subject_name, r.CreatedAt, p.name AS package_name, p.original_price, r.Status,"
                    + "           ROW_NUMBER() OVER (ORDER BY r.CreatedAt) AS row_num"
                    + "    FROM Subject_Register r"
                    + "    LEFT JOIN subjects s ON r.SubjectId = s.id"
                    + "    LEFT JOIN package_price p ON p.id = r.PackageId"
                    + "    WHERE r.UserId = ?"
                    + ")"
                    + "SELECT * "
                    + "FROM PagedResults "
                    + "WHERE row_num BETWEEN ? AND ? "
                    + "ORDER BY row_num;";

            ps = connection.prepareStatement(query);
            ps.setInt(1, userId); // Thay đổi UserId tương ứng
            ps.setInt(2, start);
            ps.setInt(3, end);
            rs = ps.executeQuery();

            while (rs.next()) {
                int id = rs.getInt(1);
                String subjectName = rs.getString(2);
                Date duration = rs.getDate(3);
                String packageName = rs.getString(4);
                double originalPrice = rs.getDouble(5);
                String status = rs.getString(6);

                MyRegisterDTO p = new MyRegisterDTO(id, subjectName, duration, packageName, originalPrice, status);
                lst.add(p);
            }
        } catch (SQLException ex) {
        }
        return lst;
    }

    public int getTotalRecords(int userId) {
        String query = "SELECT COUNT(*) FROM Subject_Register WHERE UserId = ?";
        try {
            ps = connection.prepareStatement(query);
            ps.setInt(1, userId);
            rs = ps.executeQuery();

            while (rs.next()) {
                int id = rs.getInt(1);
                return id;
            }

        } catch (SQLException e) {
            // Log the exception (if a logging framework is available)
            e.printStackTrace(); // Replace with logger in real application
        }
        return 0;
    }

    public List<PricePackage2> getPricePackageBySubjectId(int subjectId) {
        List<PricePackage2> listPricePackage = new ArrayList<>();
        try {
            String query = "select * \n"
                    + "from package_price p\n"
                    + "where p.id in(\n"
                    + "select price_package_id from  subject_has_price_package \n"
                    + "where subject_id = ?)";

            ps = connection.prepareStatement(query);
            ps.setInt(1, subjectId);
            rs = ps.executeQuery();
            while (rs.next()) {
                int id = rs.getInt(1);
                String name = rs.getString(2);
                int duration = rs.getInt(3);
                double salePrice = rs.getDouble(4);
                double price = rs.getDouble(5);
                double originalPrice = rs.getDouble(6);

                PricePackage2 p = new PricePackage2(id, name, duration, salePrice, price, originalPrice);
                listPricePackage.add(p);
            }
        } catch (SQLException ex) {
        }
        return listPricePackage;
    }

    public void addNewSubjectRegister(int subjectId, int userId, int packageId) {
        // SQL query with placeholders for parameterized input
        String query = "insert into Subject_Register \n"
                + "values(?,?,?,?,null,null,'pending')";

        try {
            // Prepare the SQL query for execution
            ps = connection.prepareStatement(query);

            // Set parameters for the PreparedStatement
            ps.setInt(1, subjectId);
            ps.setInt(2, userId);
            ps.setInt(3, packageId);
            ps.setDate(4, Date.valueOf(LocalDate.now()));

            ps.executeUpdate();
        } catch (SQLException e) {
            // Log the exception (if a logging framework is available)
            e.printStackTrace(); // Replace with logger in real application
        }

    }

//    String userName = request.getParameter("userName");
//            String email = request.getParameter("email");
//            String phoneNumber = request.getParameter("phoneNumber");
//            String gender = request.getParameter("gender");
    public void addNewUser(String userName, String email, String phoneNumber, String gender) {
        String query = "insert into users(full_name, email, phone_number, password,gender,created_at,role_id,status_id) \n"
                + "values(?,?,?,?,?,?,?,?);";

        String password = "123";
        int role = 1;
        int status = 2;
        int gender2 = gender.equalsIgnoreCase("male") ? 1 : 0;

        try {
            // Prepare the SQL query for execution
            ps = connection.prepareStatement(query);

            // Set parameters for the PreparedStatement
            ps.setString(1, userName);
            ps.setString(2, email);
            ps.setString(3, phoneNumber);
            ps.setString(4, password);
            ps.setInt(5, gender2);
            ps.setDate(6, Date.valueOf(LocalDate.now()));
            ps.setInt(7, role);
            ps.setInt(8, status);

            ps.executeUpdate();

        } catch (SQLException e) {
            // Log the exception (if a logging framework is available)
            e.printStackTrace(); // Replace with logger in real application
        }

    }

    public int getLastUserId() {
        String query = "SELECT @@IDENTITY AS LastInsertedId";
        try {
            ps = connection.prepareStatement(query);
            rs = ps.executeQuery();

            while (rs.next()) {
                int id = rs.getInt(1);
                return id;
            }

        } catch (SQLException e) {
            // Log the exception (if a logging framework is available)
            e.printStackTrace(); // Replace with logger in real application
        }
        return 0;
    }

    public static void main(String[] args) {
        // view all subjects in database with status = 1
        Subject2DAO c = new Subject2DAO();
//
//        System.out.println(c.getPricePackageBySubjectId(2));
//        //c.addNewSubjectRegister(2, 27, 3);
//        c.addNewUser("hihi", "hihi@gmail.com", "1231231", "male");
//        
//        System.out.println(c.getLastUserId());

        //System.out.println(c.getPaginationRegisterSubject(27, 2, 5));
        //System.out.println(c.getTotalRecords(27));
        //c.deleteRegister(9);
    }
}
