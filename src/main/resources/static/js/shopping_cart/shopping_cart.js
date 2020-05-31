/**
 * Created by alone on 2017/5/18.
 */
$(function () {
//            按照下面这个方式添加新的元素，如果想在开头位置添加，就用first  before
//            $('.table_content:last').after("<tr class='table_content'><td><span>11111</span></td></tr>");
    calSum();
    var which = 0;
    $('.shipping_address').click(function () {
        var id = $(this).attr('id');
        $('.shipping_address').each(function () {
            if ($(this).attr('id')==id) {
                $(this).css({"border-color": "slateblue"});
                which = id;
            }else {
                $(this).css({"border-color": "rgba(0,0,0,0.1)"});
            }
            calSum();
        });
    });
//            -号，不能低于 1
    $('span.minus').click(function () {
        var num = $(this).siblings(".number").html();
        if (num>=2) {
            num--;
        }
        $(this).siblings(".number").html(num);
        var cost = $(this).parent().siblings(".cost").children("span").html();
        $(this).parent().siblings(".per_sum").children("span").html(returnFloat(cost*num));
        calSum();
    });
    $('span.add').click(function () {
        var num = $(this).siblings(".number").html();
        num++;
        $(this).siblings(".number").html(num);
        var cost = $(this).parent().siblings(".cost").children("span").html();
        $(this).parent().siblings(".per_sum").children("span").html(returnFloat(cost*num));
        calSum();
    });
    $('.table_content td.input_checkbox input').change(function () {
        calSum();
    });
/*    $('#all').change(function () {
        if($(this).is(':checked')){
            //循环下面所有checkbox
            $('.goodscheck').each(function(){
                //将checkbox状态改为选中
                $(this).prop("checked",true);
            });
        }else {
            $('.goodscheck').each(function () {
                $(this).removeAttr("checked", false);
            });
        }
        /!*if($(this).is(":checked")) {

            $('.goodscheck').each(function(){
                //将checkbox状态改为选中
                $(this).prop("checked",true);
            });
        }else {
            $("input[name='checkbox']").removeAttr("checked","true");
        }*!/
        calSum();
    });*/
//            保留两位小数
    function returnFloat(value){
        var value=Math.round(parseFloat(value)*100)/100;
        var xsd=value.toString().split(".");
        if(xsd.length==1){
            value=value.toString()+".00";
            return value;
        }
        if(xsd.length>1){
            if(xsd[1].length<2){
                value=value.toString()+"0";
            }
            return value;
        }
    }
//            计算总金额
    function calSum() {
        var sum = 0;
        $('.cart_content table tr.table_content').each(function () {
                sum  +=  parseFloat($(this).children(".per_sum").children("span").html());
        });
        sum = returnFloat(sum);
        $('.end_pay').children(".all_sum").children("span").html(sum);
    }
});