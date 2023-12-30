<style>

    .testimonials
    {
        padding: 40px 0;
        background: #f1f1f1;
        color: #434343;
        text-align: center;
    }
    
    h1{
        font-size: 20px;
        font-weight: bold;
        color:#04AA6D;
        margin-bottom: 0;
    }
    
    #sub-title{
        font-size: 25px;
        font-weight: bold;
        color: #000;
        margin-bottom: 30px;
    }

    .testimonial-inner
    {
        max-width: 1200px;
        margin: auto;
        overflow: hidden;
        padding: 0 20px;
    }

    .border
    {
        width: 160px;
        height: 3px;
        background: #000;
        margin: 4px auto;
    }

    .row
    {
        display: flex;
        flex-wrap: wrap;
        justify-content: center;
    }

    .col
    {
        flex: 33.33%;
        max-width: 33.33%;
        box-sizing:  border-box;
        padding: 15px;
    }

    .testimonial
    {
        background: #fff;
        padding-top: 30px;
        padding-left: 30px;
        padding-right: 30px;
        padding-bottom: 0;
    }

    .testimonial img
    {
        width: 100px;
        height: 100px;
        border-radius: 50%;
    }

    .name
    {
        font-size: 10px;
        font-weight: bold;
        margin: 20px 0;
        
    }

    .stars
    {
        color: #6ab04c;
        margin-bottom: 20px;
        background-color: #333;
        width: 40%;
        margin-left: auto;
        margin-right: auto;
        border-top-left-radius: 10px;
        border-top-right-radius: 10px;
    }

    @media screen and (max-width: 960px)
    {
        .col
        {
            flex: 100%;
            max-width: 80%;
        }
    }
</style>

<div class="testimonials">
    <div class="testimonial-inner">
        <h1>Testimonial</h1>
        <div class="border"></div>
        <h1 id="sub-title">What Our Client Says</h1>
        <div class="row">
            <div class="col">
                <div class="testimonial">
                    <img src="https://images.pexels.com/photos/3211476/pexels-photo-3211476.jpeg?auto=compress&cs=tinysrgb&dpr=2&h=650&w=940" alt="">

                    <p>Lorem ipsum dolor sit amet consectetur adipisicing elit. Eaque repellat aspernatur temporibus assumenda sint odio minima. Voluptate alias possimus aspernatur voluptates excepturi placeat iusto cupiditate.</p>

                    <div class="name">John Waddrob</div>
                    <div class="stars">
                        <i class="fa fa-star" aria-hidden="true"></i>
                        <i class="fa fa-star" aria-hidden="true"></i>
                        <i class="fa fa-star" aria-hidden="true"></i>
                        <i class="fa fa-star" aria-hidden="true"></i>
                        <i class="fa fa-star" aria-hidden="true"></i>
                    </div>
                </div>
            </div>

            <div class="col">
                <div class="testimonial">
                    <img src="https://images.pexels.com/photos/3585325/pexels-photo-3585325.jpeg?auto=compress&cs=tinysrgb&dpr=2&h=650&w=940" alt="">


                    <p>Lorem ipsum dolor sit amet consectetur adipisicing elit. Eaque repellat aspernatur temporibus assumenda sint odio minima. Voluptate alias possimus aspernatur voluptates excepturi placeat iusto cupiditate.</p>

                    <div class="name">John Waddrob</div>

                    <div class="stars">
                        <i class="fa fa-star" aria-hidden="true"></i>
                        <i class="fa fa-star" aria-hidden="true"></i>
                        <i class="fa fa-star" aria-hidden="true"></i>
                        <i class="fa fa-star" aria-hidden="true"></i>
                        <i class="fa fa-star" aria-hidden="true"></i>
                    </div>

                </div>
            </div>

            <div class="col">
                <div class="testimonial">
                    <img src="https://images.pexels.com/photos/2690323/pexels-photo-2690323.jpeg?auto=compress&cs=tinysrgb&dpr=2&h=650&w=940" alt="">


                    <p>Lorem ipsum dolor sit amet consectetur adipisicing elit. Eaque repellat aspernatur temporibus assumenda sint odio minima. Voluptate alias possimus aspernatur voluptates excepturi placeat iusto cupiditate!</p>

                    <div class="name">John Waddrob</div>

                    <div class="stars">
                        <i class="fa fa-star" aria-hidden="true"></i>
                        <i class="fa fa-star" aria-hidden="true"></i>
                        <i class="fa fa-star" aria-hidden="true"></i>
                        <i class="fa fa-star" aria-hidden="true"></i>
                        <i class="fa fa-star" aria-hidden="true"></i>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>