<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Admin Login</title>
        <c:import url="includes/header.jsp" />

    </head>
    <body>
        <div class="container h-100 col-md-4">
            <div class="row h-100 justify-content-center align-items-center">
                <form class="col-12" action="AdminLogin" method="POST">
                    <h2>Admin Login</h2>
                    <c:if test="${ not empty requestScope.error }">
                        <div class="alert alert-danger" role="alert">
                            <c:out value="${requestScope.error}" />
                        </div>
                    </c:if>

                    <div class="form-group mb-3">
                        <label for="formGroupExampleInput">Username</label>
                        <input type="text" class="form-control" name="username" id="formGroupExampleInput" placeholder="Username" required>
                    </div>
                    <div class="form-group mb-3">
                        <label for="formGroupExampleInput2">Password</label>
                        <input type="password" class="form-control" name="password" id="formGroupExampleInput2" placeholder="Password" required="">
                    </div>
                    <div class="form-group mb-3">
                        <input type="submit" name="submit" value="Login" class="btn btn-success" />
                    </div>
                </form>   
            </div>
        </div>
    </body>
</html>
