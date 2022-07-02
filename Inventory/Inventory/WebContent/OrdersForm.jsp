<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Order</title>
</head>
<body>
    <div align="center">
        <c:if test="${orders != null}">
            <form action="updateOrders" method="post">
        </c:if>
        <c:if test="${orders == null}">
            <form action="insertOrders" method="post">
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
                    <input type="hidden" name="ord_no" value="<c:out value='${orders.ord_no}' />" />
                </c:if>           
            <tr>
                <th>Purchase Amount: </th>
                <td>
                    <input type="number" name="purch_amt" size="45" min="1" max="99999999" step=".01"
                            value="<c:out value='${orders.purch_amt}' />"
                        />
                </td>
            </tr>
            <tr>
                <th>Date: </th>
                <td>
                    <input type="date" name="ord_date" size="45"
                            value="<c:out value='${orders.ord_date}' />"
                    />
                </td>
            </tr>
            <tr>
                <th>Customer ID: </th>
                <td>
                    <input type="number" name="customer_id" size="5" min="1" max="99999"
                            value="<c:out value='${orders.customer_id}' />"
                    />
                </td>
            </tr>
            <tr>
                <th>Salesman ID: </th>
                <td>
                    <input type="number" name="salesman_id" size="5" min="1" max="99999"
                            value="<c:out value='${orders.salesman_id}' />"
                    />
                </td>
            </tr>
            <tr>
                <td colspan="2" align="center">
                    <input type="submit" value="Save" />
                    <input type="reset" value="Clear" />
                    <a href="listOrders">Cancel</a>
                </td>
            </tr>
        </table>
        </form>
    </div>   
</body>
</html>