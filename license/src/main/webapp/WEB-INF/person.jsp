<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="Colorlib Templates">
    <meta name="author" content="Colorlib">
    <meta name="keywords" content="Colorlib Templates">
<title>Insert title here</title>
<link href="https://fonts.googleapis.com/css?family=Open+Sans:300,300i,400,400i,600,600i,700,700i,800,800i" rel="stylesheet">

    <!-- Main CSS-->
    
    <link rel="stylesheet" type="text/css" href="css/style.css" media="all">
   
</head>
<body>
 <div class="page-wrapper bg-dark p-t-100 p-b-50">
        <div class="wrapper wrapper--w900">
            <div class="card card-6">
                <div class="card-heading">
                    <h2 class="title">New Person</h2>
                </div>
                <div class="card-body">
                    <form action="/createperson" method="post">
                        <div class="form-row">
                            <div class="name">First Name</div>
                            <div class="value">
                                <input class="input--style-6" type="text" name="firstName">
                            </div>
                        </div>
                        <div class="form-row">
                            <div class="name">Last Name</div>
                            <div class="value">
                                <div class="input-group">
                                    <input class="input--style-6" type="text" name="lastName" >
                                </div>
                            </div>
                            <div class="card-footer">
                    <button class="btn btn--radius-2 btn--blue-2" type="submit">Create</button>
                </div>
                        </div>
                        
                    
                    </form>
                </div>
                
            </div>
        </div>
    </div>

    <!-- Jquery JS-->
    <script src="vendor/jquery/jquery.min.js"></script>


    <!-- Main JS-->
    <script src="js/global.js"></script>
</body>
</html>