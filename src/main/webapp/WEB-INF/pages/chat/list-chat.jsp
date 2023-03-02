<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page isELIgnored="false" %>

<!DOCTYPE html>

<html>

<head>
    <title> List Chats </title>
</head>

<body>

    <div id="container">
        <div id="content">

        <input type="button" value="Add Chat"
                onclick="window.location.href='showFormForAdd'; return false;"
        />

        <table>
        <tr>
        <th>Name</th>
        <th>Action</th>
        </tr>

        <c:forEach var="tempChat" items="${chats}">

        <c:url var="updateLink" value="/chats/showFormForUpdate">
            <c:param name="chat_id" value="${tempChat.id}" />
        </c:url>

        <!-- construct an "delete" link with customer id -->
        <c:url var="deleteLink" value="/chats/delete">
        	<c:param name="chat_id" value="${tempChat.id}" />
        </c:url>

            <tr>
                <td> <c:out value="${tempChat.name}" /></td>
                <td> <a href="${updateLink}"> Update</a>
                |
                <a href="${deleteLink}"
                onclick="if (!(confirm('Are you sure you want to delete this chat?'))) return false">Delete</a>
            </tr>

        </c:forEach>
        </table>

        </div>
    </div>
</body>
</html>
