<style>
    .footer {
        background-color: #04AA6D;
        padding: 20px;
        color: white;
        text-align: center;
    }

    .footer h3{
        color:#000;
        font-weight: bold;
    }

    .footer img{
        width:35px;
        margin-right:15px;
    }

    .footer .text{
        color:#000;
    }

    .footer-columns {
        display: flex;
        flex-wrap: wrap;
        justify-content: space-between;
    }

    .column {
        flex: 1;
        text-align: left;
        margin: 10px;
    }

    .newsletter {
        text-align: center;
        display: flex;
        flex-direction: column;
        align-items:stretch;
    }

    .newsletter p {
        margin-bottom: 5px;
    }

    .newsletter input[type="email"] {
        padding: 8px;
        width: 70%;
        margin-right:0;
        border: 1px solid #ccc;
        box-sizing: border-box;
    }

    .newsletter hr{
        width:200px;
        margin:auto;
        height:3px;
    }



    .newsletter button {
        padding: 8px;
        background-color: #333;
        color: white;
        border: none;
        cursor: pointer;
        width: 200px;
    }

    .newsletter ul li {
        list-style-type: none;
        color:#000;
    }

    .newsletter ul li a{
        color:#000;
        margin-bottom: 10px;
        text-decoration: none;
    }

    .social-icons {
        display: flex;
        flex-direction: column;
        align-items: flex-end;
    }

    .social-icons img {
        width: 30px;
        margin: 5px 0;
    }
    hr{
        color:black;
        height:2px;
    }

    .social-icons img{
        margin-bottom: 20px;
        margin-right: 28px;
    }

    .bottom-line{
        display: flex;
        justify-content: space-between;
    }

    .bottom-line p{
        color:#000;
    }

    .bottom-line ul li{
        list-style-type: none;
        display: inline;
        margin: 10px;
        color:#000;
    }

  



</style> 

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-C6RzsynM9kWDrMNeT87bh95OGNyZPhcTNXj1NW7RuBCsyN/o0jlpcV8Qyq46cDfL"
crossorigin="anonymous"></script>

<div class="footer">
    <div class="footer-columns">
        <div class="column">
            <h3>Contact Details</h3>
            <div style="margin-top:40px">
                <p><img src="static/images/phone.png" alt="mobile"> <span class="text">+94 72 080 6890</span> </p>
                <p><img src="static/images/email.png" alt="email"> <span class="text">GreenSupermarket@gmail.com</span> </p>
                <p><img src="static/images/address.png" alt="Instagram"> <span class="text">235/2E rathamaldeniya rd, pannipitiya</span> </p>
            </div>
        </div>

        <div class="column newsletter">
            <h3>Newsletter</h3>
            <div style="display:flex">
                <input type="email" placeholder="Your Email">
                <button>Subscribe</button>
            </div>
            <hr class="mt-4">
            <ul>
                <li class="mb-3"> <a href="HomeController">Home</a> </li>
                <li class="mb-3"> <a href="HomeController">Products</a> </li>
                <li class="mb-3"> <a href="about.jsp">About Us</a> </li>
                <li class="mb-3"> <a href="contact.jsp">Contact Us</a> </li>
            </ul>
        </div>

        <div class="column social-icons">
            <h3 style="margin-bottom: 30px;">Follow</h3>
            <img src="static/images/insta.png" alt="Instagram">
            <img src="static/images/Twitter.png" alt="Twitter">
            <img src="static/images/fb.png" alt="Facebook">
            <img src="static/images/link.png" alt="LinkedIn">
        </div>
    </div>
    <hr>
    <div class="bottom-line">
        <p>© 2023  Green Supermarket All Rights Reserved</p>
        <ul>
            <li > <a>Privacy Policy</a> </li>
            <li> <a>Terms of Use</a> </li>
            <li > <a>Sales and Refunds</a> </li>
            <li > <a>Legal</a> </li>
            <li > <a>Location</a> </li>
        </ul>
    </div>
</div>