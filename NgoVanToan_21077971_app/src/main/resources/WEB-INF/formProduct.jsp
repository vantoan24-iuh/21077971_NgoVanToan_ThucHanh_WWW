<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Document</title>
</head>
<body>
<form action="controller" method="get">
    <input type="hidden" name="action" value="add">
    <input type="text"   name="name" placeholder="name">
    <input type="text"   name="description" placeholder="description">
    <input type="text" name="imgPath" placeholder="imgPath">

    <input type="submit" value="Insert">
    <input type="reset" value="Reset">
</form>
<a href="ProductList.jsp">Product List</a>
</body>
</html>