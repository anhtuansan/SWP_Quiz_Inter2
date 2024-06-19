<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Subject Manager</title>

        <!-- font awesome cdn link  -->
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.1.2/css/all.min.css">

        <!-- custom css file link  -->
        <link rel="stylesheet" href="css/style.css">
        <link rel="stylesheet" href="css/popup.css">

        <!-- Bootstrap file link  -->
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>

        <style>
            body {
                padding: 0;
                margin: 0;
            }
            .footer {
                background: #f8f9fa;
                text-align: center;
                position: fixed;
                bottom: 0;
                width: 100%;
                height: 10%;
                z-index: 10; /* High z-index to overlay sidebar */
                padding-left: 2%;
            }
            .subjectList {
                margin-bottom: 50px;
            }
            .heading {
                text-align: center;
            }
            .status-active {
                color: green;
            }
            .status-inactive {
                color: red;
            }
            .search-form-container {
                margin-bottom: 20px;
            }
        </style>

        <script>
            $(document).ready(function () {
                // Update results on form submit
                $("#searchForm").submit(function (event) {
                    event.preventDefault(); // Prevent the default form submit
                    updateSubjects();
                });

                // Detect 'Enter' key press in search name input
                $('#searchName').keypress(function (event) {
                    var keycode = (event.keyCode ? event.keyCode : event.which);
                    if (keycode == '13') { // '13' is the key code for Enter
                        event.preventDefault(); // Prevent the default action
                        updateSubjects();
                    }
                });

                // Update results on select change
                $("#searchDimensionId, #searchStatus").change(function () {
                    updateSubjects();
                });
            });

            function updateSubjects(page = 1) {
                const name = $('#searchName').val();
                const dimensionId = $('#searchDimensionId').val();
                const status = $('#searchStatus').val();

                // Build URL
                const href = "subjectManager?searchName=" + name + "&searchDimensionId=" + dimensionId + "&searchStatus=" + status + "&page=" + page;
                window.location.href = href;  // Redirect user to URL
            }
        </script>

    </head>
    <body>
        <%@include file="/layout/header.jsp"%>

        <section class="subjectList">
            <div class="container">
                <h1 class="heading text-center">Subject List</h1>

                <!-- Search and add subject row -->
                <div class="row search-form-container">
                    <div class="col-md-4">
                        <input type="text" class="form-control" id="searchName" value="${searchName}" placeholder="Search by name" name="searchName" form="searchForm">
                    </div>
                    <div class="col-md-3">
                        <select class="form-control" id="searchDimensionId" name="searchDimensionId" form="searchForm">
                            <option value="">All Dimensions</option>
                            <c:forEach var="dimension" items="${dimensions}">
                                <option value="${dimension.id}" ${searchDimensionId == dimension.id ? 'selected' : ''}>${dimension.name}</option>
                            </c:forEach>
                        </select>
                    </div>
                    <div class="col-md-3">
                        <select class="form-control" id="searchStatus" name="searchStatus" form="searchForm">
                            <option value="">All Statuses</option>
                            <option value="1" ${searchStatus == '1' ? 'selected' : ''}>Active</option>
                            <option value="0" ${searchStatus == '0' ? 'selected' : ''}>Inactive</option>
                        </select>
                    </div>
                    <div class="col-md-2">
                        <a href="newSubject" class="btn btn-success">Add New Subject</a>
                    </div>
                </div>

                <!-- Form for searching -->
                <form id="searchForm" action="subjectManager" method="GET"></form>

                <!-- Subjects Table -->
                <table class="table table-bordered table-striped">
                    <thead>
                        <tr>
                            <th>Id</th>
                            <th>Name</th>
                            <th>Dimension</th>
                            <th>Number of Lessons</th>                         
                            <th>Status</th>
                            <th>Detail</th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach var="item" items="${listSubject}">
                            <tr>
                                <td>${item.id}</td>
                                <td>${item.name}</td>
                                <td>${item.dimensionName}</td>
                                <td>${item.numberOfLesson}</td>
                                <td>
                                    <c:choose>
                                        <c:when test="${item.status == 1}">
                                            <span class="status-active">Active</span>
                                        </c:when>
                                        <c:otherwise>
                                            <span class="status-inactive">Inactive</span>
                                        </c:otherwise>
                                    </c:choose>
                                </td>
                                <td><a href="subjectDetailExpert?id=${item.id}" class="btn btn-info btn-sm">Detail</a></td>
                            </tr>
                        </c:forEach>
                    </tbody>
                </table>

                <!-- Pagination -->
                <nav aria-label="Page navigation">
                    <ul class="pagination">
                        <c:if test="${currentPage > 1}">
                            <li>
                                <a href="javascript:updateSubjects(${currentPage - 1});" aria-label="Previous">
                                    <span aria-hidden="true">&laquo;</span>
                                </a>
                            </li>
                        </c:if>

                        <c:forEach begin="1" end="${totalPages}" var="i">
                            <li class="${currentPage == i ? 'active' : ''}">
                                <a href="javascript:updateSubjects(${i});">${i}</a>
                            </li>
                        </c:forEach>

                        <c:if test="${currentPage < totalPages}">
                            <li>
                                <a href="javascript:updateSubjects(${currentPage + 1});" aria-label="Next">
                                    <span aria-hidden="true">&raquo;</span>
                                </a>
                            </li>
                        </c:if>
                    </ul>
                </nav>
            </div>
        </section>

        <%@include file="/layout/footer.jsp"%>
    </body>
</html>
