<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page isELIgnored="false" %>

<!DOCTYPE html>

<html>

<head>
    <title> List Clients </title>
</head>

<body>

    <div id="container">
        <div id="content">

        <input type="button" value="Add Client"
                onclick="window.location.href='showFormForAdd'; return false;"
        />

        <table>
        <tr>
        <th>Name</th>
        <th>Email</th>
        <th>Action</th>
        </tr>

        <c:forEach var="tempClient" items="${clients}">

        <c:url var="updateLink" value="/clients/showFormForUpdate">
            <c:param name="client_id" value="${tempClient.id}" />
        </c:url>

        <!-- construct an "delete" link with customer id -->
        <c:url var="deleteLink" value="/clients/delete">
        	<c:param name="client_id" value="${tempClient.id}" />
        </c:url>

            <tr>
                <td> <c:out value="${tempClient.name}" /></td>
                <td> <c:out value="${tempClient.email}" /></td>
                <td> <a href="${updateLink}"> Update</a>
                |
                <a href="${deleteLink}"
                onclick="if (!(confirm('Are you sure you want to delete this client?'))) return false">Delete</a>
            </tr>

        </c:forEach>
        </table>

        </div>
    </div>
</body>
</html>
