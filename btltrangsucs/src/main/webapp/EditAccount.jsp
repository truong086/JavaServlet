<%-- 
    Document   : EditFrom
    Created on : Mar 27, 2023, 10:47:59 AM
    Author     : ASUS
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
        <title>JSP Page</title>
        <style>
            .intro {
  height: 100%;
}

.gradient-custom {
  /* fallback for old browsers */
  background: #fa709a;

  /* Chrome 10-25, Safari 5.1-6 */
  background: -webkit-linear-gradient(to bottom right, rgba(250, 112, 154, 1), rgba(254, 225, 64, 1));

  /* W3C, IE 10+/ Edge, Firefox 16+, Chrome 26+, Opera 12+, Safari 7+ */
  background: linear-gradient(to bottom right, rgba(250, 112, 154, 1), rgba(254, 225, 64, 1))
}
        </style>
    </head>
    <body>
      <section class="intro">
  <div class="mask d-flex align-items-center h-100 gradient-custom">
    <div class="container">
      <div class="row justify-content-center">
        <div class="col-12 col-lg-9 col-xl-7">
          <div class="card">
            <div class="card-body p-4 p-md-5">
              <h3 class="mb-4 pb-2">Registration Form</h3>

              <form action="editTaikhoan" method="post">
                  <c:if test="${editPro.id != null}" >
                      <input type="hidden" name="id" id="id" value="${editPro.id}"/>
                    </c:if>
                  <div class="row">
                    <div class="col-md-6 mb-4">

                      <div class="form-outline">
                          <c:if test="${editPro.id != null}" >
                        <input type="text" id="firstName" name="username" value="${editPro.username}" class="form-control" />
                          </c:if>
                        <c:if test="${editPro.id == null}" >
                        <input type="text" id="firstName" name="username" class="form-control" />
                          </c:if>
                        <label class="form-label" for="username">username</label>
                      </div>
                        <div class="form-outline">
                          <c:if test="${editPro.id != null}" >
                        <input type="text" id="firstName" name="password" value="${editPro.password}" class="form-control" />
                          </c:if>
                        <c:if test="${editPro.id == null}" >
                        <input type="text" id="firstName" name="password" class="form-control" />
                          </c:if>
                        <label class="form-label" for="password">password</label>
                      </div>
                        <div class="form-outline">
                          <c:if test="${editPro.id != null}" >
                        <input type="text" id="firstName" name="is_sell" value="${editPro.sell_ID}" class="form-control" />
                          </c:if>
                        <c:if test="${editPro.id == null}" >
                        <input type="text" id="firstName" name="is_sell" class="form-control" />
                          </c:if>
                        <label class="form-label" for="is_sell">Mã bán hàng</label>
                      </div>
                        <div class="form-outline">
                          <c:if test="${editPro.id != null}" >
                        <input type="text" id="firstName" name="is_admin" value="${editPro.isAdmin}" class="form-control" />
                          </c:if>
                        <c:if test="${editPro.id == null}" >
                        <input type="text" id="firstName" name="is_admin" class="form-control" />
                          </c:if>
                        <label class="form-label" for="is_admin">Mã admin</label>
                      </div>

                       

                  </div>
<!--                    <a href="star-admin2-free-admin-template/template/pages/tables/basic-table.jsp"></a>-->
                  <div class="row">
                    <div class="col-12">


                      
                      <div class="mt-4">
                        <input class="btn btn-warning btn-lg" type="submit" value="Submit" />
                      </div>

                    </div>
                  </div>

              </form>
            </div>
          </div>
        </div>
      </div>
    </div>
  </div>
</section>
    </body>
</html>
