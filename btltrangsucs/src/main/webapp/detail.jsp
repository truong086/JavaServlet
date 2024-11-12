<%-- 
    Document   : detail
    Created on : Mar 18, 2023, 8:56:52 AM
    Author     : ASUS
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
        <title>JSP Page</title>
        
    </head>
    <body>
        
        <!--Main layout-->
<main class="mt-5 pt-4">
    <div class="container mt-5">
        <!--Grid row-->
        <div class="row">
            <!--Grid column-->
            <div class="col-md-6 mb-4">
                <img src="${details.image}" class="img-fluid" alt="" />
            </div>
            <!--Grid column-->

            <!--Grid column-->
            <div class="col-md-6 mb-4">
                <
                <!--Content-->
                <div class="p-4">
                    <div class="mb-3">
                        <a href="">
                            <span class="badge bg-dark me-1">Category 2</span>
                        </a>
                        <a href="">
                            <span class="badge bg-info me-1">New</span>
                        </a>
                        <a href="">
                            <span class="badge bg-danger me-1">Bestseller</span>
                        </a>
                    </div>

                    <p class="lead">
                        <span class="me-1">
                            <del>${details.price}</del>
                        </span>
                        <span>${details.price}</span>
                    </p>
                    <select name="sizeS">
                        <option value="s">S</option>
                        <option value="m">M</option>
                        <option value="l">L</option>
                    </select>
                    <strong><p style="font-size: 20px;">${details.title}</p></strong>

                    <p>${details.description}</p>

                    <form class="d-flex justify-content-left" name="f" action="" method="post">
                        <!-- Default input -->
                        <div class="form-outline me-1" style="width: 100px;">
                            <input type="number" name="num" value="1" class="form-control" />
                        </div>
                        <button onclick="muahang('${details.id}')" class="btn btn-primary ms-1" type="submit">
                            Add to cart
                            <i class="fas fa-shopping-cart ms-1"></i>
                        </button>
                    </form>
                </div>
                <!--Content-->
            </div>
            <!--Grid column-->
        </div>
        <!--Grid row-->

        <hr />

        <!--Grid row-->
        <div class="row d-flex justify-content-center">
            <!--Grid column-->
            <div class="col-md-6 text-center">
                <h4 class="my-4 h4">Additional information</h4>

                <p>Lorem ipsum dolor sit amet consectetur adipisicing elit. Natus suscipit modi sapiente illo soluta odit voluptates, quibusdam officia. Neque quibusdam quas a quis porro? Molestias illo neque eum in laborum.</p>
            </div>
            <!--Grid column-->
        </div>
        <!--Grid row-->

        <!--Grid row-->
        <div class="row">
            <!--Grid column-->
            <div class="col-lg-4 col-md-12 mb-4">
                <img src="https://mdbootstrap.com/img/Photos/Horizontal/E-commerce/Products/11.jpg" class="img-fluid" alt="" />
            </div>
            <!--Grid column-->

            <!--Grid column-->
            <div class="col-lg-4 col-md-6 mb-4">
                <img src="https://mdbootstrap.com/img/Photos/Horizontal/E-commerce/Products/12.jpg" class="img-fluid" alt="" />
            </div>
            <!--Grid column-->

            <!--Grid column-->
            <div class="col-lg-4 col-md-6 mb-4">
                <img src="https://mdbootstrap.com/img/Photos/Horizontal/E-commerce/Products/13.jpg" class="img-fluid" alt="" />
            </div>
            <!--Grid column-->
        </div>
        <!--Grid row-->
    </div>
</main>
<!--Main layout-->

<!-- footer -->
<footer class="text-center text-white mt-4" style="background-color: #607d8b;">
    <!--Call to action-->
    <div class="pt-4 pb-2">
        <a class="btn btn-outline-white footer-cta mx-2" style="box-shadow: rgba(0, 0, 0, 0.15) 0px 5px 15px;" href="https://mdbootstrap.com/docs/jquery/getting-started/download/" target="_blank" role="button">
            Download MDB
            <i class="fas fa-download ms-2"></i>
        </a>
        <a class="btn btn-outline-white footer-cta mx-2" style="box-shadow: rgba(0, 0, 0, 0.15) 0px 5px 15px;" href="https://mdbootstrap.com/education/bootstrap/" target="_blank" role="button">
            Start free tutorial
            <i class="fas fa-graduation-cap ms-2"></i>
        </a>
    </div>
    <!--/.Call to action-->

    <hr class="text-dark" />

    <div class="container">
        <!-- Section: Social media -->
        <section class="mb-3">
            <!-- Facebook -->
            <a class="btn-link btn-floating btn-lg text-white" href="#!" role="button" data-mdb-ripple-color="dark"><i class="fab fa-facebook-f"></i></a>

            <!-- Twitter -->
            <a class="btn-link btn-floating btn-lg text-white" href="#!" role="button" data-mdb-ripple-color="dark"><i class="fab fa-twitter"></i></a>

            <!-- Google -->
            <a class="btn-link btn-floating btn-lg text-white" href="#!" role="button" data-mdb-ripple-color="dark"><i class="fab fa-google"></i></a>

            <!-- Instagram -->
            <a class="btn-link btn-floating btn-lg text-white" href="#!" role="button" data-mdb-ripple-color="dark"><i class="fab fa-instagram"></i></a>

            <!-- YouTube -->
            <a class="btn-link btn-floating btn-lg text-white" href="#!" role="button" data-mdb-ripple-color="dark"><i class="fab fa-youtube"></i></a>
            <!-- Github -->
            <a class="btn-link btn-floating btn-lg text-white" href="#!" role="button" data-mdb-ripple-color="dark"><i class="fab fa-github"></i></a>
        </section>
        <!-- Section: Social media -->
    </div>
    <!-- Grid container -->

    <!-- Copyright -->
    <div class="text-center p-3" style="background-color: rgba(0, 0, 0, 0.2); text-color: #e0e0e0;">
        © 2022 Copyright:
        <a class="text-white" href="https://mdbootstrap.com/">MDBootstrap.com</a>
    </div>
    <!-- Copyright -->
</footer>

    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>
    <script src="
        https://cdn.jsdelivr.net/npm/jquery@3.6.4/dist/jquery.min.js
        "></script>
        
        <script type="text/javascript">
            function muahang(id){
                document.f.action = "muahang?id="+id;
                document.f.submit();
            }
        </script>
    </body>
</html>
