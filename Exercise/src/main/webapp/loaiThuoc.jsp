<%--
  Created by IntelliJ IDEA.
  User: ACER
  Date: 10/23/2024
  Time: 5:10 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Danh Sach Loai Thuoc</title>
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
            <th>Ma Loai Thuoc</th>
            <th>Tên Loai Thuốc</th>
        </tr>
        </thead>
        <tbody>

        </tbody>
    </table>
</div>
</body>
</html>
