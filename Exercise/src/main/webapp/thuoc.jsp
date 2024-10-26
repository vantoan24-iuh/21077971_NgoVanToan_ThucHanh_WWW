<%@ page import="vn.edu.iuh.fit.exercise.backend.dots.ThuocDto" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Danh Sach Thuoc</title>
</head>
<style>
    table {
        width: 600px;
        border-collapse: collapse;
    }

    table, thead, tr, td, th {
        border: 1px solid black;
    }

    th, td {
        padding: 8px;
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

</style>
<body>
<h1>Danh Sách Loại Thuốc</h1>
<br>
<div>
    <table>
        <thead>
        <tr>
            <th>ID</th>
            <th>Tên Thuốc</th>
            <th>Giá Thuốc</th>
            <th>Năm SX</th>
            <th>Mã Loại Thuốc</th>
        </tr>
        </thead>
        <tbody>
        <%
            List<ThuocDto> thuocs = (List<ThuocDto>) request.getAttribute("thuocs");
            if (thuocs != null && !thuocs.isEmpty()) {  // Check if the list is not null and not empty
                for (ThuocDto thuoc : thuocs) {
        %>
        <tr>
            <td><%= thuoc.getId() %></td>
            <td><%= thuoc.getTenThuoc() %></td>
            <td><%= thuoc.getGia() %></td>
            <td><%= thuoc.getNamSX() %></td>
            <td><%= thuoc.getMaLoai().getId() %></td>
        </tr>
        <%
            }
        } else {
        %>
        <tr>
            <td colspan="5">No data available</td>
        </tr>
        <%
            }
        %>
        </tbody>
    </table>
</div>
</body>
</html>
