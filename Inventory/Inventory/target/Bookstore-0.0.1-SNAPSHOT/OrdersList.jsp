<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Inventory - Orders</title>
</head>
<body>

	<div align="center">
		<h1>Orders Management</h1>
        <h2>
            <a href="neworder">Add New Order</a>
            &nbsp;&nbsp;&nbsp;
            <a href="listorder">List All Orders</a>   
        </h2>
	</div>

    <div align="center">
        <table border="1" cellpadding="5">
           <caption><h3>List of Orders</h3></caption>
            <tr>
                <th>Number</th>
                <th>Amount</th>
                <th>Date</th>
                <th>Customer ID</th>
                <th>Salesman ID</th>
            </tr>
            <c:forEach var="salesman" items="${listOrders}">
                <tr>
                    <td><c:out value="${orders.num}" /></td>
                    <td><c:out value="${orders.purch_amt}" /></td>
                    <td><c:out value="${orders.date}" /></td>
                    <td><c:out value="${orders.customer_id}" /></td>
                    <td><c:out value="${orders.salesman_id}" /></td>
                    <td>
                        <a href="edit?id=<c:out value='${orders.num}' />">Edit</a>
                        &nbsp;&nbsp;&nbsp;&nbsp;
                        <a href="delete?id=<c:out value='${orders.num}' />">Delete</a>                     
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