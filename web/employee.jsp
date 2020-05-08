<%@page import="entity.Employee"%>
<%@page import="util.HtmlHelper"%>
<%@page import="entity.Product"%>
<%@page import="java.util.ArrayList"%>
<!DOCTYPE html>
<%@page contentType="text/html" pageEncoding="UTF-8"%> 
<html lang="en">
    <head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

        <title>NHÂN VIÊN</title>

        <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
            <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/boot">
            < script src = "js/jquery-3.4.1.min.js" ></script>
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
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.0/css/bootstrap.min.css" integrity="sha384-9gVQ4dYFwwWSjIDZnLEWnxCjeSWFphJiwGPXr1jddIhOegiu1FwO5qRGvFXOdJZ4" crossorigin="anonymous">
        <!-- Our Custom CSS -->
        <link rel="stylesheet" href="css/style1.css">

        <!-- Font Awesome JS -->
        <script defer src="https://use.fontawesome.com/releases/v5.0.13/js/solid.js" integrity="sha384-tzzSw1/Vo+0N5UhStP3bvwWPq+uvzCMfrN1fEFe+xBmv1C/AtVX5K0uZtmcHitFZ" crossorigin="anonymous"></script>
        <script defer src="https://use.fontawesome.com/releases/v5.0.13/js/fontawesome.js" integrity="sha384-6OIrr52G08NpOFSZdxxz1xdNSndlD4vdcf/q2myIUVO0VsqaGHJsB0RaBE01VTOY" crossorigin="anonymous"></script>

        <!-- 	<link href="//netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap.min.css" rel="stylesheet"  id="bootstrap-css">
        <script src="//netdna.bootstrapcdn.com/bootstrap/3.0.0/js/bootstrap.min.js"></script>
        <script src="//code.jquery.com/jquery-1.11.1.min.js"></script> -->
        <%
            ArrayList<Employee> employees
                    = (ArrayList<Employee>) session.getAttribute("Employee");
                        //  Order order = (Order) session.getAttribute("cart");
            // int quantity = order!=null?order.getLines().size():0;
            Integer pageindex = (Integer) request.getAttribute("pageindex");
            Integer pagecount = (Integer) request.getAttribute("pagecount");
        %>
    </style>
</head>


<div class="wrapper">
    <!-- Sidebar  -->
    <nav id="sidebar">
        <div class="sidebar-header">

            <a class="navbar-brand" style="color: #faf7fd;"><span class="badge badge-light" data-toggle="tooltip" data-spy="scroll" data-target="#my-menu" id="album" style="color: #0099FF; font-size: 1.2rem">Điện Máy Mạnh Kiên</span></a>

        </div>

        <ul class="list-unstyled components">
            <p></p>

            <li>
                <a href="product">HÀNG HÓA</a>
            </li>

            <li>
                <a href="shoppingCart">HÓA ĐƠN BÁN</a>
            </li>

            <li>
                <a href="import">HÓA ĐƠN NHẬP</a>
            </li>
            <li>
                <a href="partner">NHÀ CUNG CẤP</a>
            </li>
            <li>
                <a href="customer">KHÁCH HÀNG</a>
            </li>
            <li>
                <a href="employee">NHÂN VIÊN</a>
            </li>
            <li>
                <a href="statistical">THỐNG KÊ</a>
            </li>
        </ul>
    </nav>

    <!-- Page Content  -->
    <div id="content">

        <nav class="navbar navbar-expand-lg navbar-light bg-light">
            <div class="container-fluid">

                <button type="button" id="sidebarCollapse" class="btn btn-info">
                    <i class="fas fa-align-left"></i>
                    <span>DANH MỤC</span>
                </button>
                <a href="#"><b>NHÂN VIÊN</b></a>
                <a href="logout">ĐĂNG XUẤT</a>
                <button class="btn btn-dark d-inline-block d-lg-none ml-auto" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
                    <i class="fas fa-align-justify"></i>
                </button>
            </div>
        </nav>

        <div class="container-fluid">
            <table class="table">
                <thead class="thead-dark">
                    <tr>
                        <th scope="col">MÃ NHÂN VIÊN</th>
                        <th scope="col">TÊN NHÂN VIÊN</th>
                        <th scope="col">NGÀY SINH</th>
                        <th scope="col">GIỚI TÍNH</th>
                        <th scope="col">ĐỊA CHỈ</th>
                    </tr>
                </thead>
                <% for (Employee p : employees) {
                %>
                <tr>
                    <td><%=p.getIdNhanVien()%></td>
                    <td><%=p.getNameNhanVien()%></td>
                    <td><%=p.getNgaySinh()%></td>
                    <td><%=p.getGioiTinh()%></td>
                    <td><%=p.getDiaChi()%></td>
                </tr>
                <%}%>
            </table>
        </div>
    </div>
</div>
</div>

<!-- jQuery CDN - Slim version (=without AJAX) -->
<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
<!-- Popper.JS -->
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.0/umd/popper.min.js" integrity="sha384-cs/chFZiN24E4KMATLdqdvsezGxaGsi4hLGOzlXwp5UZB1LY//20VyM2taTB4QvJ" crossorigin="anonymous"></script>
<!-- Bootstrap JS -->
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.0/js/bootstrap.min.js" integrity="sha384-uefMccjFJAIv6A+rW+L4AHf99KvxDjWSu1z9VI8SKNVmz4sk7buKt/6v9KI65qnm" crossorigin="anonymous"></script>

<script type="text/javascript">
        $(document).ready(function () {
            $('#sidebarCollapse').on('click', function () {
                $('#sidebar').toggleClass('active');
            });
        });
</script>

</body>
</html>