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

        <input type="button" value="Add Employee"
                onclick="window.location.href='showFormForAdd'; return false;"
        />

        <table>
        <tr>
        <th>Name</th>
        <th>Email</th>
        <th>Action</th>
        </tr>

        <c:forEach var="tempEmployee" items="${employees}">

        <c:url var="updateLink" value="/employees/showFormForUpdate">
            <c:param name="employee_id" value="${tempEmployee.id}" />
        </c:url>

            <tr>
                <td> <c:out value="${tempEmployee.username}" /></td>
                <td> <c:out value="${tempEmployee.email}" /></td>
                <td> <a href="${updateLink}"> Update</a>
                |
            </tr>

        </c:forEach>
        </table>

        </div>
    </div>
</body>
</html>
