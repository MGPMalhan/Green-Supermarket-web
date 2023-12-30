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

        <section class="px-5 py-6 py-xxl-10 hcf-bp-center hcf-bs-cover hcf-overlay hcf-transform hero"
                 style="background-image: url('static/images/img1.png');">
            <div class="container">
                <div class="row justify-content-md-center middle-box">
                    <div class="col-12 col-md-11 col-lg-9 col-xl-7 col-xxl-6 text-center text-white">
                        <h3 class="display-3 fw-bold mb-3">Organic Food</h3>
                        <h1 class="display-3 fw-bold mb-3">Looking For</h1>
                        <h1 class="display-3 fw-bold mb-3">Fresh Organic Food?</h1>
                        <p class="lead mb-5">You have come to the right place</p>
                        <a class="shop_now">Shop Now</a>
                    </div>
                </div>
            </div>
        </section>


        <c:import url="includes/shop-by-category.jsp" />

        <c:import url="includes/services.jsp" />

        <c:import url="includes/testimonial.jsp" />

        <c:import url="includes/footer.jsp" />
    </body>
</html>
