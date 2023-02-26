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

        <input type="button" value="Add Department"
                onclick="window.location.href='showFormForAdd'; return false;"
        />

        <table>
        <tr>
        <th>Name</th>
        <th>Email</th>
        <th>Action</th>
        </tr>

        <c:forEach var="tempDepartment" items="${departments}">

        <c:url var="updateLink" value="/departments/showFormForUpdate">
            <c:param name="department_id" value="${tempDepartment.id}" />
        </c:url>

        <!-- construct an "delete" link with customer id -->
        <c:url var="deleteLink" value="/departments/delete">
        	<c:param name="department_id" value="${tempDepartment.id}" />
        </c:url>

            <tr>
                <td> <c:out value="${tempDepartment.name}" /></td>
                <td> <c:out value="${tempDepartment.location}" /></td>
                <td> <a href="${updateLink}"> Update</a>
                |
                <a href="${deleteLink}"
                onclick="if (!(confirm('Are you sure you want to delete this department?'))) return false">Delete</a>
            </tr>

        </c:forEach>
        </table>

        </div>
    </div>
</body>
</html>
