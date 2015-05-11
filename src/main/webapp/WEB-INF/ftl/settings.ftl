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
                    <li><a href="welcome.htm"><@spring.message 'nav.welcome'/></a></li>
                    <li><a href="accounting.htm"><@spring.message 'nav.accounting'/></a></li>
                    <li><a href="reports.htm"><@spring.message 'nav.reports'/></a></li>
                    <li><a href="download.htm"><@spring.message 'nav.download'/></a></li>
                    <li class="active"><a href="settings.htm"><@spring.message 'nav.settings'/></a></li>
                </ul>
                <div class="welUser"><br/><br/><@spring.message 'login.welcome.pref'/><#if Session["session_user"].name?exists>&nbsp;${Session["session_user"].name}<#else><@spring.message 'login.welcome.suff'/></#if></div>
            </div>
        </div>
        <div class="blankheight"></div>
        <div class="contentDiv">
            <div>
                <ul class="nav nav-tabs nav-justified">
                    <li role="presentation" class="active" id="nav_tab_income"><a><@spring.message 'nav.settings.income'/></a></li>
                    <li role="presentation" id="nav_tab_expire"><a><@spring.message 'nav.settings.expire'/></a></li>
                    <li role="presentation" id="nav_tab_application"><a><@spring.message 'nav.settings.application'/></a></li>
                    <li role="presentation" id="nav_tab_personal"><a><@spring.message 'nav.settings.personal'/></a></li>
                </ul>
            </div>
            <div>
                <div id="block_incomeTab">
                    <table class="table table-hover">
                        <thead>
                        <tr>
                            <th width="225px"><@spring.message 'nav.settings.proOne'/></th>
                            <th width="350px"><@spring.message 'nav.settings.proTwo'/></th>
                            <th width="185px"><@spring.message 'nav.settings.proAmount'/></th>
                            <th width="240px"><@spring.message 'nav.settings.operation'/></th>
                        </tr>
                        </thead>
                        <tbody>
                        <#if (incomeNode?size)!=0>
                            <#list incomeNode?keys as key>
                            <tr id="incomeOne${key}">
                                <td>${incomeNode[key].projectName}</td>
                                <td></td>
                                <td>${incomeNode[key].projectAmount}</td>
                                <td><i class="icon-edit icon-large" style="cursor:pointer"></i>&nbsp;&nbsp;&nbsp;&nbsp;<i class="icon-trash icon-large" style="cursor:pointer"></i></td>
                            </tr>
                                <#if (incomeNode[key].levelTwoProjectList?size)!=0>
                                    <#list incomeNode[key].levelTwoProjectList as levelTwoProject>
                                    <tr id="incomeTwo${levelTwoProject.projectID}" parent="incomeOne${key}">
                                        <td></td>
                                        <td>${levelTwoProject.projectName}</td>
                                        <td>${levelTwoProject.projectAmount}</td>
                                        <td><i class="icon-edit icon-large" style="cursor:pointer"></i>&nbsp;&nbsp;&nbsp;&nbsp;<i class="icon-trash icon-large" style="cursor:pointer"></i></td>
                                    </tr>
                                    </#list>
                                </#if>
                            <tr id="incomeTwo${key}btn" parent="incomeOne${key}">
                                <td></td>
                                <td><a class="btn btn-info" id="addIncome${key}ProTwo"><i class="icon-plus-sign-alt icon-large"></i>&nbsp;&nbsp;<@spring.message 'text.addProTwo'/></a></td>
                                <td></td>
                                <td></td>
                            </tr>
                            </#list>
                        </#if>
                        <tr id="incomeOneAddBtn">
                            <td colspan="4" align="center"><a class="btn btn-info" id="addIncomeProOne"><i class="icon-plus-sign-alt icon-large"></i>&nbsp;&nbsp;<@spring.message 'text.addProOne'/></a></td>
                        </tr>
                        </tbody>
                    </table>
                </div>
                <div id="block_expendTab">
                    <table class="table table-hover">
                        <thead>
                        <tr>
                            <th width="225px"><@spring.message 'nav.settings.proOne'/></th>
                            <th width="350px"><@spring.message 'nav.settings.proTwo'/></th>
                            <th width="185px"><@spring.message 'nav.settings.proAmount'/></th>
                            <th width="240px"><@spring.message 'nav.settings.operation'/></th>
                        </tr>
                        </thead>
                        <tbody>
                        <#if (expendNode?size)!=0>
                            <#list expendNode?keys as key>
                            <tr id="expendOne${key}">
                                <td>${expendNode[key].projectName}</td>
                                <td></td>
                                <td>${expendNode[key].projectAmount}</td>
                                <td><i class="icon-edit icon-large" style="cursor:pointer"></i>&nbsp;&nbsp;&nbsp;&nbsp;<i class="icon-trash icon-large" style="cursor:pointer"></i></td>
                            </tr>
                                <#if (expendNode[key].levelTwoProjectList?size)!=0>
                                    <#list expendNode[key].levelTwoProjectList as levelTwoProject>
                                    <tr id="expendTwo${levelTwoProject.projectID}" parent="expendOne${key}">
                                        <td></td>
                                        <td>${levelTwoProject.projectName}</td>
                                        <td>${levelTwoProject.projectAmount}</td>
                                        <td><i class="icon-edit icon-large" style="cursor:pointer"></i>&nbsp;&nbsp;&nbsp;&nbsp;<i class="icon-trash icon-large" style="cursor:pointer"></i></td>
                                    </tr>
                                    </#list>
                                </#if>
                            <tr id="expendTwo${key}btn" parent="expendOne${key}">
                                <td></td>
                                <td><a class="btn btn-info" id="addExpend${key}ProTwo"><i class="icon-plus-sign-alt icon-large"></i>&nbsp;&nbsp;<@spring.message 'text.addProTwo'/></a></td>
                                <td></td>
                                <td></td>
                            </tr>
                            </#list>
                        </#if>
                        <tr id="expendOneAddBtn">
                            <td colspan="4" align="center"><a class="btn btn-info" id="addExpendProOne"><i class="icon-plus-sign-alt icon-large"></i>&nbsp;&nbsp;<@spring.message 'text.addProOne'/></a></td>
                        </tr>
                        </tbody>
                    </table>
                </div>
                <div id="block_application"></div>
                <div id=block_personal"></div>
            </div>
        </div>
        <div id="modifyPanel" style="display:none;">
            <div align="center"><h3><@spring.message 'text.modifyProName'/></h3></div>
            <form id="modifyName" name="modifyName">
                <input id="proId" name="proId" type="hidden"/>
                <input id="proLevel" name="proLevel" type="hidden"/>
                <div class="form-group">
                    <label for="proNameModify"><@spring.message 'text.proName'/>:</label>
                    <input type="text" name="proNameModify" id="proNameModify" class="form-control" tabindex="1">
                </div>
                <input type="button" class="btn btn-lg btn-primary btn-block hidemodal" name="proNameModifyBtn" id="proNameModifyBtn" value="<@spring.message 'button.submit'/>" tabindex="2">
            </form>
        </div>
        <div id="addProOnePanel" style="display:none;">
            <div align="center"><h3><@spring.message 'text.addProOne'/></h3></div>
            <form id="addProOne" name="addProOne">
                <input id="proOneNameType" name="proOneNameType" type="hidden"/>
                <div class="form-group">
                    <label for="proOneNameAdd"><@spring.message 'nav.settings.proOne'/>:</label>
                    <input type="text" name="proOneNameAdd" id="proOneNameAdd" class="form-control" tabindex="1">
                </div>
                <input type="button" class="btn btn-lg btn-primary btn-block hidemodal" name="proOneNameAddBtn" id="proOneNameAddBtn" value="<@spring.message 'button.submit'/>" tabindex="2">
            </form>
        </div>
        <div id="addProTwoPanel" style="display:none;">
            <div align="center"><h3><@spring.message 'text.addProTwo'/></h3></div>
            <form id="addProTwo" name="addProTwo">
                <input id="proOneId" name="proOneId" type="hidden"/>
                <div class="form-group">
                    <label for="proOneName"><@spring.message 'nav.settings.proOne'/>:</label>
                    <input type="text" name="proOneName" id="proOneName" class="form-control" tabindex="1" readonly="readonly">
                </div>
                <div class="form-group">
                    <label for="proTwoNameAdd"><@spring.message 'nav.settings.proTwo'/>:</label>
                    <input type="text" name="proTwoNameAdd" id="proTwoNameAdd" class="form-control" tabindex="2">
                </div>
                <input type="button" class="btn btn-lg btn-primary btn-block hidemodal" name="proTwoNameAddBtn" id="proTwoNameAddBtn" value="<@spring.message 'button.submit'/>" tabindex="3">
            </form>
        </div>
    </body>
    <script type="text/javascript" src="../JavaScript/jquery-2.1.3.min.js"></script>
    <script type="text/javascript" src="../JavaScript/bootstrap.min.js"></script>
    <script type="text/javascript" src="../JavaScript/jquery.leanModal.min.js"></script>
    <script type="text/javascript" src="../JavaScript/normal.js" charset="UTF-8"></script>
</html>