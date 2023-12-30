<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page session="true" %>

<div class="mynav">
    <nav class="navbar navbar-expand-lg  bg-body-tertiary">
        <div class="container">
            <a class="navbar-brand" href="HomeController"> <span class="title">Green</span> Supermarket</a>
            <button class="navbar-toggler" type="button" data-bs-toggle="collapse"
                    data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent"
                    aria-expanded="false" aria-label="Toggle navigation">
                <span class="navbar-toggler-icon"></span>
            </button>

            <div class="collapse navbar-collapse" id="navbarSupportedContent">
                <ul class="navbar-nav me-auto mb-2 mb-lg-0">
                    <form action="SearchProduct" method="post" class="search">
                        <input type="text" name="query" class="searchTerm" placeholder="Search product" required>
                        <button style="background-color:#04AA6D" type="submit" class="searchButton">
                            <i class="fa fa-search"></i>
                        </button>
                    </form>
                </ul>

                <c:set var="user" value="${sessionScope.user}" />

                <div class="links">
                    <c:if test="${ not empty user }">
                        <a href="MyOrders" class="logged_user"> 
                            <i class="fa fa-user me-2" aria-hidden="true"></i> ${user.getFullName().split(' ')[0]} ${user.getFullName().split(' ')[1].charAt(0)} 
                        </a>
                    </c:if>
                    <c:if test="${ empty user }">
                        <a class="login" href="login.jsp">Login</a>
                        <a class="register" href="login.jsp">Create Account</a>
                    </c:if>


                </div>
            </div>
        </div>
    </nav>
</div>
