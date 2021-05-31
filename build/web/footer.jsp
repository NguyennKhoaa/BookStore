<%-- 
    Document   : footer.jsp
    Created on : May 13, 2021, 1:46:41 PM
    Author     : Khoa Nguyễn
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link
            rel="stylesheet"
            href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
            integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
            crossorigin="anonymous"
            />

        <style type="text/css">

            footer {
                background-color: #222222;
            }

            footer .footer__content {
                margin: 0 auto;
                width: 70%;
            }

            footer .footer__content .footer__rowSecond {
                width: 100%;
                margin: 0;
            }

            footer .footer__content .footer__rowSecond .footer__img {
                padding: 0;
            }

            footer .footer__content .footer__rowSecond .footer__img .footer__logo img {
                width: 80px;
                height: auto;
                border-radius: 5px;
            }

            footer .footer__content .footer__rowSecond .footer__hr__content {
                font-size: 13px;
            }

            footer .footer__content .footer__rowSecond .footer__hr__content h6 {
                color: #fff;
                font-size: 13px;
                margin: 0;
                line-height: 1.8;
            }

            footer .footer__content .footer__rowSecond .footer__hr__content p {
                color: #949494;
                margin: 0;
                line-height: 1.8;
            }

            footer .footer__content .footer__rowSecond .footer__hr__content p .footer__email {
                color: #ff0000;
                text-decoration: none;
            }

            footer .footer__content .footer__rowSecond .footer__img .footer__BoCo {
                text-align: right;
            }

            footer .footer__content .footer__rowSecond .footer__img .footer__BoCo img {
                width: 130px;
            }

        </style>
    </head>
    <body>
        <footer>
            <div class="footer__content">
                <div class="row footer__rowSecond py-3">
                    <div class="col-12 col-md-1 footer__img">
                        <div class="footer__logo">
                            <img src="img/logo1.jpg" alt="logo" />
                        </div>
                    </div>
                    <div class="col-12 col-md-9 footer__hr__content">
                        <h6>SHOP BAN HOA OF KHOA NGUYEN JOINT STOCK COMPANY</h6>
                        <p>
                            Address : 380/74A Pham Van Chieu, Go Vap District, Ho Chi Minh City.
                        </p>
                        <p>
                            Certificate of business registration number: 0101659783, <br> 30th change registration, 22 month
                            01 year 2020 by the Department of Planning and Investment of Ho Chi Minh City.
                        </p>
                        <p>Hotline: 0856 559 742</p>
                        <p>
                            Email: <a href="#" class="footer__email">npdkhoa2311@gmail.com</a>
                        </p>
                    </div>
                    <div class="col-12 col-md-2 footer__img">
                        <div class="footer__BoCo mb-5">
                            <a
                                href="http://online.gov.vn/Home/WebDetails/62782?AspxAutoDetectCookieSupport=1"
                                >
                                <img
                                    src="img/tb.png"
                                    alt="logoBoCongThuong"
                                    />
                            </a>
                        </div>
                    </div>
                </div>
            </div>
        </footer>

        <script
            src="https://code.jquery.com/jquery-3.3.1.slim.min.js"
            integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo"
            crossorigin="anonymous"
        ></script>
        <script
            src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"
            integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1"
            crossorigin="anonymous"
        ></script>
        <script
            src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"
            integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM"
            crossorigin="anonymous"
        ></script>
    </body>
</html>

