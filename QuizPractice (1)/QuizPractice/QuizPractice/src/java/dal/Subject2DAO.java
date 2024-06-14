/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dal;

import context.DBContext;
import dto.DimensionDTO;
import dto.MyRegisterDTO;
import dto.SubjectManagerDTO;
import dto.SubjectPackagePriceDTO;
import java.beans.Statement;
import java.lang.System.Logger;
import java.lang.System.Logger.Level;
import java.sql.Date;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import model.Dimension;
import model.PricePackage2;
import model.Subject;
import model.Subject2;

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
    
     public boolean addSubjectPricePackage(int packageId, int subjectId) {
        boolean updated = false;
        String query = "insert into subject_has_price_package values(?,?)";
        try {
            ps = connection.prepareStatement(query);
            ps.setInt(1, subjectId);
            ps.setInt(2, packageId);

            int rowsAffected = ps.executeUpdate();
            if (rowsAffected > 0) {
                updated = true;
            }
        } catch (SQLException ex) {
            ex.printStackTrace(); // Handle exception properly in a production environment
        }
        return updated;
    }
     
      public boolean deleteSubjectPricePackage(int packageId, int subjectId) {
        boolean updated = false;
        String query = "delete from subject_has_price_package where subject_id=? and price_package_id=?";
        try {
            ps = connection.prepareStatement(query);
            ps.setInt(1, subjectId);
            ps.setInt(2, packageId);

            int rowsAffected = ps.executeUpdate();
            if (rowsAffected > 0) {
                updated = true;
            }
        } catch (SQLException ex) {
            ex.printStackTrace(); // Handle exception properly in a production environment
        }
        return updated;
    }
    
    

    public List<SubjectPackagePriceDTO> getListSubjectPackagePriceDTO(int subjectId) {
        List<SubjectPackagePriceDTO> lst = new ArrayList<>();

        try {
            String query = "SELECT \n"
                    + "    pp.*,\n"
                    + "    CASE \n"
                    + "        WHEN EXISTS (\n"
                    + "            SELECT 1 \n"
                    + "            FROM subject_has_price_package shpp \n"
                    + "            WHERE shpp.price_package_id = pp.id \n"
                    + "              AND shpp.subject_id = ?\n"
                    + "        ) THEN 'active'\n"
                    + "        ELSE 'inactive'\n"
                    + "    END AS status\n"
                    + "FROM \n"
                    + "package_price pp";

            ps = connection.prepareStatement(query);
            ps.setInt(1, subjectId);
            rs = ps.executeQuery();

            while (rs.next()) {                
                int id = rs.getInt(1);
                String name = rs.getString(2);
                int duration  = rs.getInt(3);
                double salePrice = rs.getDouble(4);
                double price = rs.getDouble(5);
                String status = rs.getString(7);
                

                SubjectPackagePriceDTO s = new SubjectPackagePriceDTO(id, name, duration, price, salePrice, status);
                lst.add(s);
            }
        } catch (SQLException ex) {
        }
        return lst;
    }

    public boolean deleteDimension(int id) {
        boolean updated = false;
        String query = "update Dimension set Status = 0 where DimensionId=?";
        try {
            ps = connection.prepareStatement(query);
            ps.setInt(1, id);

            int rowsAffected = ps.executeUpdate();
            if (rowsAffected > 0) {
                updated = true;
            }
        } catch (SQLException ex) {
            ex.printStackTrace(); // Handle exception properly in a production environment
        }
        return updated;
    }

    public boolean addDimension(String name, String type, String description) {
        boolean added = false;
        String query = "insert into Dimension (DimensionName, Type, Description,Status) values (?, ?, ?, 1)";
        try {
            ps = connection.prepareStatement(query);
            ps.setString(1, name);
            ps.setString(2, type);
            ps.setString(3, description);

            int rowsAffected = ps.executeUpdate();
            if (rowsAffected > 0) {
                added = true;
            }
        } catch (SQLException ex) {
            ex.printStackTrace(); // Handle exception properly in a production environment
        }
        return added;
    }

    public boolean updateDimension(int id, String name, String type, String description) {
        boolean updated = false;
        String query = "update Dimension set DimensionName=?, Type=?, Description=? where DimensionId=?";
        try {
            ps = connection.prepareStatement(query);
            ps.setString(1, name);
            ps.setString(2, type);
            ps.setString(3, description);
            ps.setInt(4, id);

            int rowsAffected = ps.executeUpdate();
            if (rowsAffected > 0) {
                updated = true;
            }
        } catch (SQLException ex) {
            ex.printStackTrace(); // Handle exception properly in a production environment
        }
        return updated;
    }

    public List<Dimension> getListDimension() {
        List<Dimension> lst = new ArrayList<>();

        try {
            String query = "select * from Dimension where Status = 1";

            ps = connection.prepareStatement(query);

            rs = ps.executeQuery();

            while (rs.next()) {
                int id = rs.getInt(1);
                String name = rs.getString(2);
                String type = rs.getString(3);
                String description = rs.getString(4);

                Dimension dimension = new Dimension(id, name, type, description);
                lst.add(dimension);
            }
        } catch (SQLException ex) {
        }
        return lst;
    }

    public Dimension getDimensionById(int id) {
        String query = "select * from Dimension where DimensionId =?";
        Dimension dimension = null;

        try {
            ps = connection.prepareStatement(query);
            ps.setInt(1, id);
            rs = ps.executeQuery();
            if (rs.next()) {
                String DimensionName = rs.getString(2);
                String Type = rs.getString(3);
                String Description = rs.getString(4);
                boolean Status = rs.getBoolean(5);

                dimension = new Dimension(id, DimensionName, Type, Description);
                return dimension;
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return dimension;
    }

    public Subject2 getSubjectById(int id) {
        String query = "select * from subjects where id =?";
        Subject2 subject = null;

        try {
            ps = connection.prepareStatement(query);
            ps.setInt(1, id);
            rs = ps.executeQuery();
            if (rs.next()) {
                String name = rs.getString(2);
                int creator_id = rs.getInt(3);
                Date creater_at = rs.getDate(4);
                Date updated_at = rs.getDate(5);
                int status = rs.getInt(6);
                String img = rs.getString(7);
                String description = rs.getString(8);
                int dimensionId = rs.getInt(9);

                subject = new Subject2(id, name, creator_id, creater_at, updated_at, status, img, description, dimensionId);
                return subject;
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return subject;
    }

    public boolean updateSubject(int id, String name, String img, int dimensionId, String description) {
        boolean updated = false;
        String query = "update subjects set name=? ,img=?, description=?, dimensionId=?, update_at=GETDATE() where id=?";
        try {
            ps = connection.prepareStatement(query);
            ps.setString(1, name);
            ps.setString(2, img);
            ps.setString(3, description);
            ps.setInt(4, dimensionId);
            ps.setInt(5, id);

            int rowsAffected = ps.executeUpdate();
            if (rowsAffected > 0) {
                updated = true;
            }
        } catch (SQLException ex) {

        }
        return updated;
    }

    public boolean insert(String name, String img, int dimensionId, int creator_id, int status, String description) {
        boolean updated = false;
        String query = "insert into subjects values(?,?,GETDATE(),null,1,?,?,?)";
        try {
            ps = connection.prepareStatement(query);
            ps.setString(1, name);
            ps.setInt(2, creator_id);
            ps.setString(3, img);
            ps.setString(4, description);
            ps.setInt(5, status);

            int rowsAffected = ps.executeUpdate();
            if (rowsAffected > 0) {
                updated = true;
            }
        } catch (SQLException ex) {

        }
        return updated;
    }

    public List<DimensionDTO> getListDimensionDTO() {
        List<DimensionDTO> lst = new ArrayList<>();

        try {
            String query = "select * from Dimension";

            ps = connection.prepareStatement(query);

            rs = ps.executeQuery();

            while (rs.next()) {
                int id = rs.getInt(1);
                String name = rs.getString(2);

                DimensionDTO dimensionDTO = new DimensionDTO(id, name);
                lst.add(dimensionDTO);
            }
        } catch (SQLException ex) {
        }
        return lst;
    }

    public List<SubjectManagerDTO> getPaginationExpertManagerSubject(int userId, int page, int recordsPerPage) {
        List<SubjectManagerDTO> lst = new ArrayList<>();
        int start = (page - 1) * recordsPerPage + 1;
        int end = start + recordsPerPage - 1;

        try {
            String query = "WITH PagedResults AS (\n"
                    + "    SELECT \n"
                    + "        s.id, \n"
                    + "        s.name, \n"
                    + "        d.DimensionName, \n"
                    + "        COUNT(sl.lesson_id) as NumberLesson,\n"
                    + "        s.status,\n"
                    + "        ROW_NUMBER() OVER (ORDER BY s.creater_at) AS row_num\n"
                    + "    FROM \n"
                    + "        subjects s \n"
                    + "    LEFT JOIN \n"
                    + "        Dimension d ON s.dimensionId = d.DimensionId\n"
                    + "    LEFT JOIN \n"
                    + "        subject_has_lesson sl ON sl.subject_id = s.id\n"
                    + "    WHERE \n"
                    + "        s.creator_id = ?\n"
                    + "    GROUP BY \n"
                    + "        s.id, \n"
                    + "        s.name, \n"
                    + "        d.DimensionName, \n"
                    + "        s.status, \n"
                    + "        s.creater_at\n"
                    + ")\n"
                    + "SELECT * \n"
                    + "FROM PagedResults\n"
                    + "WHERE row_num BETWEEN ? AND ?\n"
                    + "ORDER BY row_num";

            ps = connection.prepareStatement(query);
            ps.setInt(1, userId); // Thay đổi UserId tương ứng
            ps.setInt(2, start);
            ps.setInt(3, end);
            rs = ps.executeQuery();

            while (rs.next()) {
                int id = rs.getInt(1);
                String name = rs.getString(2);
                String dimensionName = rs.getString(3);
                int numberOfLesson = rs.getInt(4);
                int status = rs.getInt(5);

                SubjectManagerDTO subjectManagerDTO = new SubjectManagerDTO(id, name, dimensionName, numberOfLesson, status);
                lst.add(subjectManagerDTO);
            }
        } catch (SQLException ex) {
        }
        return lst;
    }

    public int getTotalRecordsExpertManagerSubject(int userId) {
        String query = "SELECT COUNT(*) FROM subjects WHERE creator_id = ?";
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

    public int getTotalRecordsExpertManagerSubjectSearchBySubjectName(int userId, String subjectName) {
        String query = "SELECT COUNT(*) FROM subjects WHERE creator_id = ? and name like ?";
        try {
            ps = connection.prepareStatement(query);
            ps.setInt(1, userId);
            ps.setString(2, "%" + subjectName + "%");
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

    public int getTotalRecordsExpertManagerSubjectSearchByDimensionId(int userId, int dimensionId) {
        String query = "SELECT COUNT(*) FROM subjects WHERE creator_id = ? and dimensionId = ?";
        try {
            ps = connection.prepareStatement(query);
            ps.setInt(1, userId);
            ps.setInt(2, dimensionId);
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

    public int getTotalRecordsExpertManagerSubjectSearchByStatus(int userId, int status) {
        String query = "SELECT COUNT(*) FROM subjects WHERE creator_id = ? and status = ?";
        try {
            ps = connection.prepareStatement(query);
            ps.setInt(1, userId);
            ps.setInt(2, status);
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

    public List<SubjectManagerDTO> getPaginationExpertManagerSubjectSearchBySubjectName(int userId, int page, int recordsPerPage, String searchName) {
        List<SubjectManagerDTO> lst = new ArrayList<>();
        int start = (page - 1) * recordsPerPage + 1;
        int end = start + recordsPerPage - 1;

        try {
            String query = "WITH PagedResults AS (\n"
                    + "    SELECT \n"
                    + "        s.id, \n"
                    + "        s.name, \n"
                    + "        d.DimensionName, \n"
                    + "        COUNT(sl.lesson_id) as NumberLesson,\n"
                    + "        s.status,\n"
                    + "        ROW_NUMBER() OVER (ORDER BY s.creater_at) AS row_num\n"
                    + "    FROM \n"
                    + "        subjects s \n"
                    + "    LEFT JOIN \n"
                    + "        Dimension d ON s.dimensionId = d.DimensionId\n"
                    + "    LEFT JOIN \n"
                    + "        subject_has_lesson sl ON sl.subject_id = s.id\n"
                    + "    WHERE \n"
                    + "        s.creator_id = ? and s.name like ? \n"
                    + "    GROUP BY \n"
                    + "        s.id, \n"
                    + "        s.name, \n"
                    + "        d.DimensionName, \n"
                    + "        s.status, \n"
                    + "        s.creater_at\n"
                    + ")\n"
                    + "SELECT * \n"
                    + "FROM PagedResults\n"
                    + "WHERE row_num BETWEEN ? AND ?\n"
                    + "ORDER BY row_num";

            ps = connection.prepareStatement(query);
            ps.setInt(1, userId); // Thay đổi UserId tương ứng
            ps.setString(2, "%" + searchName + "%");
            ps.setInt(3, start);
            ps.setInt(4, end);
            rs = ps.executeQuery();

            while (rs.next()) {
                int id = rs.getInt(1);
                String name = rs.getString(2);
                String dimensionName = rs.getString(3);
                int numberOfLesson = rs.getInt(4);
                int status = rs.getInt(5);

                SubjectManagerDTO subjectManagerDTO = new SubjectManagerDTO(id, name, dimensionName, numberOfLesson, status);
                lst.add(subjectManagerDTO);
            }
        } catch (SQLException ex) {
        }
        return lst;
    }

    public List<SubjectManagerDTO> getPaginationExpertManagerSubjectSearchByDimensionId(int userId, int page, int recordsPerPage, int dimensionId) {
        List<SubjectManagerDTO> lst = new ArrayList<>();
        int start = (page - 1) * recordsPerPage + 1;
        int end = start + recordsPerPage - 1;

        try {
            String query = "WITH PagedResults AS (\n"
                    + "    SELECT \n"
                    + "        s.id, \n"
                    + "        s.name, \n"
                    + "        d.DimensionName, \n"
                    + "        COUNT(sl.lesson_id) as NumberLesson,\n"
                    + "        s.status,\n"
                    + "        ROW_NUMBER() OVER (ORDER BY s.creater_at) AS row_num\n"
                    + "    FROM \n"
                    + "        subjects s \n"
                    + "    LEFT JOIN \n"
                    + "        Dimension d ON s.dimensionId = d.DimensionId\n"
                    + "    LEFT JOIN \n"
                    + "        subject_has_lesson sl ON sl.subject_id = s.id\n"
                    + "    WHERE \n"
                    + "        s.creator_id = ? and s.dimensionId = ? \n"
                    + "    GROUP BY \n"
                    + "        s.id, \n"
                    + "        s.name, \n"
                    + "        d.DimensionName, \n"
                    + "        s.status, \n"
                    + "        s.creater_at\n"
                    + ")\n"
                    + "SELECT * \n"
                    + "FROM PagedResults\n"
                    + "WHERE row_num BETWEEN ? AND ?\n"
                    + "ORDER BY row_num";

            ps = connection.prepareStatement(query);
            ps.setInt(1, userId); // Thay đổi UserId tương ứng
            ps.setInt(2, dimensionId);
            ps.setInt(3, start);
            ps.setInt(4, end);
            rs = ps.executeQuery();

            while (rs.next()) {
                int id = rs.getInt(1);
                String name = rs.getString(2);
                String dimensionName = rs.getString(3);
                int numberOfLesson = rs.getInt(4);
                int status = rs.getInt(5);

                SubjectManagerDTO subjectManagerDTO = new SubjectManagerDTO(id, name, dimensionName, numberOfLesson, status);
                lst.add(subjectManagerDTO);
            }
        } catch (SQLException ex) {
        }
        return lst;
    }

    public List<SubjectManagerDTO> getPaginationExpertManagerSubjectSearchByStatus(int userId, int page, int recordsPerPage, int statusInput) {
        List<SubjectManagerDTO> lst = new ArrayList<>();
        int start = (page - 1) * recordsPerPage + 1;
        int end = start + recordsPerPage - 1;

        try {
            String query = "WITH PagedResults AS (\n"
                    + "    SELECT \n"
                    + "        s.id, \n"
                    + "        s.name, \n"
                    + "        d.DimensionName, \n"
                    + "        COUNT(sl.lesson_id) as NumberLesson,\n"
                    + "        s.status,\n"
                    + "        ROW_NUMBER() OVER (ORDER BY s.creater_at) AS row_num\n"
                    + "    FROM \n"
                    + "        subjects s \n"
                    + "    LEFT JOIN \n"
                    + "        Dimension d ON s.dimensionId = d.DimensionId\n"
                    + "    LEFT JOIN \n"
                    + "        subject_has_lesson sl ON sl.subject_id = s.id\n"
                    + "    WHERE \n"
                    + "        s.creator_id = ? and s.status = ? \n"
                    + "    GROUP BY \n"
                    + "        s.id, \n"
                    + "        s.name, \n"
                    + "        d.DimensionName, \n"
                    + "        s.status, \n"
                    + "        s.creater_at\n"
                    + ")\n"
                    + "SELECT * \n"
                    + "FROM PagedResults\n"
                    + "WHERE row_num BETWEEN ? AND ?\n"
                    + "ORDER BY row_num";

            ps = connection.prepareStatement(query);
            ps.setInt(1, userId); // Thay đổi UserId tương ứng
            ps.setInt(2, statusInput);
            ps.setInt(3, start);
            ps.setInt(4, end);
            rs = ps.executeQuery();

            while (rs.next()) {
                int id = rs.getInt(1);
                String name = rs.getString(2);
                String dimensionName = rs.getString(3);
                int numberOfLesson = rs.getInt(4);
                int status = rs.getInt(5);

                SubjectManagerDTO subjectManagerDTO = new SubjectManagerDTO(id, name, dimensionName, numberOfLesson, status);
                lst.add(subjectManagerDTO);
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
        //System.out.println(c.getPaginationExpertManagerSubjectSearchBySubjectName(1028, 1, 5, "P"));
        //System.out.println(c.getSubjectById(2));
        System.out.println(c.getListSubjectPackagePriceDTO(2));

    }
}
