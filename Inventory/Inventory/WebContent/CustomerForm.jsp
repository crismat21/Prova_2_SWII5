<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Customers</title>
</head>
<body>
    <div align="center">
        <c:if test="${customer != null}">
            <form action="updateCustomer" method="post">
        </c:if>
        <c:if test="${customer == null}">
            <form action="insertCustomer" method="post">
        </c:if>
        <table border="1" cellpadding="5">
            <caption>
                <h2>
                    <c:if test="${customer != null}">
                        Edit Customer
                    </c:if>
                    <c:if test="${customer == null}">
                        Add New Customer
                    </c:if>
                </h2>
            </caption>
                <c:if test="${customer != null}">
                    <input type="hidden" name="id" value="<c:out value='${customer.id}' />" />
                </c:if>           
            <tr>
                <th>Name: </th>
                <td>
                    <input type="text" name="name" size="45"
                            value="<c:out value='${customer.name}' />"
                        />
                </td>
            </tr>
            <tr>
                <th>City: </th>
                <td>
                    <input type="text" name="city" size="45"
                            value="<c:out value='${customer.city}' />"
                    />
                </td>
            </tr>
            <tr>
                <th>Grade: </th>
                <td>
                    <input type="number" name="grade" size="5" min="1" max="999"
                            value="<c:out value='${customer.grade}' />"
                    />
                </td>
            </tr>
            <tr>
                <th>Salesman ID: </th>
                <td>
                    <input type="number" name="salesman_id" size="5" min="1" max="99999"
                            value="<c:out value='${customer.salesman_id}' />"
                    />
                </td>
            </tr>
            <tr>
                <td colspan="2" align="center">
                    <input type="submit" value="Save" />
                    <input type="reset" value="Clear" />
                    <a href="listSalesman">Cancel</a>
                </td>
            </tr>
        </table>
        </form>
    </div>   
</body>
</html>