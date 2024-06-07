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
            <h1 class="heading text-center">New Practice</h1>
            
            <div class="container">
                <form>
                    <div class="form-group">
                        <label for="subject">Subject:</label>
                        <select id="subject" class="form-control">
                            <option selected disabled>Choose Subject</option>
                            <option value="math">Math</option>
                            <option value="science">Science</option>
                            <option value="history">History</option>
                            <option value="geography">Geography</option>
                            <option value="physics">Physics</option>
                        </select>
                    </div>
                    
                    <div class="form-group">
                        <label for="questions">Number of Questions:</label>
                        <input type="number" id="questions" class="form-control" placeholder="Enter number of questions">
                    </div>
                    
                  
                    <div class="form-group">
                        <label for="topic">Topic:</label>
                        <select id="topic" class="form-control">
                            <option selected disabled>Choose lesson:</option>
                            <option value="all">All</option>
                            <option value="math">Math</option>
                            <option value="science">Science</option>
                            <option value="history">History</option>
                            <option value="geography">Geography</option>
                            <option value="physics">Physics</option>
                        </select>
                    </div>
                    
                    <div class="form-group">
                        <label for="duration">Duration:</label>
                        <select id="duration" class="form-control">
                            <option selected disabled>Choose Duration</option>
                            <option value="15">15 minutes</option>
                            <option value="30">30 minutes</option>
                            <option value="45">45 minutes</option>
                            <option value="60">1 hour</option>
                            <option value="90">1 hour 30 minutes</option>
                            <option value="120">2 hours</option>
                        </select>
                    </div>
                    
                    <button type="submit" class="btn btn-primary">Start Practice</button>
                </form>
            </div>
        </section>
        <br/>

        <%@include file="/layout/footer.jsp" %>
        
        <!-- side bar có thể thu nhỏ khi màn hình nhỏ  -->
        <script src="js/script.js"></script>
    </body>
</html>
