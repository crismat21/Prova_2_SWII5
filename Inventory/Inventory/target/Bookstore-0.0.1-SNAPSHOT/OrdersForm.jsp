<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Orders</title>
</head>
<body>
    <center>
        <h1>Orders Management</h1>
        <h2>
            <a href="/newsalesman">Add New Order</a>
            &nbsp;&nbsp;&nbsp;
            <a href="/listsalesman">List All Orders</a>
             
        </h2>
    </center>
    <div align="center">
        <c:if test="${orders != null}">
            <form action="update" method="post">
        </c:if>
        <c:if test="${orders == null}">
            <form action="insert" method="post">
        </c:if>
        <table border="1" cellpadding="5">
            <caption>
                <h2>
                    <c:if test="${orders != null}">
                        Edit Order
                    </c:if>
                    <c:if test="${orders == null}">
                        Add New Order
                    </c:if>
                </h2>
            </caption>
                <c:if test="${orders != null}">
                    <input type="hidden" name="id" value="<c:out value='${orders.num}' />" />
                </c:if>           
            <tr>
                <th>Purchase Amount: </th>
                <td>
                    <input type="text" name="title" size="45"
                            value="<c:out value='${orders.purch_amt}' />"
                        />
                </td>
            </tr>
            <tr>
                <th>Date: </th>
                <td>
                    <input type="date" name="author" size="45"
                            value="<c:out value='${orders.date}' />"
                    />
                </td>
            </tr>
            <tr>
                <th>Customer ID: </th>
                <td>
                    <input type="text" name="price" size="5"
                            value="<c:out value='${orders.customer_id}' />"
                    />
                </td>
            </tr>
            <tr>
                <th>Salesman ID: </th>
                <td>
                    <input type="text" name="price" size="5"
                            value="<c:out value='${orders.salesman_id}' />"
                    />
                </td>
            </tr>
            <tr>
                <td colspan="2" align="center">
                    <input type="submit" value="Save" />
                </td>
            </tr>
        </table>
        </form>
    </div>   
</body>
</html>