<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Admin Home</title>
        <c:import url="includes/header.jsp" />
    </head>
    <body class="sb-nav-fixed">
        <c:import url="includes/nav.jsp" />
        <div id="layoutSidenav">
            <div id="layoutSidenav_nav">
                <c:import url="includes/sidenav.jsp" />
            </div>
            <div id="layoutSidenav_content">
                <main>
                    <div class="container-fluid px-4">
                        <h1 class="mt-4">Products</h1>
                        <ol class="breadcrumb mb-4">
                            <a class="btn btn-outline-success" href="AdminNavigation?to=AddProduct">Add</a>
                        </ol>

                        <table class="table table-striped">
                            <thead>
                                <tr>
                                    <th>#</th>
                                    <th>Name</th>
                                    <th>Image</th>
                                    <th>Category</th>
                                    <th>Price</th>
                                    <th>Quantity</th>
                                    <th>Unit</th>
                                    <th>Update</th>
                                    <th>Delete</th>
                                </tr>
                            </thead>
                            <tbody>
                                <c:forEach items="${ requestScope.products }" var="product">
                                    <tr>
                                        <td> <c:out value="${ product.getId() }" /> </td>
                                        <td> <c:out value="${ product.getName() }" /> </td>
                                        <td> 
                                            <c:set var="uploadPath" value="${pageContext.request.contextPath}/uploads" />
                                            <img src="${uploadPath}/${product.getImage()}" width="100px" alt="alt"/>
                                        </td>
                                        <td> <c:out value="${ product.getCategoryName() }" /> </td>
                                        <td> <c:out value="${ product.getPrice() }" /> </td>
                                        <td> <c:out value="${ product.getQuantity() }" /> </td>
                                        <td> <c:out value="${ product.getUnit() }" /> </td>
                                        <td> <a href="AdminNavigation?to=GetById&id=<c:out value="${ product.getId() }" />" class="btn btn-warning" >Update</a> </td>
                                        <td> <a href="DeleteProduct?to=DeleteById&id=<c:out value="${ product.getId() }" />" class="btn btn-danger">Delete</a> </td>
                                    </tr>
                                </c:forEach>
                            </tbody>
                        </table>

                    </div>
                </main>
            </div>
        </div>
    </body>
</html>