/**
 * Created by Fred on 2015/5/24.
 */
$.fn.datepicker.dates['zh'] = {
    days: ["星期日", "星期一", "星期二", "星期三", "星期四", "星期日五", "星期六"],
    daysShort: ["周日", "周一", "周二", "周三", "周四", "周五", "周六"],
    daysMin: ["日", "一", "二", "三", "四", "五", "六"],
    months: ["01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12"],
    monthsShort: ["1月", "2月", "3月", "4月", "5月", "6月", "7月", "8月", "9月", "10月", "11月", "12月"],
    today: "今天",
    clear: "清除"
};

$(function(){
    $('.form_datetime').datepicker({
        show:true,
        format:'yyyy-MM-dd',
        weekStart:1,
        autoClose:true,
        todayHighlight:true,
        todayBtn:true,
        language:'zh',
        pickerPosition:'bottom-left'
    });
})