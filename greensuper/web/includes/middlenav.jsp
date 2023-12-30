<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page session="true" %>

<style>
    .hidden{
        display: none;
    }
</style>

<div class="second-nav">

    <ul>
        <li> <a href="HomeController">Home</a> </li>
        <li> <a href="HomeController">Products</a> </li>
        <li> <a href="about.jsp">About us</a> </li>
        <li> <a href="contact.jsp">Contact us</a> </li>
        <li>  
            <button type="button" class="btn btn-link" data-bs-toggle="modal" data-bs-target="#exampleModal">
                <i class="fa fa-shopping-cart" style="color:#fff"> <span id="qty"><c:out value="${ sessionScope.cart.size() == null ? 0 : sessionScope.cart.size() }" /></span> </i>
            </button>
        </li>

        <c:set var="user" value="${sessionScope.user}" />
        <c:if test="${ not empty user }">
            <li>
                <a href="Logout">Logout</a>
            </li>
        </c:if>

    </ul>

</div>

<div class="modal fade" id="exampleModal" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
    <div class="modal-dialog modal-dialog-centered modal-xl">
        <div class="modal-content">

            <div class="modal-body">
                <div class="container">
                    <div class="row">
                        <div class="col-sm-8">
                            <form name="checkoutForm" action="PlaceOrder" method="POST">
                                <div class="personal_info p-4 mb-3" style="background: #f2f2f2;border-radius:15px">
                                    <h5>Personal information</h5>
                                    <hr>
                                    <div class="form-group">
                                        <input type="text" name="name" placeholder="Your Name" required />
                                    </div>
                                    <div class="row">
                                        <div class="col-sm-6">
                                            <div class="form-group">
                                                <input type="text" name="email" placeholder="Email" required />
                                            </div>
                                        </div>
                                        <div class="col-sm-6">
                                            <div class="form-group">
                                                <input type="text" name="phone" placeholder="Phone Number" required  />
                                            </div>
                                        </div>
                                    </div>
                                </div>
                                <div class="personal_info p-4 mb-3" style="background: #f2f2f2;border-radius:15px">
                                    <h5>Shipping Address</h5>
                                    <hr>

                                    <div class="row">
                                        <div class="col-sm-6">
                                            <div class="form-group">
                                                <input type="text" name="address" placeholder="Address" required />
                                            </div>
                                        </div>
                                        <div class="col-sm-6">
                                            <div class="form-group">
                                                <input type="text" name="postalCode" placeholder="Postal Code" required />
                                            </div>
                                        </div>
                                    </div>
                                    <div class="row">
                                        <div class="col-sm-6">
                                            <div class="form-group">
                                                <input type="text" name="city" placeholder="City" required />
                                            </div>
                                        </div>
                                        <div class="col-sm-6">
                                            <div class="form-group">
                                                <input type="text" name="province" placeholder="Province" required />
                                            </div>
                                        </div>
                                    </div>
                                </div>
                                <div class="personal_info p-4 mb-3" style="background: #f2f2f2;border-radius:15px">
                                    <h5>Payment methods</h5>
                                    <hr>
                                    <div class="form-check form-check-inline mb-3">
                                        <input class="form-check-input" type="radio" name="payMethod" id="pay1" value="cod">
                                        <label class="form-check-label" for="inlineRadio1">Cash On Delivery</label>
                                    </div>
                                    <div class="form-check form-check-inline mb-3">
                                        <input class="form-check-input" type="radio" name="payMethod" id="pay2" value="card">
                                        <label class="form-check-label" for="inlineRadio2">Credit or Debit or Paypal</label>
                                    </div>
                                    <div id="pay_form_cod" class="hidden">
                                        <div class="form-group">
                                            <div class="alert alert-light" role="alert">
                                                You can get your order right at your doorstep
                                            </div>
                                        </div>
                                    </div>
                                    <div id="pay_form_card" class="hidden">
                                        <div class="form-group">
                                            <input type="text" name="cardHolderName" placeholder="Cardholder Name"  />
                                        </div>
                                        <div class="form-group">
                                            <input type="text" name="cardNumber" placeholder="Card Number"  />
                                        </div>
                                        <div class="row">
                                            <div class="col-sm-6">
                                                <div class="form-group">
                                                    <input type="text" name="name" placeholder="EXP Date"  />
                                                </div>
                                            </div>
                                            <div class="col-sm-6">
                                                <div class="form-group">
                                                    <input type="text" name="name" placeholder="CVC"  />
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                    <input class="placeOrderBtn hidden" style="border:none;background-color: #333;border-radius: 25px;color:#fff;width:100%;padding:10px" type="submit" name="Order place" value="Place order" />
                                </div>

                            </form>
                        </div>
                        <div class="col-sm-4">
                            <form action="AuthorizePayment" method="POST">
                                <div class="cart p-4" style="background: #f2f2f2;border-radius:15px">
                                    <h5>Item(s)</h5>
                                    <hr>
                                    <c:if test="${ empty sessionScope.cart }">
                                        <p>No products in the cart</p>
                                    </c:if>
                                    <c:forEach items="${ sessionScope.cart }" var="item">
                                        <div class="row">
                                            <div class="col-sm-4" style="position: relative; display: inline-block;">
                                                <c:set var="uploadPath" value="${pageContext.request.contextPath}/uploads" />
                                                <img src="${uploadPath}/${item.getImage()}" width="90px" alt="alt"/>
                                                <p style="position: absolute; top: 0; right: 0;border-radius:100%;padding-left: 8px;padding-right:8px;background-color: #333;color:#fff"> <c:out value="${ item.getQuantity() }" /> </p>
                                            </div>
                                            <div class="col-sm-4">
                                                <p> <b><c:out value="${ item.getName() }" /></b></p>
                                                <a style="text-decoration: none;color:#333" href="RemoveFromCart?productId=<c:out value="${ item.getProductId() }" />"><i class="fa fa-times me-2" aria-hidden="true"></i>Remove</a>
                                            </div>
                                            <c:set var="itemTotal" value="${item.getQuantity() * item.getPrice()}" />
                                            <c:set var="subTotal" value="${subTotal + itemTotal}" />
                                            <div class="col-sm-4">
                                                <p class="" style="font-weight: bold">Rs <c:out value="${ item.getQuantity() * item.getPrice() }0" /></p>
                                            </div>
                                        </div>
                                    </c:forEach>
                                    <hr>
                                    <div class="d-flex justify-content-between">
                                        <div class="">
                                            <p>Subtotal</p>
                                        </div>
                                        <div class="">
                                            <p style="font-weight: bold">LKR <c:out value="${ subTotal }0" /></p>
                                        </div>

                                    </div>
                                    <div class="d-flex justify-content-between">
                                        <div class="">
                                            <p>Discount</p>
                                        </div>
                                        <div class="">
                                            <p style="font-weight: bold">LKR 0.00</p>
                                        </div>

                                    </div>
                                    <hr>
                                    <div class="d-flex justify-content-between">
                                        <div class="">
                                            <p style="font-weight: bold">Total</p>
                                        </div>
                                        <div class="">
                                            <p style="font-weight: bold">LKR <c:out value="${ subTotal }" />0</p>
                                        </div>

                                    </div>

                                    <c:if test="${ not empty sessionScope.cart }">
                                        <input class="checkoutBtn hidden" style="border:none;background-color: #333;border-radius: 25px;color:#fff;width:100%;padding:10px" type="submit" value="checkout" />
                                    </c:if>

                                </div>
                            </form>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
<script>
    var rad = document.checkoutForm.payMethod;
    var codForm = document.getElementById("pay_form_cod");
    var cardForm = document.getElementById("pay_form_card");
    var checkoutBtn = document.querySelector(".checkoutBtn");
    var placeOrderBtn = document.querySelector(".placeOrderBtn");
    var prev = null;
    for (var i = 0; i < rad.length; i++) {
        rad[i].addEventListener('change', function () {
            if (this !== prev) {
                prev = this;
            }
            if (this.value === "cod") {
                codForm.classList.remove("hidden");
                cardForm.classList.add("hidden");
                checkoutBtn.classList.add("hidden");
                placeOrderBtn.classList.remove("hidden");
            } else if (this.value === "card") {
                codForm.classList.add("hidden");
                cardForm.classList.remove("hidden");
                checkoutBtn.classList.remove("hidden");
                placeOrderBtn.classList.remove("hidden");
            }
        });
    }
</script>