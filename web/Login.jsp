<%-- 
    Document   : Login
    Created on : Oct 12, 2019, 5:40:07 PM
    Author     : asus
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

        <title>Đăng nhập</title>
        <!-- Optional JavaScript -->
        <!-- jQuery first, then Popper.js, then Bootstrap JS -->
        <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/boot">
        <script src="js/jquery-3.4.1.min.js"></script>
        <script src="js/popper.min.js"></script>
        <script src="js/bootstrap.min.js"></script>
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">

        <link rel="stylesheet" href="owl.carousel.min.css">
        <link rel="stylesheet" href="owl.theme.default.css">


        <script src="owl.carousel.js"></script>
        <script src="owl.carousel.min.js"></script>
        <!-- Bootstrap CSS -->

        <link rel="stylesheet" type="text/css" href="css/bootstrap.min.css">
        <link rel="stylesheet" type="text/css" href="css/bootstrap.css">

        <style>
            #footer {
                position:relative;
                bottom:0;
                width:100%;
                height:100px;   /* Height of the footer */

            }
        </style>
    </head>
    <body>

        <nav class="navbar navbar-expand-lg navbar-light" style="background-color: #0099FF">
            <div class="container">					
                <a class="navbar-brand" style="color: #faf7fd; margin-left: -100px"><span class="badge badge-light" data-toggle="tooltip" data-spy="scroll" data-target="#my-menu" id="album" style="color: #0099FF; font-size: 1.2rem">Điện Máy Mạnh Kiên</span></a>
                <div class="collapse navbar-collapse" id="navbarSupportedContent">
                    <ul class="navbar-nav mr-auto">
                        <li class="nav-item">
                            <a class="nav-link" href="Login.jsp" style="color: #faf7fd; font-size: 1.1rem">Trang chủ</a>
                        </li>	
                    </ul>	

                    <a href="Login.jsp" class="btn btn-outline-light">Đăng nhập</a>
                    <a href="Login.jsp" class="btn btn-outline-light" style="margin-left: 10px">Đăng ký</a>

                </div>
            </div>		
        </nav>


        <!-- login -->

        <div class="container" align="center">

            <form action="Login" method="POST">
                <div class="form-group">
                    <label><b>Tài Khoản:</b></label>
                    <input type="text" class="form-control" id="email" placeholder="Nhập tài khoản" name="taikhoan">
                </div>
                <div class="form-group">
                    <label for="pwd"><b>Mật Khẩu:</b></label>
                    <input type="password" class="form-control" id="pwd" placeholder="Nhập mật khẩu" name="matkhau">
                </div>
                <div class="form-group form-check">
                    <label class="form-check-label">
                        <input class="form-check-input" type="checkbox" name="remember"> Remember me
                    </label>
                </div>
                <button type="submit" class="btn btn-primary">ĐĂNG NHẬP</button>
            </form>
        </div>

</body>
</html>