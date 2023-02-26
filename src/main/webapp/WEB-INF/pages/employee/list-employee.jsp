<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page isELIgnored="false" %>

<!DOCTYPE html>

<html>

<head>
    <title> List Employees </title>
</head>

<body>

    <div id="container">
        <div id="content">

        <table>
        <tr>
        <th>Name</th>
        <th>Email</th>
        </tr>

        <c:forEach var="tempEmployee" items="${employees}">

            <tr>
                <td> <c:out value="${tempEmployee.username}" /></td>
                <td> <c:out value="${tempEmployee.email}" /></td>
            </tr>

        </c:forEach>
        </table>

        </div>
    </div>
</body>
</html>
