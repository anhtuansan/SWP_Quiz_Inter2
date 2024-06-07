<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>App</title>

        <!-- font awesome cdn link  -->
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.1.2/css/all.min.css">

        <!-- custom css file link  -->
        <link rel="stylesheet" href="css/style.css">
        <link rel="stylesheet" href="css/popup.css">

        <!-- Bootstrap file link  -->
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
        
        <!-- Custom CSS to make the footer fixed -->
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
                height: 15%;
            }
            #topTable {
                margin-bottom: 0.5%;
            }
            .practiceList {
                margin-bottom: 10%;
            }
            nav {
                margin-top: -25px;
            }
        </style>
    </head>

    <body>
        <%@include file="/layout/header.jsp"%>
        
        <section class="practiceList">
            <h1 class="heading text-center">Practice List</h1>
            
            <div id="topTable" class="container">
                <div class="row">
                    <div class="col-md-3">
                        <select class="form-control">
                            <option selected disabled>Choose Subject</option>
                            <option value="math">Math</option>
                            <option value="science">Science</option>
                            <option value="history">History</option>
                            <option value="geography">Geography</option>
                            <option value="physics">Physics</option>
                        </select>
                    </div>
                    <div class="col-md-5"></div>
                    <div class="col-md-2">
                        <button class="btn btn-primary">New Practice</button>
                    </div>
                    <div class="col-md-2">
                        <button class="btn btn-primary">Simulation Exam</button>
                    </div>
                </div>
            </div>
            
            <div class="container">
                <table class="table table-bordered table-hover">
                    <thead>
                        <tr>
                            <th>Subject Name</th>
                            <th>Date Taken</th>
                            <th>Question</th>
                            <th>Correct (%)</th>
                            <th>Duration</th>
                            <th>Action</th>
                        </tr>
                    </thead>
                    <tbody>
                        <tr>
                            <td>Math</td>
                            <td>2023-01-15</td>
                            <td>50</td>
                            <td>90%</td>
                            <td>01:30:00</td>
                            <td><a href="#">View Detail</a></td>
                        </tr>
                        <tr>
                            <td>Science</td>
                            <td>2023-02-20</td>
                            <td>60</td>
                            <td>83%</td>
                            <td>02:00:00</td>
                            <td><a href="#">View Detail</a></td>
                        </tr>
                        <tr>
                            <td>History</td>
                            <td>2023-03-05</td>
                            <td>40</td>
                            <td>88%</td>
                            <td>01:20:00</td>
                            <td><a href="#">View Detail</a></td>
                        </tr>
                        <tr>
                            <td>Geography</td>
                            <td>2023-04-10</td>
                            <td>30</td>
                            <td>93%</td>
                            <td>01:00:00</td>
                            <td><a href="#">View Detail</a></td>
                        </tr>
                        <tr>
                            <td>Physics</td>
                            <td>2023-05-15</td>
                            <td>70</td>
                            <td>93%</td>
                            <td>02:30:00</td>
                            <td><a href="#">View Detail</a></td>
                        </tr>
                        <tr>
                            <td>Geography</td>
                            <td>2023-04-10</td>
                            <td>30</td>
                            <td>93%</td>
                            <td>01:00:00</td>
                            <td><a href="#">View Detail</a></td>
                        </tr>
                        <tr>
                            <td>Physics</td>
                            <td>2023-05-15</td>
                            <td>70</td>
                            <td>93%</td>
                            <td>02:30:00</td>
                            <td><a href="#">View Detail</a></td>
                        </tr>
                        <tr>
                            <td>Geography</td>
                            <td>2023-04-10</td>
                            <td>30</td>
                            <td>93%</td>
                            <td>01:00:00</td>
                            <td><a href="#">View Detail</a></td>
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
        
        <!-- side bar có thể thu nhỏ khi màn hình nhỏ  -->
        <script src="js/script.js"></script>
    </body>
</html>
