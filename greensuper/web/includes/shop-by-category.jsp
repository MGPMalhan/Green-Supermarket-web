<!--<div style="padding-left: 200px;padding-right: 200px;">

    <div class="cat-section mt-4">
        <h3 class="mb-4" style="font-weight: bolder;">Shop By Categories</h3>
        <div class="wrapper">
            <div class="card category">
                <img class="card-img-top" src="static/images/rice.png" alt="Card image cap">
                <div class="card-block">
                    <h4 class="card-title">Food</h4>
                    <p class="card-text">200 items</p>
                    <a href="ProductsByCategory?id=1&category=Food" class="btn btn-primary">Shop Now</a>
                </div>
            </div>
            <div class="card category">
                <img class="card-img-top" src="static/images/boom.png" alt="Card image cap" style="margin-top:50px">
                <div class="card-block">
                    <h4 class="card-title">Non Food</h4>
                    <p class="card-text">200 items</p>
                    <a href="ProductsByCategory?id=2&category=Non Food" class="btn btn-primary">Shop Now</a>
                </div>
            </div>
            <div class="card category">
                <img class="card-img-top" src="static/images/frozen.png" alt="Card image cap" style="margin-top:50px"> 
                <div class="card-block">
                    <h4 class="card-title">Frozen Food</h4>
                    <p class="card-text">200 items</p>
                    <a href="ProductsByCategory?id=3&category=Frozen Food" class="btn btn-primary">Shop Now</a>
                </div>
            </div>
            <div class="card category">
                <img class="card-img-top" src="static/images/fruits.png" alt="Card image cap" style="margin-top:50px">
                <div class="card-block">
                    <h4 class="card-title">Fruits/Vegetables</h4>
                    <p class="card-text">200 items</p>
                    <a href="ProductsByCategory?id=4&category=Fruits/Vegetables" class="btn btn-primary">Shop Now</a>
                </div>
            </div>
            <div class="card category">
                <img class="card-img-top" src="static/images/alcohol.png" alt="Card image cap" style="margin-top:50px">
                <div class="card-block">
                    <h4 class="card-title">Alchohol</h4>
                    <p class="card-text">200 items</p>
                    <a href="ProductsByCategory?id=5&category=Alcohol" class="btn btn-primary">Shop Now</a>
                </div>
            </div>


        </div>
    </div>

</div>-->
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>  
<style>

    .wrapper{
        margin-top: 35px;
        margin-bottom: 35px;
    }

    .category{
        border-top-right-radius: 25px;
        border-bottom-left-radius: 25px;
        /*padding:16px;*/
        text-align: center;
        background-color: #fff;
        box-shadow: rgba(100, 100, 111, 0.2) 0px 7px 29px 0px;
        /*height:300px;*/
    }

    .category img{
        width: 50%;
        margin-top: 10px;
        display:block;
        margin-left:auto;
        margin-right:auto;
        padding-bottom: 30px;
    }

    .category .card-title{
        font-weight: bolder;
        font-size: 18px;
    }

    .category a{
        background-color: #04AA6D;
        padding: 10px 25px;
        color: #fff;
        border: 1px solid #04AA6D;
        cursor:pointer;
        box-shadow: rgba(0, 0, 0, 0.35) 0px 5px 15px;
        margin-bottom: 20px;
    }
    
    .category .card-text{
        color:red;
    }
    
</style>

<div class="container wrapper">
    <div class="row">
        <div class="col-12">
            <h3 class="mb-4" style="font-weight: bolder;text-align: center;">Shop By Categories</h3>
        </div>
    </div>

    <div class="row justify-content-center">
        <div class="col-12 col-sm-6 col-md-4 col-lg-3 col-xl-2">
            <div class="card category" >
                <img class="card-img-top" src="static/images/rice.png" alt="Card image cap">
                <div class="card-block">
                    <h4 class="card-title">Food</h4>
                    <p class="card-text"><c:out value="${ requestScope.productCounts[0] }" /> items</p>
                    <a href="ProductsByCategory?id=1&category=Food" class="btn btn-primary">Shop Now</a>
                </div>
            </div>
        </div>
        <div class="col-12 col-sm-6 col-md-4 col-lg-3 col-xl-2">
            <div class="card category">
                <img class="card-img-top" src="static/images/boom.png" alt="Card image cap" style="margin-top:30px">
                <div class="card-block">
                    <h4 class="card-title">Non Food</h4>
                    <p class="card-text"><c:out value="${ requestScope.productCounts[1] }" /> items</p>
                    <a href="ProductsByCategory?id=2&category=Non Food" class="btn btn-primary">Shop Now</a>
                </div>
            </div>
        </div>
        <div class="col-12 col-sm-6 col-md-4 col-lg-3 col-xl-2">
            <div class="card category">
                <img class="card-img-top" src="static/images/frozen.png" alt="Card image cap" style="margin-top:35px"> 
                <div class="card-block">
                    <h4 class="card-title">Frozen Food</h4>
                    <p class="card-text"><c:out value="${ requestScope.productCounts[2] }" /> items</p>
                    <a href="ProductsByCategory?id=3&category=Frozen Food" class="btn btn-primary">Shop Now</a>
                </div>
            </div>
        </div>
        <div class="col-12 col-sm-6 col-md-4 col-lg-3 col-xl-2">
            <div class="card category">
                <img class="card-img-top" src="static/images/fruits.png" alt="Card image cap" style="margin-top:40px">
                <div class="card-block">
                    <h4 class="card-title">Fruits/Vegetables</h4>
                    <p class="card-text"><c:out value="${ requestScope.productCounts[3] }" /> items</p>
                    <a href="ProductsByCategory?id=4&category=Fruits/Vegetables" class="btn btn-primary">Shop Now</a>
                </div>
            </div>
        </div>
        <div class="col-12 col-sm-6 col-md-4 col-lg-3 col-xl-2">
            <div class="card category">
                <img class="card-img-top" src="static/images/alcohol.png" alt="Card image cap" style="margin-top:30px">
                <div class="card-block">
                    <h4 class="card-title">Alchohol</h4>
                    <p class="card-text"><c:out value="${ requestScope.productCounts[4] }" /> items</p>
                    <a href="ProductsByCategory?id=5&category=Alcohol" class="btn btn-primary">Shop Now</a>
                </div>
            </div>
        </div>
    </div>
</div>