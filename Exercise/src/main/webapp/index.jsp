<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Quan Ly Thuoc</title>
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
    a{
        text-decoration: none;
        padding: 20px;
    }
</style>
<body>
<h1><%= "Quan ly Thuoc" %>
</h1>
<br/>
<div>
    <table>
        <thead>
        <tr>
            <td>
                <label>Toan</label>
            </td>
        <tr>
            <td>
                <a href="loaiThuoc.jsp">Danh Sach Loai Thuoc</a>
            </td>
            <td>
                <a href="thuoc.jsp">Danh Sach Thuoc</a>
            </td>
            <td>
                <a href="themThuoc.jsp">Them Thuoc</a>
            </td>

        </tr>
        </thead>
    </table>
</div>
</body>
</html>