<%-- 
    Document   : header
    Created on : Mar 23, 2023, 12:54:08 PM
    Author     : ASUS
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
        <title>JSP Page</title>
        <style>
                        *{
                margin: 0;
                padding: 0;
                box-sizing: border-box;
            }

            .row{
                width: 100%;
                height: 800px;
                background: url("Slide_banner-1-1.jpg");
                background-repeat: no-repeat;
                background-size: cover;
                z-index: 1;

            }
            .row::before{
                content: "";
                display: block;
                background: rgba(0, 0, 0, 0.4);
                width: 100%;
                height: 100%;
                position: absolute;
                z-index: 1;
                top: 0;
                left: 0;
            }

            .row{
                display: flex;
                justify-content: center;
                z-index: 1;
                padding-top: 20px;
                position: relative;
            }

            .row1{
                display: flex;
                z-index: 1;
            }
            /* .row1ss{
                height: 50px;
                line-height: 20px;
            } */
            .row1sss{
                height: 50px;
                line-height: 50px;
            }
            .row1sss a{
                margin-left: 10px;
                margin-top: 20px;
                text-decoration: none;
                color: white;
                z-index: 1;
                font-size: 14px;
                font-family: Arial, Helvetica, sans-serif;
            }
            .flexbox a:nth-child(7){
                margin-right: 50px;
            }
            .flexbox a:nth-child(1){
                margin-left: 30px;
            }
            .row2{
                height: 30px;
                line-height: 30px;
                z-index: 1;
            }

            .rows i{
                color: black;
                z-index: 1;
                cursor: pointer;
                width: 30px;
                height: 30px;
                border-radius: 50%;
                color: white;
            }


            .row2{
                padding: 10px 0;
                width: 200px;
                height: 50px;
                text-align: center;
            }
            .row2 button{
                width: 30px;
                height: 30px;
                outline: none;
                border: none;
                background: #d3b673;
                border-radius: 50%; 
                
            }



            .row1sss a:hover{
                text-decoration: underline;
                transition: 1s ease-in-out;
                color: red;
            }

            .row3{
                position: absolute;
                top: 70%;
                left: 50%;
                transform: translate(-70%, -50%);
                z-index: 1;
            }

            .row3 a{
                padding: 0 15px;
                font-size: 16px;
                font-weight: 700;
                font-family: Arial, Helvetica, sans-serif;
                text-transform: uppercase;
                height: 40px;
                border: 1px solid white;
                display: flex;
                align-items: center;
                justify-content: center;
                z-index: 1;
                text-decoration: none;
                color: white;
                max-width: 166px;
                margin: auto;
                cursor: pointer;
            }

            .row3 a:hover{
                background-color: orange;
                text-decoration: underline;
                transition: 1s ease;
            }

            .row4{
                width: 100%;
                height: auto;
                text-align: center;
                margin-top: 50px;
                display: flex;
                justify-content: center;
                align-items: center;
            }
            .row5{
                width: 100%;
                height: auto;
                text-align: center;
                width: 500px;

            }

            .row5 h3{
                color: #d3b673;
                font-size: 22px;
                margin-bottom: 5px;
                font-weight: bold;
                font-family: Arial, Helvetica, sans-serif;
            }

            .row5 h1{
                font-family: 36px;
                color: #000000;
                text-align: center;
                font-family: Arial, Helvetica, sans-serif;
                font-weight: 700;
                letter-spacing: 1.8px;
                text-transform: uppercase;
                margin-bottom: 0 !important;
                padding: 0 50px;
            }

            .row8{
                display: flex;
                justify-content: center;
                align-items: center;
            }

            .row6{
                display: flex;
                justify-content: center;
                align-items: center;
                width: 50%;
                position: relative;
                margin-top: 20px;
            }
            .row6s{
                position: absolute;
                width: 100px;
                height: 2px;
                background-color: orange;
                margin-top: 20px;
                left: 0;
            }
            .row6s::before{
                position: absolute;
                content: "";
                display: block;
                top: -10px;
                right: 0;
                width: 50%;
                height: 1px;
                background-color: orange;
            }
            .row6sss{
                position: absolute;
                width: 100px;
                height: 2px;
                background-color: orange;
                right: 0;
                margin-top: 20px;
            }

            .row6sss::before{
                content: "";
                position: absolute;
                display: block;
                width: 50%;
                top: -10px;
                left: 0;
                height: 1px;
                background-color: orange;
            }
            .row6ss{
                color: orange;
                font-size: 20px;
            }
            .row7{
                width: 100%;
                height: auto;
                display: flex;
                justify-content: center;
                align-items: center;
                position: relative;
            }
            .row8s{
                margin-top: 20px;
                width: 100%;
                height: auto;
                display: flex;
                justify-content: center;
                align-items: center;
            }
            .row9{
                width: 20%;
                margin-right: 100px;
                margin-left: 100px;
            }
            .row10 ul li{
                list-style: none;
                margin: 15px 0;
            }
            .row10 ul li a{
                text-decoration: none;
                font-size: 25px;
                color: yellow;
                font-weight: bold; 
                font-family: arial;
            }
            .row10 ul li a{
                /*display: block;*/
                width: 100%;
                /* background-color: rebeccapurple; */
            }
            .row11{
                width: 70%;
                display: flex;
                justify-content: space-between;
                flex-wrap: wrap;
            }
            .row12{
                width: 350px;
                height: 450px;
            }
            .row14{
                width: 350px;
                height: auto;
                overflow: hidden;
            }

