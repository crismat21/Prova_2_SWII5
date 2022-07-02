<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Inventory - Customers</title>
</head>
<body>

	<div align="center">
		<h1>Customers Management</h1>
        <h2>
            <a href="newcustomer">Add New Customer</a>
            &nbsp;&nbsp;&nbsp;
            <a href="listcustomer">List All Customers</a>   
        </h2>
	</div>

    <div align="center">
        <table border="1" cellpadding="5">
           <caption><h3>List of Customers</h3></caption>
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
                        <a href="edit?id=<c:out value='${customer.id}' />">Edit</a>
                        &nbsp;&nbsp;&nbsp;&nbsp;
                        <a href="delete?id=<c:out value='${customer.id}' />">Delete</a>                     
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