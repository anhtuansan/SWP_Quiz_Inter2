<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset='utf-8'>
        <meta name='viewport' content='width=device-width, initial-scale=1'>
        <title>Forget Pasword</title>
        <link
            href='https://stackpath.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css'
            rel='stylesheet'>
        <link href='' rel='stylesheet'>
        <!-- font awesome cdn link  -->
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.1.2/css/all.min.css">

        <!-- custom css file link  -->
        <link rel="stylesheet" href="css/style.css">
        <script type='text/javascript'
        src='https://cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js'></script>

        <style>
            body {
                background-position: center;
                background-color: #eee;
                background-repeat: no-repeat;
                background-size: cover;
                color: #505050;
                font-family: "Rubik", Helvetica, Arial, sans-serif;
                font-size: 14px;
                font-weight: normal;
                line-height: 1.5;
                text-transform: none
            }

            .forgot {
                background-color: #fff;
                padding: 12px;
                border: 1px solid #dfdfdf
            }

            .padding-bottom-3x {
                padding-bottom: 72px !important
            }

            .card-footer {
                background-color: #fff
            }

            .btn {
                font-size: 13px
            }

            .form-control:focus {
                color: #495057;
                background-color: #fff;
                border-color: #76b7e9;
                outline: 0;
                box-shadow: 0 0 0 0px #28a745
            }
        </style>

    <body oncontextmenu='return false' class='snippet-body'>
        <!-- header -->
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
        <div class="container padding-bottom-3x mb-2 mt-5">
            <div class="row justify-content-center">
                <div class="col-lg-8 col-md-10">
                    <div class="forgot">
                        <h2>Forgot your password?</h2>
                        <p>Change your password in three easy steps. This will help you
                            to secure your password!</p>
                        <ol class="list-unstyled">
                            <li><span class="text-primary text-medium">1. </span>Enter
                                your email address below.</li>
                            <li><span class="text-primary text-medium">2. </span>Our
                                system will send you an via link to your email</li>
                            <li><span class="text-primary text-medium">3. </span>Go 
                                to your email and click on the via link to reset password </li>
                        </ol>
                    </div>
                    <form class="card mt-4" action="reset-password" method="POST">
                        <div class="card-body">
                            <div class="form-group">
                                <label for="email-for-pass">Enter your email address</label> <input
                                    class="form-control" type="text" name="email" id="email-for-pass" required=""><small
                                    class="form-text text-muted">Enter the registered email address . Then we'll
                                    email a via link to this address.</small>
                                    <%
                                    if(request.getAttribute("message")!=null){
                                        out.print("<p class='text-danger ml-1'>"+request.getAttribute("message")+"</p>");
                                    }
		  
                                    %>
                            </div>
                        </div>
                        <div >
                            <button class="option-btn" type="submit">Get New
                                Password</button>
                        </div>
                    </form>
                </div>
            </div>
                            <div> .</div>
                             <div> .</div>
                             <div> .</div> 


                                
        </div>
        <script type='text/javascript'
        src='https://stackpath.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.bundle.min.js'></script>
        <script type='text/javascript' src=''></script>
        <script type='text/javascript' src=''></script>
        <script type='text/Javascript'></script>
    </body>
    <%@include file="layout/footer.jsp" %>
    <script src="js/script.js"></script>
</html>
