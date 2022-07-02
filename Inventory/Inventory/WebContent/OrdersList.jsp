<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Orders Management</title>
</head>
<body>

	<div align="center">
		<h2>Orders Management</h2>
        <h3>
            <a href="newOrders">Add New Order</a>
        </h3>
	</div>

    <div align="center">
        <table border="1" cellpadding="5">
            <tr>
                <th>Number</th>
                <th>Amount</th>
                <th>Date</th>
                <th>Customer ID</th>
                <th>Salesman ID</th>
            </tr>
            <c:forEach var="orders" items="${listOrders}">
                <tr>
                    <td><c:out value="${orders.ord_no}" /></td>
                    <td><c:out value="${orders.purch_amt}" /></td>
                    <td><c:out value="${orders.ord_date}" /></td>
                    <td><c:out value="${orders.customer_id}" /></td>
                    <td><c:out value="${orders.salesman_id}" /></td>
                    <td>
                        <a href="editOrders?ord_no=<c:out value='${orders.ord_no}' />">Edit</a>
                        &nbsp;&nbsp;&nbsp;&nbsp;
                        <a href="deleteOrders?ord_no=<c:out value='${orders.ord_no}' />">Delete</a>                     
                    </td>
                </tr>
            </c:forEach>
        </table>
    </div>
    
    <div align="center">
    	<h2><a href=Welcome.jsp>Back</a></h2>
    </div>
       
</body>
</html>