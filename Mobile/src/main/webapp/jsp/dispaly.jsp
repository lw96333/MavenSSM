<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE html>
<html lang="en">
<base href=<%=basePath %>/>
<head>
	
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="ECharts">
    <meta name="author" content="kener.linfeng@gmail.com">
    <title>ECharts · Example</title>

    <link rel="shortcut icon" href="image/favicon.png">

    <link href="css/font-awesome.min.css" rel="stylesheet">
    <link href="css/bootstrap.css" rel="stylesheet">
    <link href="css/carousel.css" rel="stylesheet">
    <link href="css/echartsHome.css" rel="stylesheet">
    <link href="css/pagination.css" rel="stylesheet">
    <!-- HTML5 shim and Respond.js IE8 support of HTML5 elements and media queries -->



    <script src="js/codemirror.js"></script>
    <script src="js/javascript.js"></script>

    <link href="css/codemirror.css" rel="stylesheet">
    <link href="css/monokai.css" rel="stylesheet">
</head>

<body>
    <!-- Fixed navbar -->
    <div class="navbar navbar-default navbar-fixed-top" role="navigation" id="head"></div>


    <div class="container-fluid">
        <div class="row-fluid example">
           
            <div id="graphic" class="col-md-8">
                <div id="main" class="main"></div>
                <div style="height:80px;">

                </div>
            </div><!--/span-->
            <div id="pagination_2" style="margin-left:0px;"></div>
        </div><!--/row-->
        
        </div><!--/.fluid-container-->

    <footer id="footer"></footer>
    <!-- Le javascript
    ================================================== -->
    <!-- Placed at the end of the document so the pages load faster -->
    <script src="js/jquery.min.js"></script>
    <script type="text/javascript" src="js/echartsHome.js"></script>
    <script src="js/bootstrap.min.js"></script>
    <script src="js/echarts-all.js"></script>
    <script type="text/javascript" src="js/dispaly.js"></script>
    <script type="text/javascript" src="js/pagination.min.js"></script>
</body>
</html>
