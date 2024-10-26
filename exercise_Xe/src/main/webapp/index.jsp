<%@ page import="java.util.List" %>
<%@ page import="vn.edu.iuh.fit.exercise_xe.Dtos.XeDto" %>
<%@ page import="vn.edu.iuh.fit.exercise_xe.repositories.XeRepository" %>
<%@ page import="vn.edu.iuh.fit.exercise_xe.repositories.imp.XeRepositoryImp" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Bán Xe Máy</title>
</head>
<style>
    .container {
        width: 100%;
        height: 100px;
        background-color: #f1f1f1;
        text-align: center;
    }

    ul {
        list-style-type: none;
        margin: 0;
        padding: 0;
        overflow: hidden;
        background-color: #333;
    }

    li {
        float: left;
    }

    li a {
        display: block;
        color: white;
        text-align: center;
        padding: 14px 16px;
        text-decoration: none;
    }

    li a:hover {
        background-color: #111;
    }

    table {
        width: 100%;
        border-collapse: collapse;
    }

    table, th, td {
        border: 1px solid black;
    }

    th, td {
        padding: 15px;
        text-align: left;
    }

    th {
        background-color: #f2f2f2;
    }

    tr:nth-child(even) {
        background-color: #f2f2f2;
    }

    tr:hover {
        background-color: #f5f5f5;
    }

    .search {
        margin-bottom: 20px;
        margin-top: 20px;
        padding: 15px;
    }
</style>
<body>

<div class="container">
    <h2>CỬA HÀNG BÁN XE GẮN MÁY ABC</h2>
    <div>
        <div>
            <ul>
                <li><a href="controller?action=dsXe">Danh Sách Xe</a></li>
                <li><a href="addXe.jsp">Thêm Xe</a></li>
            </ul>
        </div>
        <div class="search">
            <form action="controller" method="get"> <!-- Change method to get -->
                <input type="hidden" value="search" name="action">
                <input type="text" name="search" placeholder="Nhập tên xe hoặc giá xe" required> <!-- Add required for validation -->
                <button type="submit">Tìm kiếm</button>
            </form>
        </div>
    </div>
    <div>
        <form action="controller" method="get">
            <input type="hidden" value="dsXe" name="action">
            <table>
                <thead>
                <tr>
                    <th>Mã Xe</th>
                    <th>Tên Xe</th>
                    <th>Giá Xe</th>
                    <th>Năm SX</th>
                    <th>Hãng xe</th>
                </tr>
                </thead>
                <tbody>
                <%
                    // Retrieve the list of XeDto from the session
                    List<XeDto> listXe = (List<XeDto>) session.getAttribute("listXe");

                    if (listXe==null) {
                        response.sendRedirect("controller?action=dsXe");
                    }
                    // Check if the list is not null and iterate over it
                    if (listXe != null) {
                        for (XeDto xeDto : listXe) {
                %>
                <tr>
                    <td><%= xeDto.getId() %></td>
                    <td><%= xeDto.getTenXe() %></td>
                    <td><%= xeDto.getGiaXe() %></td>
                    <td><%= xeDto.getNamSX() %></td>
                    <td><%= xeDto.getMaHangXe() != null ? xeDto.getMaHangXe().getTenHang() : "N/A" %></td>
                </tr>
                <%
                    }
                } else {
                %>
                <tr>
                    <td colspan="5">Không có dữ liệu nào để hiển thị.</td>
                </tr>
                <%
                    }
                %>
                </tbody>
            </table>
        </form>
    </div>
</div>
</body>
</html>
