<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
     
        <link rel="shortcut icon" href="img/favicon.png">

        <title>PEaaS | SLA Engine</title>

        <!-- Bootstrap core CSS -->
        <link href="css/bootstrap.min.css" rel="stylesheet">
        <link href="css/theme.css" rel="stylesheet">
        <link href="css/bootstrap-reset.css" rel="stylesheet">
        <!--external css-->
        <link href="assets/font-awesome/css/font-awesome.css" rel="stylesheet" />
        <link rel="stylesheet" href="css/flexslider.css"/>
        <link href="assets/bxslider/jquery.bxslider.css" rel="stylesheet" />
        <link rel="stylesheet" href="css/animate.css">
        <link href='http://fonts.googleapis.com/css?family=Lato' rel='stylesheet' type='text/css'>


        <!-- Custom styles for this template -->
        <link href="css/style.css" rel="stylesheet">
        <link href="css/style-responsive.css" rel="stylesheet" />

        <!-- HTML5 shim and Respond.js IE8 support of HTML5 tooltipss and media queries -->
        <!--[if lt IE 9]>
          <script src="js/html5shiv.js"></script>
          <script src="js/respond.min.js"></script>
        <![endif]-->
    </head>

    <body>
        <!--header start-->
        <header class="head-section">
            <div class="navbar navbar-default navbar-static-top container">
                <div class="navbar-header">
                    <button class="navbar-toggle" data-target=".navbar-collapse" data-toggle="collapse"
                            type="button"><span class="icon-bar"></span> <span class="icon-bar"></span>
                        <span class="icon-bar"></span></button> <a class="navbar-brand" href="index.jsp">Policy<span>ENGINE</span></a>
                </div>

                <div class="navbar-collapse collapse">
                    <ul class="nav navbar-nav">
                        <li>
                        <li>
                            <!--                            <a href="index.jsp">Home </a>-->

                        </li> 


                        <li>
                            <!--                            <a href="Registration.jsp">Registration </a>-->

                        </li> 
                        <li>
                            <!--                            <a href="Login.jsp">Login </a>-->

                        </li>

                    </ul>

                    </ul>
                </div>
            </div>
        </header>
        <!--header end-->
        <%
            String BankPage = "";
            if (session.getAttribute("BankPage") != null) {
                BankPage = session.getAttribute("BankPage").toString();
            }
        %>
        <!--breadcrumbs start-->
        <div class="breadcrumbs">
            <div class="container">
                <div class="row">
                    <div class="col-lg-4 col-sm-4">
                        <h1>Communication With Bank</h1>
                    </div>
                </div>
            </div>
        </div>
        <!--breadcrumbs end-->
    <center><h3><%=BankPage%></h3></center><% session.removeAttribute("BankPage");%>
    <!--container start-->
    <div class="registration-bg">
        <div class="container">


        </div>
        <br/><br/><br/><br/><br/><br/><br/>

        <center> <a href="FileUpload.jsp"><button class="btn btn-lg btn-login btn-block" type="submit"  style="width: 300px; width: 70px;"> --OK--</button></a></center>

    </div>
    <!--container end-->

    <!--footer start-->

    <!-- footer end -->

    <!-- js placed at the end of the document so the pages load faster -->
    <script src="js/jquery.js"></script>
    <script src="js/bootstrap.min.js"></script>
    <script type="text/javascript" src="js/hover-dropdown.js"></script>
    <script defer src="js/jquery.flexslider.js"></script>
    <script type="text/javascript" src="assets/bxslider/jquery.bxslider.js"></script>

    <script src="js/jquery.easing.min.js"></script>
    <script src="js/link-hover.js"></script>


    <!--common script for all pages-->
    <script src="js/common-scripts.js"></script>
    <script src="js/wow.min.js"></script>
    <script>
        wow = new WOW(
        {
            boxClass:     'wow',      // default
            animateClass: 'animated', // default
            offset:       0          // default
        }
    )
        wow.init();
    </script>

</body>
</html>
