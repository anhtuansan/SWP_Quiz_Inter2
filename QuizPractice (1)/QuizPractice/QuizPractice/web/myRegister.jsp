<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>My Registertration</title>

        <!-- font awesome cdn link  -->
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.1.2/css/all.min.css">

        <!-- custom css file link  -->
        <link rel="stylesheet" href="css/style.css">
        <link rel="stylesheet" href="css/popup.css">
        <link rel="stylesheet" href="css/myRegister.css">
        <!-- Bootstrap file link  -->
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
        
        
         <!-- Custom CSS to make the footer fixed -->
        <style>
             .footer {
                background: #f8f9fa;
                /*padding: 20px;*/
                text-align: center;
                position: fixed;
                bottom: 0;
                width: 100%;
                height: 15%;
                padding-right: 12%;
                /*margin-top:-5%;*/
                /*padding-top: -5%;*/
                padding-top: -110px;
            }
/*             section{
                margin-bottom:  -25%;
            }
            */
/*              section{
                margin-bottom: 100px;  
            }*/

            
           
        </style>
    </head>

    <body>
        <%@include file="/layout/header.jsp"%>
        <%@include file="/layout/searchMyRegister.jsp"%>

        <section class="my-register">
            <h1 class="heading" class="text-center">Khóa học đã đăng ký</h1>
            <div class="container">
                <table class="table table-bordered table-hover">
                    <thead>
                        <tr>
                            <th>Id</th>
                            <th>Subject</th>
                            <th>Register Time</th>
                            <th>Package</th>
                            <th>Total Cost</th>
                            <th>Status</th>
                            <th>Action</th>
                        </tr>
                    </thead>
                    <tbody>
                        <tr>
                            <td>1</td>
                            <td>Math</td>
                            <td>2023-01-15</td>
                            <td>3 months</td>
                            <td>$800</td>
                            <td>Active</td>
                            <td><a href="#"><i class="fas fa-trash-alt text-danger"></i></a></td>
                        </tr>
                        <tr>
                            <td>2</td>
                            <td>Science</td>
                            <td>2023-02-20</td>
                            <td>6 months</td>
                            <td>$1400</td>
                            <td>Active</td>
                            <td><a href="#"><i class="fas fa-trash-alt text-danger"></i></a></td>
                        </tr>
                        <tr>
                            <td>3</td>
                            <td>History</td>
                            <td>2023-03-05</td>
                            <td>1 year</td>
                            <td>$1800</td>
                            <td>Inactive</td>
                            <td><a href="#"><i class="fas fa-trash-alt text-danger"></i></a></td>
                        </tr>
                        <tr>
                            <td>4</td>
                            <td>Geography</td>
                            <td>2023-04-10</td>
                            <td>3 months</td>
                            <td>$800</td>
                            <td>Active</td>
                            <td><a href="#"><i class="fas fa-trash-alt text-danger"></i></a></td>
                        </tr>
                        <tr>
                            <td>5</td>
                            <td>Physics</td>
                            <td>2023-05-15</td>
                            <td>6 months</td>
                            <td>$1400</td>
                            <td>Inactive</td>
                            <td><a href="#"><i class="fas fa-trash-alt text-danger"></i></a></td>
                        </tr>
                    </tbody>
                </table>
                
                
                 <!-- Pagination -->
                <nav aria-label="Page navigation">
                    <ul class="pagination">
                        <li>
                            <a href="#" aria-label="Previous">
                                <span aria-hidden="true">&laquo;</span>
                            </a>
                        </li>
                        <li class="active"><a href="#">1</a></li>
                        <li><a href="#">2</a></li>
                        <li><a href="#">3</a></li>
                        <li><a href="#">4</a></li>
                        <li><a href="#">5</a></li>
                        <li>
                            <a href="#" aria-label="Next">
                                <span aria-hidden="true">&raquo;</span>
                            </a>
                        </li>
                    </ul>
                </nav>
                
                
                
            </div>
        </section>
        <br/>

        <%@include file="/layout/footer.jsp" %>
    </body>
</html>
