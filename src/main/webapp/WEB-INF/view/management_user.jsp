<%--<%@ taglib prefix="c" uri="http://www.springframework.org/tags" %>--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset='UTF-8'>

    <title>Management Users</title>

    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.2.0/css/all.min.css"
          integrity="sha512-xh6O/CkQoPOWDdYTDqeRdPCVd1SpvCA9XXcUnZS2FmJNp1coAFzvtCN9BmamE+4aHK8yyUHUSCcJHgXloTyT2A=="
          crossorigin="anonymous" referrerpolicy="no-referrer"/>
    <link rel="stylesheet" href="<c:url value="/css/style.css"/>" />
</head>

<body>

<div id="page-wrap">

    <form class="search" action="/users/search" method="post">
        <select id="field" name="field">
            <option value="fullName">Australia</option>
            <option value="department">Canada</option>
            <option value="gender">USA</option>
            <option value="email">USA</option>
        </select>
        <input type="text" placeholder="Search.." name="search">
        <button type="submit"><i class="fa fa-search"></i></button>
    </form>

    <table>
        <tr>
            <th>Full Name</th>
            <th>Department</th>
            <th>Gender</th>
            <th>Year of Birth</th>
            <th>Email</th>
            <th>Mobile phone</th>
            <th>Action</th>
        </tr>
        <c:forEach items="${users}" var="user">
            <tr>
                <td>${user.fullName}</td>
                <td>${user.department}</td>
                <td>${user.gender}</td>
                <td>${user.year}</td>
                <td>${user.email}</td>
                <td>${user.mobilePhone}</td>
                <td><i class="fa-solid fa-info icon"><a href="/users/info/${user.id}"></a></i>
                    <i class="fa-solid fa-trash-can icon"><a href="/users/delete/${user.id}"></a></i>
                    <i class="fa-solid fa-pencil icon"><a href="/users/update/${user.id}"></a></i></td>
            </tr>
        </c:forEach>
    </table>
    <button><a href="/users/create"/>Create User</button>

</div>

</body>

</html>