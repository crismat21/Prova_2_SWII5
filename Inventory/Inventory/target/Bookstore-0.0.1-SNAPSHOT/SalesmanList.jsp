<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Inventory - Salesman</title>
</head>
<body>

	<div align="center">
		<h1>Salesmen Management</h1>
        <h2>
            <a href="newsalesman">Add New Salesman</a>
            &nbsp;&nbsp;&nbsp;
            <a href="listsalesman">List All Salesmen</a>   
        </h2>
	</div>

    <div align="center">
        <table border="1" cellpadding="5">
           <caption><h3>List of Salesmen</h3></caption>
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
                        <a href="edit?id=<c:out value='${salesman.id}' />">Edit</a>
                        &nbsp;&nbsp;&nbsp;&nbsp;
                        <a href="delete?id=<c:out value='${salesman.id}' />">Delete</a>                     
                    </td>
                </tr>
            </c:forEach>
        </table>
    </div>
    
    <div align="center">
    	<h1>-----------</h1>
    </div>
    
    <div align="center">
    	<h2><a href=Welcome.jsp>Back</a></h2>
    </div>
       
</body>
</html>