/*            .row14s{
                width: 350px;
                height: 300px;
                background: url("https://tocotocotea.com/wp-content/uploads/2023/01/Tra-Dao-Dau-Tay-Kem-Pho-Mai.png");
                background-repeat: no-repeat;
                background-size: cover;
                z-index: 1;
            }*/
            .row14 img{
                width: 350px;
                height: 300px;
            }
            .row14s:hover{
                transition: 1s ease;
                transform: scale(1.1);
            }

            .row15{
                width: 100%;
                height: auto;
                text-align: center;
                margin-top: 15px;
            }
            .row15 a{
                text-decoration: none;
                font-size: 15px;
            }
            .row16{
                width: 100%;
                text-align: center;
                height: auto;
                margin: 10px 0;
            }
            .row17{
                width: 100%;
                height: auto;
                text-align: center;
            }

            .row18{
                width: 100%;
                text-align: center;
                margin-top: 20px;
            }
            .row18 a{
                padding: 10px 50px;
                background-color: #d3b673;
                color: #fff;
                text-decoration: none;

            }
            .active{
                background-color: #d3b673;
                padding: 10px 30px;
            }
            .search{
                outline: none;
                width: 150px;
                height: 20px;
                padding: 0 10px;
                border: none;
            }
            .rows{
                display: flex;
                justify-content: space-between;
                width: 200px;
               
            }
        </style>
    </head>
    <body>
        <header>
        <div class="nav">
            <div class="row flexbox">
                <div class="row1 flexbox">
                    <div class="row1s">
                        
                        <img src="Logo-ngang-01.png" style="width: 200px;" alt="">
                        
                    </div>
                    <div class="row1ss">
                        <div class="row1sss">
                            <a href="">TRANG CHỦ</a>
                            <a href="">GIỚI THIỆU</a>
                            <a href="">SẢN PHẨM</a>
                            <a href="">TIN TỨC</a>
                            <a href="">CỬA HÀNG</a>
                            <a href="dangnhap.jsp">Đăng nhập</a>
                            <a href="">Hello, ABC</a>
                            
                        </div> 
                    </div>
                </div>
                <div class="row2">
                    <form action="search" method="post">
                        <div class="rows">
                            <input name="timkiem" type="search" placeholder="Search" class="search" />
                            <button type="submit"><i class="fa fa-search"></i></button>
                        </div>
                    </form>
                </div>
                <div class="row3">
                    <a href="">Đặt hàng ngay</a>
                </div>
            </div>
        </div>
    </header>
    </body>
</html>
