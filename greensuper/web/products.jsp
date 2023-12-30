<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>  
<!DOCTYPE html>
<html>
    <head>
        <title>Products by category</title>
        <c:import url="includes/header.jsp" />
    </head>
    <body>
        <c:import url="includes/navbar.jsp" />
        <c:import url="includes/middlenav.jsp" />

        <div class="products-category px-4" >
            <h3 class="text-center m-4">Products</h3>
            <p class="breadcrumb"><a href="HomeController">Home</a> <span class="ms-2 me-2"> > </span> <a><c:out value="${ requestScope.category }" /></a> </p>
            <c:if test="${ not empty requestScope.addQty }">
                <p class="error"><c:out value="${requestScope.addQty}" /></p>
            </c:if>
            <div class="products align-items-center justify-content-center">

                <c:forEach items="${ requestScope.products }" var="product">
                    <div class="card mb-3 card p-4" style="width:100%;border:none;background-color: #f2f2f2">
                        <div class="row g-0">
                            <div class="col-md-4">
                                <c:set var="uploadPath" value="${pageContext.request.contextPath}/uploads" />
                                <img src="${uploadPath}/${product.getImage()}" width="100%" alt="alt"/>
                            </div>
                            <div class="col-md-8">
                                <div class="card-body">
                                    <h5 class="card-title" style="font-weight:bold"> <c:out value="${ product.getName() }" /> </h5>
                                    <p class="card-text" style="font-weight:bold"> Rs <c:out value="${ product.getPrice() }" />0 </p>
                                    <form action="AddToCart" method="POST">
                                        <div>
                                            <input type="hidden" name="productId" value="${ product.getId() }" />
                                            <input type="hidden" name="catId" value="${ param.id }" />
                                            <input type="hidden" name="categoryName" value="${ requestScope.category }" />
                                            <input type="number" name="qty" value="0" style="width:80px" />
                                        </div>
                                        <div>
                                            <input type="submit" name="add to cart" value="Add to cart" />
                                        </div>
                                    </form>
                                </div>
                            </div>
                        </div>
                    </div>
                </c:forEach>

            </div>

        </div>


        <c:import url="includes/footer.jsp" />
    </body>
</html>
