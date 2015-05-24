/**
 * Created by Fred on 2015/5/17.
 */
$(document).ready(function(){
    var width = ($(window).width()-1000)/2;
    $('.headDiv').css('marginLeft',width+'px');
    $('.contentDiv').css('marginLeft',width+'px');
    $('#div_expend').hide();

    //顶部的导航按钮事件处理
    $('body').on('click','li[id^="nav_tab_"]',function(){
        if($(this).hasClass('active')){
        }
        else{
            $(this).addClass('active').siblings().removeClass('active');
        }
        var tabId = $(this).attr('id');
        if(tabId == 'nav_tab_incomeForm'){
            $('#div_income').show().siblings('div').hide();
        }
        else if(tabId == 'nav_tab_expendForm'){
            $('#div_expend').show().siblings('div').hide();
        }
    });
})