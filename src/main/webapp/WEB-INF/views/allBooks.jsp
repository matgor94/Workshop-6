<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<html>
<head>
    <title>Lista książek</title>
</head>
<body>
<div>
<div>
    <table border="1">
        <tr>
            <th>Id</th>
            <th>ISBN</th>
            <th>Title</th>
            <th>Author</th>
            <th>Type</th>
        </tr>
        <c:forEach items="${bookList}" var="book">
            <tr>
                <td>${book.id}</td>
                <td>${book.isbn}</td>
                <td>${book.title}</td>
                <td>${book.author}</td>
                <td>${book.type}</td>
            </tr>
        </c:forEach>
    </table>
    <a href="/book/addBook">Dodaj książkę</a></div>
</div>
</body>
</html>