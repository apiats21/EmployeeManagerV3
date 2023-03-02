<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page isELIgnored="false" %>

<!DOCTYPE html>

<html>

<head>
    <title> List Projects </title>
</head>

<body>

    <div id="container">
        <div id="content">

        <input type="button" value="Add Project"
                onclick="window.location.href='showFormForAdd'; return false;"
        />

        <table>
        <tr>
        <th>Name</th>
        <th>Action</th>
        </tr>

        <c:forEach var="tempProject" items="${projects}">

        <c:url var="updateLink" value="/projects/showFormForUpdate">
            <c:param name="project_id" value="${tempProject.id}" />
        </c:url>

        <!-- construct an "delete" link with project id -->
        <c:url var="deleteLink" value="/projects/delete">
        	<c:param name="project_id" value="${tempProject.id}" />
        </c:url>

            <tr>
                <td> <c:out value="${tempProject.name}" /></td>
                <td> <a href="${updateLink}"> Update</a>
                |
                <a href="${deleteLink}"
                onclick="if (!(confirm('Are you sure you want to delete this project?'))) return false">Delete</a>
            </tr>

        </c:forEach>
        </table>

        </div>
    </div>
</body>
</html>
