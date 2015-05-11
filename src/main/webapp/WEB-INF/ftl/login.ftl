<#import "spring.ftl" as spring/>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <title></title>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <style type="text/css">
        div#loginDiv {position: absolute;left: 50%;top: 50%;margin:-150px 0 0 -150px;height: 300px;width: 300px;}
    </style>
    <link rel="stylesheet" href="../css/bootstrap.min.css" type="text/css">
    <link rel="stylesheet" href="../css/font-awesome.min.css" type="text/css">
    <script type="text/javascript" src="../JavaScript/jquery-2.1.3.min.js"></script>
    <script type="text/javascript" src="../JavaScript/bootstrap.min.js"></script>
    <script type="text/javascript">
        function redirect() {
            window.location = "register.htm";
        }
    </script>
</head>
<body>
<div id="loginDiv">
    <form action="login.htm" method="post">
        <div style="color: #ff0000" class="alert alert-error">
            <@spring.bind "user.loginName"/><@spring.showErrors ""/>
            <@spring.bind "user.password"/><@spring.showErrors ""/>
        </div>
        <div class="form-group">
            <label for="loginID"><@spring.message 'text.userLoginName'/></label>
            <input type="text" value="${user.loginName}" class="form-control" name="loginName" id="loginID" placeholder="<@spring.message 'plahdr.userLoginName'/>" required autofocus>
        </div>
        <div class="form-group">
            <label for="loginPWD"><@spring.message 'text.userPassword'/></label>
            <input type="password" value="${(user.password)}" class="form-control" name="password" id="loginPWD" placeholder="<@spring.message 'plahdr.userPassword'/>" required>
        </div>
        <button id="login" type="submit" class="btn btn-lg btn-primary btn-block"><@spring.message 'button.login'/></button>
        <br>
        <button id="register" type="button" class="btn btn-lg btn-primary btn-block" onclick="redirect()"><@spring.message 'button.register'/></button>
    </form>
</div>
</body>
</html>
