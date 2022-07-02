<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Salesman Management</title>
</head>
<body>

	<div align="center">
		<h2>Salesmen List</h2>
        <h3>
            <a href="newSalesman">Add New Salesman</a>
        </h3>
	</div>

    <div align="center">
        <table border="1" cellpadding="5">
            <tr>
                <th>ID</th>
                <th>Name</th>
                <th>City</th>
                <th>Commission</th>
            </tr>
            <c:forEach var="salesman" items="${listSalesman}">
                <tr>
                    <td><c:out value="${salesman.id}" /></td>
                    <td><c:out value="${salesman.name}" /></td>
                    <td><c:out value="${salesman.city}" /></td>
                    <td><c:out value="${salesman.commission}" /></td>
                    <td>
                        <a href="editSalesman?id=<c:out value='${salesman.id}' />">Edit</a>
                        &nbsp;&nbsp;&nbsp;&nbsp;
                        <a href="deleteSalesman?id=<c:out value='${salesman.id}' />">Delete</a>                     
                    </td>
                </tr>
            </c:forEach>
        </table>
    </div>
     
    <div align="center">
    	<h3><a href=Welcome.jsp>Back</a></h3>
    </div>
       
</body>
</html>