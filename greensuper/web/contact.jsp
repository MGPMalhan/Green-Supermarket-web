<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>  
<!DOCTYPE html>
<html>
    <head>
        <title>Contact us</title>
        <c:import url="includes/header.jsp" />
    </head>
    <body>
        <c:import url="includes/navbar.jsp" />
        <c:import url="includes/middlenav.jsp" />

        <div class="col-md-12 contact" style="background-color: #e9f5a9" >
            <div class="container">
                <div class="row ms-0 me-0">
                    <div class="col-md-8" >
                        <div style="margin: 0;
                             position: absolute;
                             top: 40%;
                             -ms-transform: translateY(-50%);
                             transform: translateY(-50%);">
                            <h1 style="font-size: 45px;font-weight: bolder">Contact Us</h1>
                            <p style="font-size:20px;margin-bottom: 5px">Need to get in touch with us? Either fill out the form</p>
                            <p style="font-size:20px;margin-bottom: 5px">with your inquiry or find the Department email you'd</p>
                            <p style="font-size:20px;margin-bottom: 5px">like to contact below</p>
                        </div>
                    </div>
                    <div class="col-md-4">

                        <form action="UserContact" method="post" style="background-color: #fff;padding: 40px;margin-top:20px;margin-bottom:20px;border-radius: 15px;box-shadow: rgba(99, 99, 99, 0.2) 0px 2px 8px 0px;">

                            <div class="col-sm-12">
                                <div class="row">
                                    <div class="col-sm-6">
                                        <label>First Name</label>
                                        <input type="text" name="firstName" style="background-color: lightgray" required />
                                    </div>
                                    <div class="col-sm-6">
                                        <label>Last Name</label>
                                        <input type="text" name="lastName" style="background-color: lightgray" required />
                                    </div>
                                </div>
                            </div>
                            <div>
                                <label>Email</label>
                                <input type="text" name="email" style="background-color: lightgray" required />
                            </div>

                            <div>
                                <label>What can we help you with ?</label>
                                <textarea rows="4" style="background-color: lightgray" name="message" required></textarea>
                            </div>

                            <c:if test="${ not empty requestScope.success }">
                                <div class="alert alert-success" role="alert">
                                    <c:out value="${ requestScope.success }" />
                                </div>
                            </c:if>

                            <c:if test="${ not empty requestScope.error }">
                                <div class="alert alert-danger" role="alert">
                                    <c:out value="${ requestScope.error }" />
                                </div>
                            </c:if>


                            <input type="submit" name="submit" value="Submit" />
                        </form>

                    </div>
                </div>
            </div>
        </div>


    </div>


    <c:import url="includes/footer.jsp" />
</body>
</html>
