<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>  
<!DOCTYPE html>
<html>
    <head>
        <title>Home</title>
        <c:import url="includes/header.jsp" />
        <style>
            input[type=submit]{
                background-color: #04AA6D;
                padding: 10px 25px;
                color: #fff;
                border: 1px solid #04AA6D;
                cursor:pointer;
                box-shadow: rgba(0, 0, 0, 0.35) 0px 5px 15px;
            }
        </style>
    </head>
    <body>
        <c:import url="includes/navbar.jsp" />
        <c:import url="includes/middlenav.jsp" />


        <div class="container" style="margin-top:20px;margin-bottom: 20px">
            <form action="execute_payment" method="post">
                <table class="table table-striped-columns">
                    <tr>
                        <td colspan="2"><b>Transaction Details:</b></td>
                        <td>
                            <input type="hidden" name="paymentId" value="${param.paymentId}" />
                            <input type="hidden" name="PayerID" value="${param.PayerID}" />
                        </td>
                    </tr>
                    <tr>
                        <td>Description:</td>
                        <td>${transaction.description}</td>
                    </tr>
                    <tr>
                        <td>Subtotal:</td>
                        <td>${transaction.amount.details.subtotal} USD</td>
                    </tr>
                    <tr>
                        <td>Shipping:</td>
                        <td>${transaction.amount.details.shipping} USD</td>
                    </tr>
                    <tr>
                        <td>Tax:</td>
                        <td>${transaction.amount.details.tax} USD</td>
                    </tr>
                    <tr>
                        <td>Total:</td>
                        <td>${transaction.amount.total} USD</td>
                    </tr>
                    <tr><td><br/></td></tr>
                    <tr>
                        <td colspan="2"><b>Payer Information:</b></td>
                    </tr>
                    <tr>
                        <td>First Name:</td>
                        <td>${payer.firstName}</td>
                    </tr>
                    <tr>
                        <td>Last Name:</td>
                        <td>${payer.lastName}</td>
                    </tr>
                    <tr>
                        <td>Email:</td>
                        <td>${payer.email}</td>
                    </tr>
                    <tr><td><br/></td></tr>
                    <tr>
                        <td colspan="2"><b>Shipping Address:</b></td>
                    </tr>
                    <tr>
                        <td>Recipient Name:</td>
                        <td>${shippingAddress.recipientName}</td>
                    </tr>
                    <tr>
                        <td>Line 1:</td>
                        <td>${shippingAddress.line1}</td>
                    </tr>
                    <tr>
                        <td>City:</td>
                        <td>${shippingAddress.city}</td>
                    </tr>
                    <tr>
                        <td>State:</td>
                        <td>${shippingAddress.state}</td>
                    </tr>
                    <tr>
                        <td>Country Code:</td>
                        <td>${shippingAddress.countryCode}</td>
                    </tr>
                    <tr>
                        <td>Postal Code:</td>
                        <td>${shippingAddress.postalCode}</td>
                    </tr>
                    <tr>
                        <td colspan="2" align="center">
                            <input type="submit" value="Pay Now" />
                        </td>
                    </tr>    
                </table>
            </form>
        </div>

        <c:import url="includes/footer.jsp" />
    </body>
</html>
