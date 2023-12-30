<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>  
<!DOCTYPE html>
<html>
    <head>
        <title>About us</title>
        <c:import url="includes/header.jsp" />
    </head>
    <body>
        <c:import url="includes/navbar.jsp" />
        <c:import url="includes/middlenav.jsp" />

        <section class="px-5 py-6 py-xxl-10 hcf-bp-center hcf-bs-cover hcf-overlay hcf-transform about"
                 style="background-image: url('static/images/about.png');">
            <div class="container">
                <div class="row justify-content-md-center middle-box">
                    <div class="col-12 col-md-11 col-lg-9 col-xl-7 col-xxl-6 text-center text-white">
                        <h3 class="display-3 fw-bold mb-3">About us</h3>
                        <p class="lead mb-5">"Discover Green Supermarket, your destination for conscious living and everyday convenience. Embracing sustainability at its core, we bring you a thoughtfully curated range of organic, eco-friendly products that blend quality, wellness, and environmental stewardship. Our commitment extends beyond just providing wholesome goods; we foster a community-driven space that champions local growers and ethical brands. Join us in embracing a greener lifestyle and explore a world where your choices make a positive impact on both your health and our planet."</p>
                    </div>
                </div>
            </div>
        </section>
        
        <c:import url="includes/mission-vision.jsp" />
        
    </div>


    <c:import url="includes/footer.jsp" />
</body>
</html>
