<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>  
<!DOCTYPE html>
<html>
    <head>
        <title>My Orders</title>
        <c:import url="../../includes/header.jsp" />
    </head>
    <body>
        <c:import url="../../includes/navbar.jsp" />
        <c:import url="../../includes/middlenav.jsp" />

        <div class="container">
            <h2 class="mt-3 mb-3">My Orders</h2>

            <table class="table table-striped-columns">
                <thead>
                    <tr>
                        <th>#</th>
                        <th>Date</th>
                        <th>Total</th>
                        <th>Status</th>
                        <th>Action</th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach items="${ requestScope.myOrders }" var="order">
                        <tr>
                            <td><c:out value="${ order.getOrderId() }" /></td>
                            <td><c:out value="${ order.getDate() }" /></td>
                            <td><c:out value="${ order.getTotal() }" /></td>
                            <td><c:out value="${ order.getStatus() }" /></td>
                            <td>

                                <c:choose>
                                    <c:when test="${ order.getStatus().equals('Cancelled') }">
                                        <a style="cursor:default" class="btn btn-secondary">Cancelled</a>
                                    </c:when>
                                    <c:otherwise>
                                        <a style="cursor:pointer" href="CancelOrder?orderId=<c:out value="${ order.getOrderId() }" />" class="btn btn-danger">Cancel</a>
                                    </c:otherwise>
                                </c:choose>
                            
                            </td>
                        </tr>
                    </c:forEach>
                </tbody>

            </table>

        </div>


    </div>


    <c:import url="../../includes/footer.jsp" />
</body>
</html>
