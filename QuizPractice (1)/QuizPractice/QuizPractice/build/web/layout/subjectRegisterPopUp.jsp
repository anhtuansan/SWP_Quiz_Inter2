<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<% String contextPath = request.getContextPath(); %>
<%@ page import="model.PricePackage2" %>
<%@ page import="java.util.List" %>
<% List<PricePackage2> listPricePackage = (List<PricePackage2>) request.getAttribute("listPricePackage"); %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Register Subject Popup</title>
    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
</head>
<body>
    <div class="modal-header">
        <h4 class="modal-title text-center">${subjectName}</h4>
        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
            <span aria-hidden="true">&times;</span>
        </button>
    </div>
    <div class="modal-body">
        <form id="registerSubjectForm" action="subjectRegister" method="POST">
            <div class="form-group">
                <label>Chọn gói giá</label>
                <div>
                    <c:forEach var="pkg" items="${listPricePackage}">
                        <div class="radio">
                            <label>
                                <input type="radio" name="pricePackageId" value="${pkg.id}" required>
                                ${pkg.name} - ${pkg.duration} month - ${pkg.price} VND
                            </label>
                        </div>
                    </c:forEach>
                </div>
            </div>
            <hr/>

            <c:if test="${sessionScope.user == null}">
                <h4 class="modal-title text-center">Thông tin người dùng</h4>
                <!-- Error Message -->
                <c:if test="${not empty errorMessage}">
                    <div class="alert alert-danger">${errorMessage}</div>
                </c:if>

                <div class="form-group">
                    <input type="text" class="form-control" id="userName" name="userName" placeholder="Nhập tên người dùng" required>
                </div>
                <div class="form-group">
                    <input type="email" class="form-control" id="email" name="email" placeholder="Nhập địa chỉ email của bạn" required>
                </div>
                <div class="form-group">
                    <input type="text" class="form-control" id="phoneNumber" name="phoneNumber" placeholder="Nhập số điện thoại" required>
                </div>
                <div class="form-group">
                    <select class="form-control" id="gender" name="gender" required>
                        <option value="" disabled selected>Chọn giới tính</option>
                        <option value="male">Nam</option>
                        <option value="female">Nữ</option>
                        <option value="other">Khác</option>
                    </select>
                </div>
            </c:if>
            
                    <input type="text" name="subjectId" value="${subjectId}"  style="display: none">
            <div class="modal-footer">
                <button type="submit" class="btn btn-primary">Đăng ký</button>
            </div>
        </form>
    </div>

    <!-- Bootstrap JS and jQuery -->
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
</body>
</html>
