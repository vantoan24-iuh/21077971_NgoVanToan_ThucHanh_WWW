<%@ page import="vn.edu.iuh.fit.exercise_xe.entities.Hangxe" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %><%--
  Created by IntelliJ IDEA.
  User: ACER
  Date: 10/24/2024
  Time: 4:06 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<style>
    .container {
        margin: 0 auto;
        width: 50%;
    }
    h1 {
        text-align: center;
    }
    table {
        margin: 0 auto;
    }
    input {
        width: 100%;
    }
    select {
        width: 100%;
    }
    button {
        width: 100%;
    }
    a {
        display: block;
        text-align: center;
    }

</style>
<body>
<div class="container">
    <h1>Thêm Xe</h1>
    <a href="index.jsp">Back to DSX</a>

    <form action="controller" method="post">
        <input type="hidden" value="add" name="action">

        <table>
            <thead>
            <tr>
                <td>
                    <label>Tên Xe</label>
                </td>
                <td>
                    <input type="text" name="tenXe">
                </td>
            </tr>
            <tr>
                <td>
                    <label>Giá Xe</label>
                </td>
                <td>
                    <input type="text" name="giaXe">
                </td>
            </tr>
            <tr>
                <td>
                    <label>Năm SX</label>
                </td>
                <td>
                    <input type="text" name="namSX">
                </td>
            </tr>
            <tr>
                <td>
                    <label>Hang Xe</label>
                </td>
                <td>
                    <input type="text" name="hangXe">
                </td>
            <tr>
                <td>
                </td>
                <td>
                    <button type="submit">Them Xe</button>
                </td>
            </tr>
            </thead>
        </table>
    </form>
</div>
</body>
</html>
