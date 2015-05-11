<#import "spring.ftl" as spring/>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
        <title></title>
        <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
        <link rel="stylesheet" href="../css/main.css" type="text/css">
        <link rel="stylesheet" href="../css/bootstrap.min.css" type="text/css">
        <link rel="stylesheet" href="../css/font-awesome.min.css" type="text/css">

    </head>
    <body>
    <div class="titleDiv">
        <div class="headDiv">
            <ul class="nav navbar-nav">
                <li class="active"><a href="welcome.htm"><@spring.message 'nav.welcome'/></a></li>
                <li><a href="accounting.htm"><@spring.message 'nav.accounting'/></a></li>
                <li><a href="reports.htm"><@spring.message 'nav.reports'/></a></li>
                <li><a href="download.htm"><@spring.message 'nav.download'/></a></li>
                <li><a href="settings.htm"><@spring.message 'nav.settings'/></a></li>
            </ul>
            <div class="welUser"><br/><br/><@spring.message 'login.welcome.pref'/><#if Session["session_user"].name?exists>&nbsp;${Session["session_user"].name}<#else><@spring.message 'login.welcome.suff'/></#if></div>
        </div>
    </div>
    <div class="blankheight"></div>
    <div class="contentDiv">
        WELCOME!
    </div>
    </body>
    <script type="text/javascript" src="../JavaScript/jquery-2.1.3.min.js"></script>
    <script type="text/javascript" src="../JavaScript/bootstrap.min.js"></script>
    <script type="text/javascript" src="../JavaScript/jquery.leanModal.min.js"></script>
    <script type="text/javascript" src="../JavaScript/normal.js"></script>
</html>