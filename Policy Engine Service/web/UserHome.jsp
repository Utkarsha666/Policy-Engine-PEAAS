<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        
        <link rel="shortcut icon" href="img/favicon.png">

        <title>
            PEaaS | User Home
        </title>

        <!-- Bootstrap core CSS -->
        <link href="css/bootstrap.min.css" rel="stylesheet">
        <link href="css/theme.css" rel="stylesheet">
        <link href="css/bootstrap-reset.css" rel="stylesheet">
        <!-- <link href="css/bootstrap.min.css" rel="stylesheet">-->

        <!--external css-->
        <link href="assets/font-awesome/css/font-awesome.css" rel="stylesheet" />
        <link rel="stylesheet" href="css/flexslider.css"/>
        <link href="assets/bxslider/jquery.bxslider.css" rel="stylesheet" />
        <link rel="stylesheet" href="css/animate.css">
        <link rel="stylesheet" href="assets/owlcarousel/owl.carousel.css">
        <link rel="stylesheet" href="assets/owlcarousel/owl.theme.css">

        <link href="css/superfish.css" rel="stylesheet" media="screen">
        <link href='http://fonts.googleapis.com/css?family=Lato' rel='stylesheet' type='text/css'>
        <!-- <link href='http://fonts.googleapis.com/css?family=Open+Sans' rel='stylesheet' type='text/css'> -->


        <!-- Custom styles for this template -->
        <link rel="stylesheet" type="text/css" href="css/component.css">
        <link href="css/style.css" rel="stylesheet">
        <link href="css/style-responsive.css" rel="stylesheet" />

        <link rel="stylesheet" type="text/css" href="css/parallax-slider/parallax-slider.css" />
        <script type="text/javascript" src="js/parallax-slider/modernizr.custom.28468.js">
        </script>

        <!-- HTML5 shim and Respond.js IE8 support of HTML5 tooltipss and media queries -->
        <!--[if lt IE 9]>
        <script src="js/html5shiv.js">
        </script>
        <script src="js/respond.min.js">
        </script>
        <![endif]-->
    </head>
    <%        
        
        String sessionId = session.getId();
        String sessionId2 = session.getId();
        System.out.println("sessionId = " + sessionId);
        System.out.println("sessionId2 = " + sessionId2);
        String SecretKey=sessionId+sessionId2;
        System.out.println("SecretKey = " + SecretKey);
        
        
    %>
    <body>
        <!--header start-->
        <header class="head-section">
            <div class="navbar navbar-default navbar-static-top container">
                <div class="navbar-header">
                    <button class="navbar-toggle" data-target=".navbar-collapse" data-toggle="collapse" type="button">
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                    </button>
                    <a class="navbar-brand" href="index.jsp">Policy<span>ENGINE</span></a>
                </div>
                <div class="navbar-collapse collapse">
                    <ul class="nav navbar-nav">
                        <li>
                            <a href="UserHome.jsp">Home </a>

                        </li> 
                        <li>
                            <a href="FileUpload.jsp">File Upload</a>

                        </li>  <li>
                            <a href="FileDownload.jsp">File Download</a>

                        </li> 
                        <li>
                            <a href="Login.jsp">Logout </a>

                        </li>

                    </ul>
                </div>
            </div>
        </header>
        <!--header end-->

        <!-- Sequence Modern Slider -->
        <div id="da-slider" class="da-slider">
        </div>



        <!-- js placed at the end of the document so the pages load faster
    <script src="js/jquery.js">
    </script>
        -->
        <script src="js/jquery-1.8.3.min.js">
        </script>
        <script src="js/bootstrap.min.js">
        </script>
        <script type="text/javascript" src="js/hover-dropdown.js">
        </script>
        <script defer src="js/jquery.flexslider.js">
        </script>
        <script type="text/javascript" src="assets/bxslider/jquery.bxslider.js">
        </script>

        <script type="text/javascript" src="js/jquery.parallax-1.1.3.js">
        </script>
        <script src="js/wow.min.js">
        </script>
        <script src="assets/owlcarousel/owl.carousel.js">
        </script>

        <script src="js/jquery.easing.min.js">
        </script>
        <script src="js/link-hover.js">
        </script>
        <script src="js/superfish.js">
        </script>
        <script type="text/javascript" src="js/parallax-slider/jquery.cslider.js">
        </script>
        <script type="text/javascript">
            $(function() {

                $('#da-slider').cslider({
                    autoplay    : true,
                    bgincrement : 100
                });

            });
        </script>



        <!--common script for all pages-->
        <script src="js/common-scripts.js">
        </script>

        <script type="text/javascript">
            jQuery(document).ready(function()
            {
                $('.bxslider1').bxSlider({
                    minSlides: 5,
                    maxSlides: 6,
                    slideWidth: 360,
                    slideMargin: 2,
                    moveSlides: 1,
                    responsive: true,
                    nextSelector: '#slider-next',
                    prevSelector: '#slider-prev',
                    nextText: 'Onward ?',
                    prevText: '? Go back'
                });

            });


        </script>


        <script>
            $('a.info').tooltip();

            $(window).load(function() {
                $('.flexslider').flexslider({
                    animation: "slide",
                    start: function(slider) {
                        $('body').removeClass('loading');
                    }
                });
            });

            $(document).ready(function() {

                $("#owl-demo").owlCarousel({

                    items : 4

                });

            });

            jQuery(document).ready(function(){
                jQuery('ul.superfish').superfish();
            });

            new WOW().init();


        </script>
    </body>
</html>