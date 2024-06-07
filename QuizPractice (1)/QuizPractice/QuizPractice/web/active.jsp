<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
    <head>
        <link href="//maxcdn.bootstrapcdn.com/bootstrap/3.3.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
        <script src="//maxcdn.bootstrapcdn.com/bootstrap/3.3.0/js/bootstrap.min.js"></script>
        <script src="//code.jquery.com/jquery-1.11.1.min.js"></script>
        <!------ Include the above in your HEAD tag ---------->

        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.5.0/css/font-awesome.min.css">
        <!-- font awesome cdn link  -->
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.1.2/css/all.min.css">

        <!-- custom css file link  -->
        <link rel="stylesheet" href="css/style.css">
        <style type="text/css">
            .form-gap {
                padding-top: 70px;
            }
            .fa-check-circle {
                color: green;
            }
        </style>
    </head>

    <body>
        <header class="header">

            <section class="flex">
                <a href="<%=request.getContextPath()%>/home" class="logo">Educa.</a>

                <div class="icons">
                    <div id="menu-btn" class="fas fa-bars"></div>
                    <div id="search-btn" class="fas fa-search"></div>
                    <div id="user-btn" class="fas fa-user"></div>
                    <div onclick="openRightSideBar()" id="right-side-btn" class="fas fa-sun"></div>
                </div>
                <div class="profile ">
                    <c:if test="${sessionScope.user != null}">
                        <img src="<%=request.getContextPath()%>/${sessionScope.user.profileImg}" class="image" alt="">
                        <h3 class="name">${user.fullName}</h3>
                        <p class="role">student</p>
                        <a onclick="openPopUp2()" class="option-btn">view profile</a>
                    </c:if>
                    <div class="flex-btn">
                        <c:if test="${sessionScope.user == null}">
                            <a onclick="openPopUp()" class="option-btn">login</a>
                            <a onclick="openPopUp1()" class="option-btn">register</a>
                        </c:if>
                        <c:if test="${sessionScope.user != null}">
                            <a onclick="logout()" class="option-btn">Log Out</a>
                        </c:if>
                    </div>
                </div>
            </section>
        </header>
        <%@include file="layout/sidebar.jsp" %>

        <div class="form-gap"></div>
        <div class="container">
            <div style="margin-bottom: 300px" class="row">
                <div class="col-md-4 col-md-offset-4">
                    <div class="panel panel-default">
                        <div class="panel-body">
                            <div class="text-center">
                                <h3>
                                    <i class="fa fa-check-circle fa-4x"></i>
                                </h3>
                                <h2 class="text-center">Please check your email to get via link!</h2>

                                <div class="panel-body">

                                    <form id="register-form" action="otp" role="form" autocomplete="off"
                                          class="form" method="post">
                                        <input type="hidden" class="hide" name="token" id="token" value="">
                                    </form>

                                    <!-- End of Gmail Button -->

                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <footer style="margin-top: -180px"class="footer">
            <section>
                <h2>Contact Us</h2>
                <p><strong>Follow Us:</strong></p>
                <ul>
                    <li><a id="facebook" href="#"><i class="fab fa-facebook"> </i> Facebook</a></li>
                    <li><a id="youtube" href="#"><i class="fab fa-youtube"> </i> YouTube</a></li>
                    <li><a id="tiktok" href="#"><i class="fab fa-tiktok"></i> TikTok</a></li>
                </ul>
            </section>
        </footer>
        <script src="js/script.js"></script>
    </body>
</html>