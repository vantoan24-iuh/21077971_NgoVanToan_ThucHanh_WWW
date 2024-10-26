<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Thêm Thuốc</title>
</head>
<body>
<h1>Thêm Thuốc</h1>
<form action="controller" method="post">
    <input type="hidden" value="add" name="action">
    <table>
        <thead>
        <tr>
            <td>
                <label>Tên Thuốc</label>
            </td>
            <td>
                <input type="text" name="tenThuoc" placeholder="Tên Thuốc" required>
            </td>
        </tr>
        <tr>
            <td>
                <label>Giá Thuốc</label>
            </td>
            <td>
                <input type="text" name="giaThuoc" placeholder="Giá Thuốc" required>
            </td>
        </tr>
        <tr>
            <td>
                <label>Năm SX Thuốc</label>
            </td>
            <td>
                <input type="text" name="namSX" placeholder="Năm SX Thuốc" required>
            </td>
        </tr>
        <tr>
            <td>
                <label>Mã Loại</label>
            </td>
            <td>
                <input type="text" name="maLoaiThuoc" placeholder="Mã Loại Thuốc" required>
            </td>
        </tr>
        <tr>
            <td>

            </td>
            <td>
                <button type="submit">Add</button>
            </td>
        </tr>
        </thead>
    </table>
</form>
</body>
</html>
