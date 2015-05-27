<#import "spring.ftl" as spring/>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <title></title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <style type="text/css">
        div#registerDiv {position: absolute;left: 50%;top: 50%;margin:-280px 0 0 -190px;height: 700px;width: 320px;}
    </style>
    <link rel="stylesheet" href="../css/bootstrap.min.css" type="text/css">
    <link rel="stylesheet" href="../css/font-awesome.min.css" type="text/css">
    <link rel="stylesheet" href="../css/bootstrap-datetimepicker.css" type="text/css">
</head>
<body>
<div id="registerDiv">
    <form class="form-horizontal" action="registerCheck.htm" method="post">
        <div style="color: #ff0000" class="alert alert-error">
            <@spring.bind "user.loginName"/><@spring.showErrors ""/>
            <@spring.bind "user.password"/><@spring.showErrors ""/>
            <@spring.bind "user.nickName"/><@spring.showErrors ""/>
            <@spring.bind "user.gender"/><@spring.showErrors ""/>
            <@spring.bind "user.birthdate"/><@spring.showErrors ""/>
            <@spring.bind "user.email"/><@spring.showErrors ""/>
        </div>
        <div class="form-group">
            <label for="registerID" class="col-sm-4 control-label"><@spring.message 'text.userLoginName'/></label>
            <div class="col-sm-8">
                <input type="text" value="${(user.loginName)}" class="form-control" name="loginName" id="registerID" placeholder="<@spring.message 'plahdr.userLoginName'/>" required autofocus>
            </div>
        </div>
        <div class="form-group">
            <label for="registerPWD" class="col-sm-4 control-label"><@spring.message 'text.userPassword'/></label>
            <div style="width: 230px"   class="col-sm-8">

                <input type="password" value="${(user.password)}" class="form-control" name="password" id="registerPWD" placeholder="<@spring.message 'plahdr.userPassword'/>" required>

            </div>
        </div>
        <div class="form-group">
            <label for="registerName" class="col-sm-4 control-label"><@spring.message 'text.nickName'/></label>
            <div class="col-sm-8">
                <input type="text" value="${(user.nickName)}" class="form-control" name="nickName" id="registerNickname" placeholder="<@spring.message 'plahdr.nickName'/>" required>
            </div>
        </div>
        <div class="form-group">
            <label for="registerName" class="col-sm-4 control-label"><@spring.message 'text.gender'/></label>
            <div class="col-sm-8">
                <label class="radio-inline">
                    <input type="radio" name="gender" id="gender1" value="1" <#if "${(user.gender)}"=="1">checked</#if>> <@spring.message 'text.gender.male'/>
                </label>
                <label class="radio-inline">
                    <input type="radio" name="gender" id="gender2" value="2" <#if "${(user.gender)}"=="2">checked</#if>> <@spring.message 'text.gender.female'/>
                </label>
            </div>
        </div>
        <div class="form-group">
            <label for="registerBirthdate" class="col-sm-4 control-label"><@spring.message 'text.birthDate'/></label>
            <div class="col-sm-8">
                <div calss="form-group">
                    <div id="datetimepicker" class="input-group date datetimepicker">
                        <input type="text" value="${(user.birthdate)}" class="form-control" name="birthdate" id="registerBirthdate" placeholder="<@spring.message 'plahdr.birthDate'/>" readonly required></input>
                        <span class="input-group-addon">
                            <i class="icon-calendar"></i>
                        </span>
                    </div>
                </div>
            </div>
        </div>
        <div class="form-group">
            <label for="registerEmail" class="col-sm-4 control-label"><@spring.message 'text.email'/></label>
            <div class="col-sm-8">
                <input type="email" value="${(user.email)}" class="form-control" name="email" id="registerEmail" placeholder="<@spring.message 'plahdr.email'/>" required>
            </div>
        </div>
        <button id="login" type="submit" class="btn btn-lg btn-primary btn-block"><@spring.message 'button.register'/></button>
    </form>
</div>
</body>
<script type="text/javascript" src="../JavaScript/jquery-2.1.3.min.js"></script>
<script type="text/javascript" src="../JavaScript/bootstrap.min.js"></script>
<script type="text/javascript" src="../JavaScript/bootstrap-datetimepicker.js"></script>
<script type="text/javascript">
    $.fn.datetimepicker.dates['zh'] = {
        days: ["星期日", "星期一", "星期二", "星期三", "星期四", "星期日五", "星期六"],
        daysShort: ["周日", "周一", "周二", "周三", "周四", "周五", "周六"],
        daysMin: ["日", "一", "二", "三", "四", "五", "六"],
        months: ["01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12"],
        monthsShort: ["1月", "2月", "3月", "4月", "5月", "6月", "7月", "8月", "9月", "10月", "11月", "12月"],
        today: "今天",
        clear: "清除"
    };

    $(function(){
        $('#datetimepicker').datetimepicker({
            show:true,
            format:'yyyy-MM-dd',
            weekStart:1,
            autoClose:true,
            todayHighlight:true,
            daysOfWeekHighlighted:06,
            pickerPosition: "bottom-left",
            language:'zh'


        });
    })
</script>
</html>