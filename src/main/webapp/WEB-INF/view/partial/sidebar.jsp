<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" integrity="sha384-JcKb8q3iqJ61gNV9KGb8thSsNjpSL0n8PARn9HuZOnIxN0hoP+VmmDGMN5t9UJ0Z" crossorigin="anonymous">
    <link rel="stylesheet" href="/resources/css/dashbord.css">
    <link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.11.2/css/all.css" rel="stylesheet" type="text/css" />
</head>
<body>

<c:if test="${pageContext.request.userPrincipal.name == 'dogukan@gmail.com' }">
    <nav class="col-md-2 d-none d-md-block sidebar bg-dark">
        <div class="sidebar-sticky bg-dark">
            <ul class="nav flex-column">

                <li class="nav-item text-white list-group-item list-group-item-action bg-dark" style="margin-top: -10px">
                   <h5 class="text-center mt-2">Müşteri İlişkileri Yönetimi</h5>

                </li>


                <li class="nav-item  ">
                    <a class="nav-link text-white list-group-item list-group-item-action bg-dark" href="/">
                        <i class="fa fa-home"></i>
                        Anasayfa
                    </a>
                </li>

                <li class="nav-item">
                    <a class="nav-link text-white list-group-item list-group-item-action bg-dark" href="/user/customers">
                        <i class="fa fa-handshake"></i>
                       Müşteriler
                    </a>
                </li>
                <li class="nav-item">
                    <a class="nav-link text-white list-group-item list-group-item-action bg-dark" href="/product/products">
                        <i class="fa fa-boxes"></i>
                        Ürünler
                    </a>
                </li>
                <li class="nav-item">
                    <a class="nav-link text-white list-group-item list-group-item-action bg-dark" href="/category/">
                        <i class="fa fa-layer-group"></i>
                    Kategori
                    </a>
                </li>
                <li class="nav-item">

                    <a class="nav-link text-white list-group-item list-group-item-action bg-dark" href="/logout">
                        <i class="text-danger fa fa-door-open"></i>
                        Çıkış Yap
                    </a>
                </li>

            </ul>
        </div>
    </nav>

</c:if>

<c:if test="${pageContext.request.userPrincipal.name != 'dogukan@gmail.com'}">
    <nav class="col-md-2 d-none d-md-block sidebar bg-light">
        <div class="sidebar-sticky">
            <ul class="nav flex-column">

                <li class="nav-item list-group-item list-group-item-action bg-light" >
                    <h5 class="text-center mt-3">Müşteri İlişkileri Yönetimi</h5>

                </li>

                <li class="nav-item">
                    <a class="nav-link nav-link list-group-item list-group-item-action bg-light" href="/">
                        <i class="fa fa-home"></i>
                        Anasayfa
                    </a>
                </li>
                <li class="nav-item">
                    <a class="nav-link nav-link list-group-item list-group-item-action bg-light" href="/assignedproducts">
                        <i class="fa fa-boxes"></i>
                        Gelen Ürünlerin Onayi
                    </a>
                </li>
                <li class="nav-item">
                    <a class="nav-link nav-link list-group-item list-group-item-action bg-light" href="/completedProducts">
                        <i class="fa fa-check"></i>
                        Satın Alınan Ürünler
                    </a>
                </li>

                <li class="nav-item">

                    <a class="nav-link nav-link list-group-item list-group-item-action bg-light" href="/logout">
                        <i class="text-danger fa fa-door-open"></i>
                        Çıkış Yap
                    </a>
                </li>

            </ul>

        </div>
    </nav>
</c:if>

</body>
</html>