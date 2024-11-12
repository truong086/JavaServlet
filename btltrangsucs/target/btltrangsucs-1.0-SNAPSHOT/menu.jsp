
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!-- Navbar -->
<nav class="navbar navbar-expand-lg navbar-dark mt-3 mb-5 shadow p-2" style="background-color: #607D8B">
  <!-- Container wrapper -->
  <div class="container-fluid">

    <!-- Navbar brand -->
    <a class="navbar-brand" href="#">Categories:</a>

    <!-- Toggle button -->
    <button 
       class="navbar-toggler" 
       type="button" 
       data-mdb-toggle="collapse" 
       data-mdb-target="#navbarSupportedContent2" 
       aria-controls="navbarSupportedContent2" 
       aria-expanded="false" 
       aria-label="Toggle navigation">
      <i class="fas fa-bars"></i>
    </button>

    <!-- Collapsible wrapper -->
    <div class="collapse navbar-collapse" id="navbarSupportedContent2">
      
        <a href="home.jsp">Trang chủ</a>
        <!--"sessionScope.acc" nghĩa là gọi lại biến "acc" trong "session" để kiểm tra xem người dùng đã đăng nhập chưa, nếu đăng nhập rồi thì hiển thị
            "Logout", còn nếu chưa đăng nhập thì sẽ hiển thị là "Đăng nhập", biến "acc" này được khai báo trong lớp Servlet(HomeControl),
            biến "acc" này là lưu trữ tài khoản người dùng vừa đang nhập lên "Session"
        -->
        <c:if test="${sessionScope.acc != null}">
            <p>Xin chào ${sessionScope.acc.username}</p> <!--Lấy ra biến "username" trong class "Account", để khi người dùng vừa đăng nhập vào trang web thì hệ thống sẽ lấy ra được tên tài khoản người dùng và hiển thị lên-->
            <a href="logout">Logout</a>
        </c:if>
        <c:if test="${sessionScope.acc == null}">
            <a href="login.jsp">Đăng nhập</a>
        </c:if>
            
            <!--Kiểm tra nếu tài khoản người dùng vừa đăng nhập có trường dữ liệu "isSell == 1" có nghĩa đây là tài khoản nhân viên thì sẽ hiển thị chức năng mua hàng-->
            <c:if test="${sessionScope.acc.isSell == 1}"><!--Kiểm tra "isSell == 1" thì tài khoản "nhân viên", biến "isSell" này là 1 trường dữ liệu trong
                                                                database, và được ánh xạ lại bởi lớp "Account"
                                                            -->
                <a href="">Mua Hàng</a>
            </c:if>
                
            <!--Kiểm trta tài khoản người dùng vừa đăng nhập có tồn tại trường dữ liệu là "isAdmin == 1" có nghĩa đây là tài khoản của "admin" thì sẽ hiển thị chức năng là bán hàng-->
            <c:if test="${sessionScope.acc.isAdmin == 1}">  <!--Kiểm tra "isAdmin == 1" thì tài khoản "Admin", biến "isAdmin" này là 1 trường dữ liệu trong
                                                                database, và được ánh xạ lại bởi lớp "Account"
                                                            -->
                <a href="manager">Bán hàng</a>
            </c:if>
      <!-- Search -->
      <!--action="search" nghĩa là chuyền dữ liệu về lớp "SearchControl" để xử lý, lớp "SearchControl" này có đường dẫn là "search", đường dẫn này được khởi tạo khi vừa tạo file "servlet"-->
      <form action="search" method="post" class="w-auto py-1" style="max-width: 12rem">
          <input value="${values}" type="search" name="txt" class="form-control rounded-0" placeholder="Search" aria-label="Search">
          <button type="submit" onclick="load()">Tìm kiếm</button>
      </form>

    </div>
  </div>
  <!-- Container wrapper -->
</nav>
<!-- Navbar -->

<script>
    
    function load(e){
        e.preventDefault(); // Chống load lại trang khi ấn click 
    }
</script>