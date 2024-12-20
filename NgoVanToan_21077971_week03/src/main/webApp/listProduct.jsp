<%--
  Created by IntelliJ IDEA.
  User: ACER
  Date: 10/10/2024
  Time: 10:50 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<div class="container-fluid">
    <%--    Form tìm kiếm product --%>
    <form action="controller" method="get" class="mb-4 pt-5">
        <input type="hidden" name="action" value="search">
        <input type="text" name="id" placeholder="Tìm kiếm sản phẩm..." class="form-control"
               required>
        <button type="submit" class="btn btn-primary mt-2">Tìm kiếm</button>
    </form>
    <form action="controller" method="GET">
        <button type="submit" class="btn btn-success">Reset</button>
    </form>
    <%-- Hiển thị danh sách sản phẩm hoặc sản phẩm tìm kiếm --%>
    <%-- Hiển thị sản phẩm tìm kiếm nếu có --%>
    <c:if test="${not empty product}">
        <div class="card" style="width: 18rem; margin-top: 20px;">
            <img src="${product.imgPath}" class="card-img-top" alt="${product.name}">
            <div class="card-body">
                <h5 class="card-title">Name: ${product.name}</h5>
                <p class="card-text">Description: ${product.description}</p>
                <p class="card-text">Price: <fmt:formatNumber value="${product.price}"
                                                              type="currency"
                                                              currencySymbol="VNĐ"/></p>
            </div>
        </div>
    </c:if>
    <%-- Hiển thị tất cả sản phẩm  --%>
    <c:if test="${not empty products}">
        <div class="row">
            <c:forEach var="prod" items="${products}">
                <div class="card" style="width: 18rem; margin-bottom: 20px">
                    <img src="img/${prod.imgPath}" class="card-img-top" alt="${prod.name}">
                    <div class="card-body">
                        <h5 class="card-title">Name: ${prod.name}</h5>
                        <p class="card-text">Description: ${prod.description}</p>
                        <p class="card-text">Price: <fmt:formatNumber value="${prod.price}"
                                                                      type="currency"
                                                                      currencySymbol="VNĐ"/></p>
                    </div>
                </div>
            </c:forEach>
        </div>
    </c:if>
</div>
</body>
</html>
