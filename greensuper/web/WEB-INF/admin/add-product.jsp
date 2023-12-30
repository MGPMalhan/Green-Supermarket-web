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
                        <h1 class="mt-4">Add Product</h1>

                        <c:forEach items="${requestScope.errors}" var="error" >
                            <div class="alert alert-danger" role="alert">
                                <c:out value="${error}" />
                            </div>
                        </c:forEach>

                        <c:if test="${ not empty requestScope.success }">
                            <div class="alert alert-success" role="alert">
                                <c:out value="${requestScope.success}" />
                            </div>
                        </c:if>

                        <c:if test="${ not empty requestScope.failed }">
                            <div class="alert alert-danger" role="alert">
                                <c:out value="${requestScope.failed}" />
                            </div>
                        </c:if>

                        <form action="AddProduct" method="post" enctype="multipart/form-data">
                            <div class="form-group mb-3">
                                <label>Name</label>
                                <input type="text" name="name" class="form-control" />
                            </div>
                            <div class="form-group mb-3">
                                <label>Category</label>
                                <select name="category" class="form-control">
                                    <option value="1">Food</option>
                                    <option value="2">Non Food</option>
                                    <option value="3">Frozen Food</option>
                                    <option value="4">Fruits/Vegetables</option>
                                    <option value="5">Alcohol</option>
                                </select>
                            </div>
                            <div class="form-group mb-3">
                                <label>Image</label>
                                <input type="file" name="image" class="form-control" required />
                            </div>
                            <div class="form-group mb-3">
                                <label>Price</label>
                                <input type="text" name="price" class="form-control" />
                            </div>
                            <div class="form-group mb-3">
                                <label>Quantity</label>
                                <input type="text" name="quantity" class="form-control" />
                            </div>
                            <div class="form-group mb-3">
                                <label>Unit</label>
                                <select name="unit" class="form-control" required>

                                    <optgroup label="Food and Non-Food">
                                        <option value="pieces">Pieces</option>
                                        <option value="packets">Packets</option>
                                        <option value="boxes">Boxes</option>
                                        <option value="cartons">Cartons</option>
                                        <option value="cans">Cans</option>
                                        <option value="jars">Jars</option>
                                        <option value="bottles">Bottles</option>
                                        <option value="liters">Liters</option>
                                        <option value="milliliters">Milliliters</option>
                                        <option value="kilograms">Kilograms</option>
                                        <option value="grams">Grams</option>
                                    </optgroup>

                                    <optgroup label="Frozen Foods">
                                        <option value="pieces">Pieces</option>
                                        <option value="boxes">Boxes</option>
                                        <option value="kilograms">Kilograms</option>
                                        <option value="grams">Grams</option>
                                    </optgroup>


                                    <optgroup label="Fruits and Vegetables">
                                        <option value="pieces">Pieces</option>
                                        <option value="kilograms">Kilograms</option>
                                        <option value="grams">Grams</option>
                                    </optgroup>


                                    <optgroup label="Alcohol">
                                        <option value="bottles">Bottles</option>
                                        <option value="liters">Liters</option>
                                        <option value="milliliters">Milliliters</option>
                                    </optgroup>
                                </select>
                            </div>
                            <div class="form-group mb-3">
                                <input type="submit" name="submit" value="Add" class="btn btn-success" />
                            </div>
                        </form>


                    </div>
                </main>
            </div>
        </div>
    </body>
</html>