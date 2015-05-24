<#import "spring.ftl" as spring/>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
        <link rel="stylesheet" href="../css/main.css" type="text/css">
        <link rel="stylesheet" href="../css/bootstrap.min.css" type="text/css">
        <link rel="stylesheet" href="../css/font-awesome.min.css" type="text/css">
        <link rel="stylesheet" href="../css/select2.min.css" type="text/css">
    </head>
    <body>
        <div class="titleDiv">
            <div class="headDiv">
                <ul class="nav navbar-nav">
                    <li><a href="welcome.htm"><@spring.message 'nav.welcome'/></a></li>
                    <li class="active"><a href="accounting.htm"><@spring.message 'nav.accounting'/></a></li>
                    <li><a href="reports.htm"><@spring.message 'nav.reports'/></a></li>
                    <li><a href="download.htm"><@spring.message 'nav.download'/></a></li>
                    <li><a href="settings.htm"><@spring.message 'nav.settings'/></a></li>
                </ul>
                <div class="welUser"><br/><br/><@spring.message 'login.welcome.pref'/><#if Session["session_user"].name?exists>&nbsp;${Session["session_user"].name}<#else><@spring.message 'login.welcome.suff'/></#if></div>
            </div>
        </div>
        <div class="blankheight"></div>
        <div class="contentDiv">
            <div>
                <ul class="nav nav-pills">
                    <li role="presentation" class="active" id="nav_tab_incomeForm"><a><@spring.message 'text.income'/></a></li>
                    <li role="presentation" id="nav_tab_expendForm"><a><@spring.message 'text.expend'/></a></li>
                </ul>
            </div>
            </br>
            <div>
                <div class="well well-sm" id="div_income">
                    <form class="form-inline">
                        <div class="row">
                            <div class="col-md-3">
                                <label for="amountIncome"><@spring.message 'text.amount'/>:</label>
                                <input type="text" class="form-control" id="amountIncome" placeholder="0.00" size="15" autofocus/>
                            </div>
                            <div class="col-md-3">
                                <label for="selectProIncome"><@spring.message 'text.selePro'/>:</label>
                                <select id="selectProIncome" class="js-states form-control">
                                    <option value=""><@spring.message 'text.select.plz'/></option>
                                    <#list incomeSelectGroups as incomeSelectGroup>
                                        <optgroup label="${incomeSelectGroup.name}">
                                            <#list incomeSelectGroup.selectGroupMap?keys as key>
                                                <option value="${key}">${incomeSelectGroup.selectGroupMap[key]}</option>
                                            </#list>
                                        </optgroup>
                                    </#list>
                                </select>
                            </div>
                            <div class="col-md-4">
                                <label for="dateIncome"><@spring.message 'text.valueDate'/>:</label>
                                <div class="input-group">
                                    <input type="text" class="form-control" id="dateIncome" placeholder="yyyy-MM-dd">
                                <span class="input-group-addon">
                                    <i class="icon-calendar"></i>
                                </span>
                                </div>
                            </div>
                        </div>
                        <div style="height:15px"></div>
                        <div class="row">
                            <div class="col-md-3">
                                <label for="periodIncome"><@spring.message 'text.period'/>:</label>
                                <select id="periodIncome" class="js-states form-control">
                                    <option value=""><@spring.message 'text.select.plz'/></option>
                                    <option value="1"><@spring.message 'text.period.morning'/></option>
                                    <option value="2"><@spring.message 'text.period.forenoon'/></option>
                                    <option value="3"><@spring.message 'text.period.noon'/></option>
                                    <option value="4"><@spring.message 'text.period.afternoon'/></option>
                                    <option value="5"><@spring.message 'text.period.evening'/></option>
                                    <option value="6"><@spring.message 'text.period.night'/></option>
                                    <option value="7"><@spring.message 'text.period.midnight'/></option>
                                </select>
                            </div>
                            <div class="col-md-7 ">
                                <label for="amountIncome"><@spring.message 'text.remark'/>:</label>
                                <input type="text" class="form-control" id="amountIncome" placeholder="<@spring.message 'text.writeSomething'/>" size="60"/>
                            </div>
                            <div class="col-md-2"><button type="button" class="btn btn-danger" id="submitIncome">&nbsp;&nbsp;&nbsp;<@spring.message 'button.submit'/>&nbsp;&nbsp;&nbsp;</button></div>
                        </div>
                    </form>
                </div>
                <div class="well well-sm" id="div_expend">
                    <form class="form-inline">
                        <div class="row">
                            <div class="col-md-3">
                                <label for="amountExpend"><@spring.message 'text.amount'/>:</label>
                                <input type="text" class="form-control" id="amountExpend" placeholder="0.00" size="15" autofocus/>
                            </div>
                            <div class="col-md-3">
                                <label for="selectPro"><@spring.message 'text.selePro'/>:</label>
                                <select id="selectProExpend" class="js-states form-control">
                                    <option value=""><@spring.message 'text.select.plz'/></option>
                                    <#list expendSelectGroups as expendSelectGroup>
                                        <optgroup label="${expendSelectGroup.name}">
                                            <#list expendSelectGroup.selectGroupMap?keys as key>
                                                <option value="${key}">${expendSelectGroup.selectGroupMap[key]}</option>
                                            </#list>
                                        </optgroup>
                                    </#list>
                                </select>
                            </div>
                            <div class="col-md-4">
                                <label for="dateExpend"><@spring.message 'text.valueDate'/>:</label>
                                <div class="input-group">
                                    <input type="text" class="form-control" id="dateExpend" placeholder="yyyy-MM-dd">
                                <span class="input-group-addon">
                                    <i class="icon-calendar"></i>
                                </span>
                                </div>
                            </div>

                        </div>
                        <div style="height:15px"></div>
                        <div class="row">
                            <div class="col-md-3">
                                <label for="periodExpend"><@spring.message 'text.period'/>:</label>
                                <select id="periodExpend" class="js-states form-control">
                                    <option value=""><@spring.message 'text.select.plz'/></option>
                                    <option value="1"><@spring.message 'text.period.morning'/></option>
                                    <option value="2"><@spring.message 'text.period.forenoon'/></option>
                                    <option value="3"><@spring.message 'text.period.noon'/></option>
                                    <option value="4"><@spring.message 'text.period.afternoon'/></option>
                                    <option value="5"><@spring.message 'text.period.evening'/></option>
                                    <option value="6"><@spring.message 'text.period.night'/></option>
                                    <option value="7"><@spring.message 'text.period.midnight'/></option>
                                </select>
                            </div>
                            <div class="col-md-7 ">
                                <label for="remarkExpend"><@spring.message 'text.remark'/>:</label>
                                <input type="text" class="form-control" id="remarkExpend" placeholder="<@spring.message 'text.writeSomething'/>" size="60"/>
                            </div>
                            <div class="col-md-2"><button type="button" class="btn btn-success" id="submitExpend">&nbsp;&nbsp;&nbsp;<@spring.message 'button.submit'/>&nbsp;&nbsp;&nbsp;</button></div>
                        </div>
                    </form>
                </div>
            </div>
            <div class="well well-sm" id="div_history">
                <div class="panel panel-default">
                    <div class="panel-heading"><@spring.message 'text.Records'/></div>
                    <div class="panel-body"/>
                    <div class="row">
                        <form class="form-inline">
                            <div class="col-md-8">
                                <label class="sr-only" for="history_month">MONTH</label>
                                <div class="input-group">
                                    <input type="text" class="form-control" id="history_month" placeholder="yyyy-MM">
                                        <span class="input-group-addon">
                                            <i class="icon-calendar"></i>
                                        </span>
                                </div>
                                <button type="submit" class="btn btn-primary" id="history_search">SEARCH</button>
                            </div>
                        </form>
                        <div class="col-md-2">
                            <p class="text-danger" id="income_plus"><i class="icon-plus">&nbsp;</i>10000.00<p>
                        </div>
                        <div class="col-md-2">
                            <p class="text-success" id="expend_plus"><i class="icon-minus">&nbsp;</i>40.70<p>
                        </div>
                    </div>
                </div>
                <table class="table">
                    <thead>
                    <th><@spring.message 'text.category'/></th>
                    <th><@spring.message 'text.selePro'/></th>
                    <th><@spring.message 'text.amount'/></th>
                    <th><@spring.message 'text.valueDate'/></th>
                    <th><@spring.message 'text.period'/></th>
                    <th><@spring.message 'text.remark'/></th>
                    <th><@spring.message 'text.operation'/></th>
                    </thead>
                    <tbody>
                    <#list historyForms as historyForm>
                        <tr id="${historyForm.id}">
                            <#if "${historyForm.type}"=="0">
                                <td><@spring.message 'text.income'/><td>
                            <#else>
                                <td><@spring.message 'text.expend'/><td>
                            </#if>
                            <td>${historyForm.usageName}</td>
                            <#if "${historyForm.type}"=="0">
                                <td class="text-danger">${historyForm.amount}</td>
                            <#else>
                                <td class="text-success">${historyForm.amount}</td>
                            </#if>
                            <#if "${historyForm.period}"=="1">
                                <td><@spring.message 'text.period.morning'/></td>
                            <#elseif "${historyForm.period}"=="2">
                                <td><@spring.message 'text.period.forenoon'/></td>
                            <#elseif "${historyForm.period}"=="3">
                                <td><@spring.message 'text.period.noon'/></td>
                            <#elseif "${historyForm.period}"=="4">
                                <td><@spring.message 'text.period.afternoon'/></td>
                            <#elseif "${historyForm.period}"=="2">
                                <td><@spring.message 'text.period.evening'/></td>
                            <#elseif "${historyForm.period}"=="6">
                                <td><@spring.message 'text.period.night'/></td>
                            <#else>
                                <td><@spring.message 'text.period.midnight'/></td>
                            </#if>
                            <td><i class="icon-edit icon-large" style="cursor:pointer"></i>&nbsp;&nbsp;&nbsp;&nbsp;<i class="icon-trash icon-large" style="cursor:pointer"></i></td>
                        </tr>
                    </#list>
                    </tbody>
                </table>
            </div>
        </div>
    </body>
    <script type="text/javascript" src="../JavaScript/jquery-2.1.3.min.js"></script>
    <script type="text/javascript" src="../JavaScript/bootstrap.min.js"></script>
    <script type="text/javascript" src="../JavaScript/select2.min.js"></script>
    <script type="text/javascript" src="../JavaScript/jquery.leanModal.min.js"></script>
    <script type="text/javascript" src="../JavaScript/form.js" charset="UTF-8"></script>
</html>