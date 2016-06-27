<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>

<html xmlns="http://www.w3.org/1999/xhtml">
<head>

    <title>Главная страница</title>

    <!--Start Stylesheets-->
    <link href="css/style.css" rel="stylesheet" type="text/css" />
    <link href="css/main.css" rel="stylesheet" type="text/css" />

    <!--[if IE 6]>
    <script type="text/javascript" src="js/unitpngfix.js"></script>
    <link href="css/ie6.css" rel="stylesheet" type="text/css" />
    <![endif]-->

    <!--Javascript Files-->
    <script type="text/javascript" src="js/jquery.js"></script>
    <script type="text/javascript" src="js/cufon-yui.js"></script>
    <script type="text/javascript" src="js/Grandesign_Neue_Serif_400.font.js"></script>
    <script type="text/javascript"></script>



    <script>

        (function ($) {
            var hwSlideSpeed = 700;
            var hwTimeOut = 3000;
            var hwNeedLinks = true;

            $(document).ready(function(e) {
                $('.slide').css(
                        {"position" : "absolute",
                            "top":'0', "left": '0'}).hide().eq(0).show();
                var slideNum = 0;
                var slideTime;
                slideCount = $("#slider .slide").size();
                var animSlide = function(arrow){
                    clearTimeout(slideTime);
                    $('.slide').eq(slideNum).fadeOut(hwSlideSpeed);
                    if(arrow == "next"){
                        if(slideNum == (slideCount-1)){slideNum=0;}
                        else{slideNum++}
                    }
                    else if(arrow == "prew")
                    {
                        if(slideNum == 0){slideNum=slideCount-1;}
                        else{slideNum-=1}
                    }
                    else{
                        slideNum = arrow;
                    }
                    $('.slide').eq(slideNum).fadeIn(hwSlideSpeed, rotator);
                    $(".control-slide.active").removeClass("active");
                    $('.control-slide').eq(slideNum).addClass('active');
                };
                if(hwNeedLinks){
                    var $linkArrow = $('<a id="prewbutton" href="#">&lt;</a><a id="nextbutton" href="#">&gt;</a>')
                            .prependTo('#slider');
                    $('#nextbutton').click(function(){
                        animSlide("next");
                        return false;
                    });
                    $('#prewbutton').click(function(){
                        animSlide("prew");
                        return false;
                    })
                }
                var $adderSpan = '';
                $('.slide').each(function(index) {
                    $adderSpan += '<span class = "control-slide">' + index + '</span>';
                });
                $('<div class ="sli-links">' + $adderSpan +'</div>').appendTo('#slider-wrap');
                $(".control-slide:first").addClass("active");
                $('.control-slide').click(function(){
                    var goToNum = parseFloat($(this).text());
                    animSlide(goToNum);
                });
                var pause = false;
                var rotator = function()
                {
                    if(!pause){slideTime = setTimeout(function(){animSlide('next')}, hwTimeOut);}
                };
                $('#slider-wrap').hover(
                        function(){clearTimeout(slideTime); pause = true;},
                        function(){pause = false; rotator();
                        });
                rotator();
            });
        })(jQuery);

    </script>

</head>

<body>




<div id="main_container">
    <!-- FRAME -->
    <div id="frame">

        <!-- BEGIN HEADER -->
        <div id="top">
            <div id="logo">
                <div id="pad_logo">
                    <a href="index"><img src="image/logo.gif" alt="" /></a>
                </div>
            </div>

            <div id="topmenu">
                <div id="nav">
                    <ul id="menu">
                        <li class="current"><a class="active" href="index">Главная</a></li>
                        <li><a href="management">Управление</a></li>
                        <li class="last"><a href="#bottom_container">Контакты</a></li>
                    </ul>
                </div>
            </div>
        </div>

        <!-- SLIDES_CONTAINER -->
        <div id="slides_container">

            <div id="slider-wrap">
                <div id="slider">
                    <div class="slide"><img src="image/sklad1.jpg"></div>
                    <div class="slide"><img src="image/sklad2.jpg"></div>
                    <div class="slide"><img src="image/sklad3.jpg"></div>
                    <div class="slide"><img src="image/sklad4.jpg"></div>
                </div>
            </div>

        </div>

        <div id="content2">
            <div class="maincontent">
                <h3><a href="services">Услуги</a></h3>


                <div class="element">
                    <a href="market"><img src="image/goods.jpg" class="imgleft"/></a>
                    <div class="text"><a href="market">Прайс-лист</a></div>
                </div>

            <c:if test="${pageContext.request.remoteUser == null}">
                <div class="element">
                    <a href="registration"><img src="image/reg.jpg" class="imgleft"/></a>
                    <div class="text"><a href="registration">Регистрация</a></div>
                </div>
            </c:if>
                <div class="element">
                    <a href="office"><img src="image/doc.jpg" class="imgleft"/></a>
                    <div class="text"><a href="office">Кабинет</a></div>
                </div>
                <c:if test="${pageContext.request.remoteUser != null}">
                    <div class="element">
                        <a href="j_security_logout"><img src="image/exit.png" class="imgleft"/></a>
                        <div class="text"><a href="j_security_logout">Выход</a></div>
                    </div>

                </c:if>

            </div>
        </div>

        <!-- END OF SLIDES_CONTAINER -->

        <!-- BEGIN CONTENT -->
        <div id="content">
            <div id="content1">
                <div class="maincontent">
                    <h3><spring:message code="Company"/></h3>
                    <p><spring:message code="Description"/></p>
                </div>
            </div>
        </div>
        <!-- END OF CONTENT -->

    </div>
    <!-- END OF FRAME -->
</div>



<div id="bottom_container">
    <div id="footer">
        <div id="foot">
            <div class="left-foot">
                14th Place, M1234 Heavenway, HW 5468, USA.<br />
                Phone: +62 4872 2894, Fax: +62 4872 2895, Email: info@devster.com<br />
                Copyright &copy;2009 Devster. All Rights Reserved.
            </div>
            <div class="right-foot">
                <div class="twitter-code">Quis autem vel eum iure reprehenderit qui in ea voluptate commodo - 9 hours ago</div>
            </div>
        </div>
    </div>
</div>

</body>
</html>
