<#import "spring.ftl" as spring/>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <title></title>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <link rel="stylesheet" href="../css/style.css" type="text/css">
    <link rel="stylesheet" href="../css/bootstrap.min.css" type="text/css">
    <link rel="stylesheet" href="../css/font-awesome.min.css" type="text/css">
    <script type="text/javascript" src="../JavaScript/jquery-2.1.3.min.js"></script>
    <script type="text/javascript" src="../JavaScript/bootstrap.min.js"></script>
    <style type="text/css">
        div#containerDiv {width:1200px;margin:0 auto;position: relative;}
        div#welcome {width:400px;height:20px;position: absolute;right: 0px;top: 80px;}
        div#navDiv {width:1200px;height:70px;position: absolute;left: 0px;top: 100px;}
        div#middleDiv {width:1200px;height:780px;position: absolute;left: 0px;top: 160px;}
    </style>
</head>
<body>
<div id="containerDiv">
    <div id="welcome" align="right">
    <@spring.message 'login.welcome.pref'/><#if Session["session_user"].loginName?exists>&nbsp;${Session["session_user"].loginName}<#else><@spring.message 'login.welcome.suff'/></#if>
    </div>
    <div id="navDiv" class="span12">
        <nav class="navbar navbar-default" role="navigation">
            <div class="navbar-header">
                <a class="navbar-brand" href="#"><@spring.message 'nav.brand'/></a>
            </div>
            <div>
                <ul class="nav navbar-nav">
                    <li class="active"><a href="#"><@spring.message 'nav.form1'/></a></li>
                    <li class="dropdown">
                        <a href="#" class="dropdown-toggle" data-toggle="dropdown"><@spring.message 'nav.form2'/><b class="caret"></b></a>
                        <ul class="dropdown-menu">
                            <li><a href="javascript:void()" onclick="window.location.href = '../income/create.htm'"><@spring.message 'nav.form2.select1'/></a></li>
                            <li><a href="javascript:void()" onclick="window.location.href = '../income/modify.htm'"><@spring.message 'nav.form2.select2'/></a></li>
                            <li><a href="javascript:void()" onclick="window.location.href = '../income/delete.htm'"><@spring.message 'nav.form2.select3'/></a></li>
                            <li><a href="javascript:void()" onclick="window.location.href = '../income/query.htm'"><@spring.message 'nav.form2.select4'/></a></li>
                        </ul>
                    </li>
                    <li class="dropdown">
                        <a href="#" class="dropdown-toggle" data-toggle="dropdown"><@spring.message 'nav.form3'/><b class="caret"></b></a>
                        <ul class="dropdown-menu">
                            <li><a href="#"><@spring.message 'nav.form3.select1'/></a></li>
                            <li><a href="#"><@spring.message 'nav.form3.select2'/></a></li>
                            <li><a href="#"><@spring.message 'nav.form3.select3'/></a></li>
                            <li><a href="#"><@spring.message 'nav.form3.select4'/></a></li>
                        </ul>
                    </li>
                    <li class="dropdown">
                        <a href="#" class="dropdown-toggle" data-toggle="dropdown"><@spring.message 'nav.form4'/><b class="caret"></b></a>
                        <ul class="dropdown-menu">
                            <li><a href="#"><@spring.message 'nav.form4.select1'/></a></li>
                            <li><a href="#"><@spring.message 'nav.form4.select2'/></a></li>
                            <li><a href="#"><@spring.message 'nav.form4.select3'/></a></li>
                            <li class="divider">
                            <li><a href="#"><@spring.message 'nav.form4.select4'/></a></li>
                        </ul>
                    </li>
                    <li class="dropdown">
                        <a href="#" class="dropdown-toggle" data-toggle="dropdown"><@spring.message 'nav.form5'/><b class="caret"></b></a>
                        <ul class="dropdown-menu">
                            <li><a href="#"><@spring.message 'nav.form5.select1'/></a></li>
                            <li><a href="#"><@spring.message 'nav.form5.select2'/></a></li>
                            <li><a href="#"><@spring.message 'nav.form5.select3'/></a></li>
                            <li class="divider">
                            <li><a href="#"><@spring.message 'nav.form5.select4'/></a></li>
                        </ul>
                    </li>
                </ul>
            </div>
        </nav>
    </div>
    <div id="middleDiv">

    </div>
</div>
</body>
</html>