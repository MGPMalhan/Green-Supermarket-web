<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>  
<!DOCTYPE html>
<html>
    <head>
        <title>Login and Register</title>
        <c:import url="includes/header.jsp" />
    </head>
    <body>
        <c:import url="includes/navbar.jsp" />
        <c:import url="includes/middlenav.jsp" />

        <div class="col-md-12 auth" >
            <div class="row ms-0 me-0">
                <div class="col-md-8 ps-0 pe-0" >
                    <section class="px-5 py-6 py-xxl-10 hcf-bp-center hcf-bs-cover hcf-overlay hcf-transform login_hero"
                             style="background-image: url('static/images/img1.png');">
                        <div class="container">
                            <div class="row justify-content-md-center middle-box">
                                <div class="col-12 col-md-11 col-lg-9 col-xl-7 col-xxl-6 text-center text-white">
                                    <form action="UserLogin" method="post">
                                        <h2>Login To Your Account</h2>
                                        <p>All the Groceries right under your fingertips</p>

                                        <c:forEach items="${requestScope.loginErrors}" var="error" >
                                            <p class="error"><c:out value="${error}" /></p>
                                        </c:forEach>

                                        <c:if test="${ not empty requestScope.InvalidCred }">
                                            <p class="error"><c:out value="${requestScope.InvalidCred}" /></p>
                                        </c:if>

                                        <div>
                                            <input type="email" name="email" placeholder="Email" />
                                        </div>
                                        <div>
                                            <input type="password" name="password" placeholder="Password" />
                                        </div>
                                        <a>Forgot Password ?</a>
                                        <div>
                                            <input type="submit" name="submit" value="Login" />
                                        </div>
                                    </form>
                                </div>
                            </div>
                        </div>
                    </section>
                </div>
                <div class="col-md-4 sign_up">

                    <form action="UserRegister" method="post">
                        <h1 class="site_title"> <span>Green</span> Supermarket</h1>
                        <h1>Sign Up</h1>
                        <p>All the Groceries right under your fingertips</p>

                        <c:forEach items="${requestScope.errors}" var="error" >
                            <p class="error"><c:out value="${error}" /></p>
                        </c:forEach>

                        <c:if test="${ not empty requestScope.OK }">
                            <p class="success"><c:out value="${requestScope.OK}" /></p>
                        </c:if>

                        <c:if test="${ not empty requestScope.FAILED }">
                            <p class="error"><c:out value="${requestScope.FAILED}" /></p>
                        </c:if>

                        <c:if test="${ not empty requestScope.BAD }">
                            <p class="error"><c:out value="${requestScope.BAD}" /></p>
                        </c:if>

                        <div>
                            <input type="text" name="full_name" placeholder="Full Name" />
                        </div>
                        <div>
                            <input type="email" name="email" placeholder="Email" />
                        </div>
                        <div>
                            <input type="password" name="password" placeholder="Password" />
                        </div>
                        <div>
                            <input type="password" name="confirm_password" placeholder="Confirm Password" />
                        </div>
                        <div>
                            <input type="submit" name="submit" value="Create Account" />
                        </div>
                    </form>
                </div>
            </div>
        </div>


    </div>


    <c:import url="includes/footer.jsp" />
</body>
</html>
