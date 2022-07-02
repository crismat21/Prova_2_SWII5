<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Customers Management</title>
</head>
<body>

	<div align="center">
		<h2>Customers List</h2>
        <h3>
            <a href="newCustomer">Add New Customer</a>
        </h3>
	</div>

    <div align="center">
        <table border="1" cellpadding="5">
            <tr>
                <th>ID</th>
                <th>Name</th>
                <th>City</th>
                <th>Grade</th>
                <th>Salesman ID</th>
            </tr>
            <c:forEach var="customer" items="${listCustomer}">
                <tr>
                    <td><c:out value="${customer.id}" /></td>
                    <td><c:out value="${customer.name}" /></td>
                    <td><c:out value="${customer.city}" /></td>
                    <td><c:out value="${customer.grade}" /></td>
                    <td><c:out value="${customer.salesman_id}" /></td>
                    <td>
                        <a href="editCustomer?id=<c:out value='${customer.id}' />">Edit</a>
                        &nbsp;&nbsp;&nbsp;&nbsp;
                        <a href="deleteCustomer?id=<c:out value='${customer.id}' />">Delete</a>                     
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