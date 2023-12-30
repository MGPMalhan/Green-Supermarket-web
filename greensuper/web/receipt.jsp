<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>  
<!DOCTYPE html>
<html>
    <head>
        <title>Home</title>
        <c:import url="includes/header.jsp" />
    </head>
    <body>
        <c:import url="includes/navbar.jsp" />
        <c:import url="includes/middlenav.jsp" />


        <div class="container" style="margin-top:20px;margin-bottom: 20px">
            <div class="alert alert-success" role="alert">
                Payment is successful! 
            </div>
            <table class="table table-striped-columns">
                <tr>
                    <td><b>Merchant:</b></td>
                    <td>Company ABC Ltd.</td>
                </tr>
                <tr>
                    <td><b>Transaction Id:</b></td>
                    <td>${requestScope.orderId}</td>      
                </tr>
                <tr>
                    <td><b>Date:</b></td>
                    <td>${requestScope.date}</td>      
                </tr>
                <tr>
                    <td><b>Time:</b></td>
                    <td>${requestScope.time}</td>      
                </tr>
                <tr>
                    <td><b>Payer:</b></td>
                    <td>${payer.firstName} ${payer.lastName}</td>      
                </tr>
                <tr>
                    <td><b>Description:</b></td>
                    <td>${transaction.description}</td>
                </tr>
                <tr>
                    <td><b>Subtotal:</b></td>
                    <td>${transaction.amount.details.subtotal} LKR</td>
                </tr>
                <tr>
                    <td><b>Shipping:</b></td>
                    <td>${transaction.amount.details.shipping} LKR</td>
                </tr>
                <tr>
                    <td><b>Tax:</b></td>
                    <td>${transaction.amount.details.tax} LKR</td>
                </tr>
                <tr>
                    <td><b>Total:</b></td>
                    <td>${transaction.amount.total} LKR</td>
                </tr>                    
            </table>
        </div>

        <c:import url="includes/footer.jsp" />
    </body>
</html>
