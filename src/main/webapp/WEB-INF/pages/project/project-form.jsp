<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page isELIgnored="false" %>

<!DOCTYPE html>

<html>

<head>
</head>

<body>

    <div id="container">
        <h3>Save Project </h3>

        <form:form action="saveProject" modelAttribute="project" method="POST">

        			<!-- need to associate this data with customer id -->
        			<form:hidden path="id" />

        			<table>
        				<tbody>
        					<tr>
        						<td><label>First name:</label></td>
        						<td><form:input path="name" /></td>
        					</tr>

        					<tr>
        						<td><label></label></td>
        						<td><input type="submit" value="Save" class="save" /></td>
        					</tr>


        				</tbody>
        			</table>


        		</form:form>

    </div>
</body>
</html>
