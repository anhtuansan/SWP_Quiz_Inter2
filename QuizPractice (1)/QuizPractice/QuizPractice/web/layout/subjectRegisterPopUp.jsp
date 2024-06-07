<%@page contentType="text/html" pageEncoding="UTF-8"%>
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
            <h4 class="modal-title text-center">MLN111</h5>
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>
        </div>
        <div class="modal-body">
            <form id="registerSubjectForm">
                <div class="form-check">
                    <input class="form-check-input" type="checkbox" id="subject1" name="subject1">
                    <label class="form-check-label" for="subject1">Gói 3 tháng - 3 tháng - 800$</label>
                </div>
                <div class="form-check">
                    <input class="form-check-input" type="checkbox" id="subject2" name="subject2">
                    <label class="form-check-label" for="subject2">Gói 6 tháng - 6 tháng - 1400$</label>
                </div>
                <div class="form-check">
                    <input class="form-check-input" type="checkbox" id="subject3" name="subject3">
                    <label class="form-check-label" for="subject3">Gói vô hạn - 12 tháng - 1800$</label>
                </div>
                <hr/>

                <h4 class="modal-title text-center">User Information</h4>
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
                        <option value="" disabled selected>Select your gender</option>
                        <option value="male">Male</option>
                        <option value="female">Female</option>
                        <option value="other">Other</option>
                    </select>
                </div>

                <div class="modal-footer">

                    <button type="submit" class="btn btn-primary">Đăng kí</button>

                </div>
            </form>
        </div>

        <!-- Bootstrap JS and jQuery -->
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
    </body>
</html>
