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

              <form action="editSanPham" method="post">
                  <c:if test="${editPro.id != null}" >
                      <input type="hidden" name="id" id="id" value="${editPro.id}"/>
                    </c:if>
                  <div class="row">
                    <div class="col-md-6 mb-4">

                      <div class="form-outline">
                          <c:if test="${editPro.id != null}" >
                        <input type="text" id="firstName" name="title" value="${editPro.title}" class="form-control" />
                          </c:if>
                        <c:if test="${editPro.id == null}" >
                        <input type="text" id="firstName" name="title" class="form-control" />
                          </c:if>
                        <label class="form-label" for="firstName">Title</label>
                      </div>
                        <div class="form-outline">
                          <c:if test="${editPro.id != null}" >
                        <input type="text" id="firstName" name="name" value="${editPro.name}" class="form-control" />
                          </c:if>
                        <c:if test="${editPro.id == null}" >
                        <input type="text" id="firstName" name="name" class="form-control" />
                          </c:if>
                        <label class="form-label" for="firstName">Name</label>
                      </div>
                        <div class="form-outline">
                          <c:if test="${editPro.id != null}" >
                        <input type="text" id="firstName" name="image" value="${editPro.image}" class="form-control" />
                          </c:if>
                        <c:if test="${editPro.id == null}" >
                        <input type="text" id="firstName" name="image" class="form-control" />
                          </c:if>
                        <label class="form-label" for="firstName">Ảnh</label>
                      </div>
                        <div class="form-outline">
                          <c:if test="${editPro.id != null}" >
                        <input type="text" id="firstName" name="price" value="${editPro.price}" class="form-control" />
                          </c:if>
                        <c:if test="${editPro.id == null}" >
                        <input type="text" id="firstName" name="price" class="form-control" />
                          </c:if>
                        <label class="form-label" for="firstName">price</label>
                      </div>
                        <div class="form-outline">
                          <c:if test="${editPro.id != null}" >
                        <input type="text" id="firstName" name="description" value="${editPro.description}" class="form-control" />
                          </c:if>
                        <c:if test="${editPro.id == null}" >
                        <input type="text" id="firstName" name="description" class="form-control" />
                          </c:if>
                        <label class="form-label" for="firstName">description</label>
                      </div>
                        <div class="form-outline">
                          <select name="categoty_id">
                            <c:forEach items="${findAllCat}" var="PrList">
                                <option ${editPro.catID == PrList.id ? "selected" : ""} value="${PrList.id}">${PrList.tenloai}</option>
                            </c:forEach>
                            
                        </select>
                        <label class="form-label" for="firstName">Category</label>
                      </div>
                        
                        
                        <div class="form-outline">
                            <c:if test="${sessionScope.acc != null}">
                                <input type="hidden" name="taikhoan" value="${sessionScope.acc.id}" />
                            </c:if>
                            
                      </div>
                        
                        <div class="form-outline">
                            <c:if test="${editPro.id != null}" >
                                <input type="number" id="firstName" name="soluong" value="${editPro.soluong}" class="form-control" />
                          </c:if>
                        <c:if test="${editPro.id == null}" >
                            <input type="number" id="firstName" name="soluong" class="form-control" />
                          </c:if>
                            
                      </div>
                        
                        <label class="form-label" for="firstName">Số lượng</label>
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
