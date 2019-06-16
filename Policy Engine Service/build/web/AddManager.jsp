<!DOCTYPE html>
-<html lang="en">
    <head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="shortcut icon" href="img/favicon.png">

        <title>PEaaS | Home</title>

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
         <%
            String cid = "";
            if (session.getAttribute("cid") != null) {
                cid = session.getAttribute("cid").toString();
            }
        %>
        <!--header start-->
        <header class="head-section">
            <div class="navbar navbar-default navbar-static-top container">
                <div class="navbar-header">
                    <button class="navbar-toggle" data-target=".navbar-collapse" data-toggle="collapse"
                            type="button"><span class="icon-bar"></span> <span class="icon-bar"></span>
                        <span class="icon-bar"></span></button> <a class="navbar-brand" href="index.html">Policy<span>ENGINE</span></a>
                </div>

                <ul class="nav navbar-nav">
                    <li>
                        <a href="CEOHome.jsp">Home </a>

                    </li> 
                    <li>
                        <a href="AddManager.jsp">Add manager </a>

                    </li> 
                    <li>
                        <a href="CEOUpload.jsp">Upload File</a>

                    </li>
                    <li>
                        <a href="CEODownload.jsp">Download File</a>

                    </li>
                    <li>
                        <a href="Login.jsp">Logout </a>

                    </li>

                </ul>
            </div>
        </header>
        <!--header end-->
        <%
            String addManager = "";
            if (session.getAttribute("addManager") != null) {
                addManager = session.getAttribute("addManager").toString();
            }
        %>
        <!--breadcrumbs start-->
        <div class="breadcrumbs">
            <div class="container">
                <div class="row">
                    <div class="col-lg-4 col-sm-4">
                        <h1>Manager Registration</h1>
                    </div>

                </div>
            </div>
        </div>
        <!--breadcrumbs end-->

        <!--container start-->
        <div class="registration-bg">
            <div class="container">
                <Script type="text/javascript">
                    function validation(){

                        var pass=document.getElementById("password").value;
                        var cpass=document.getElementById("cpassword").value;
                        if(pass!=cpass){
            
                            alert('Password does not match!!!');
                            return false;
             
                        }
                    }
                </script>





                <center><h3><%=addManager%></h3></center><% session.removeAttribute("reg");%>
                <form class="form-signin wow fadeInUp" action="AddManager" method="post" onsubmit="return validation() ;">
                    <h2 class="form-signin-heading">Register now</h2>
                    <div class="login-wrap">
                        <p>Enter personal details</p>
                        <input type="text" class="form-control" placeholder="Full Name" required="required" name="name" autofocus="">
                        <input type="text" class="form-control" placeholder="Company name" required="required" name="companyName" autofocus="">
                        <input type="text" class="form-control" placeholder="Department name" required="required" name="departmentName" autofocus="">
                        <input type="email" class="form-control" placeholder="Email" name="email" required="required" autofocus=""><br>
                        <input type="text" class="form-control" placeholder="City/Town" required="required" name="city" autofocus="">

                        <p> Enter manager account details below</p>
                        <input type="text" class="form-control" placeholder="User Name" required="required" name="user_name" autofocus="">
                        <input type="password" class="form-control" placeholder="Password" required="required" id="password" name="password">
                        <input type="password" class="form-control" placeholder="Re-type Password" required="required" id="cpassword" name="re-type_password">
                        <label class="checkbox">
                            <input type="checkbox" value="agree this condition"> I agree to the Terms of Service and Privacy Policy
                        </label>
                        <button class="btn btn-lg btn-login btn-block" type="submit">Submit</button>

                    </div>
                </form>

            </div>
        </div>
        <!--container end-->


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
