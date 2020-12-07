function fillProvince() {

    $.ajax({
        type: "POST",
        url: "queryProvinceSchool",
        contentType: "application/x-www-form-urlencoded;charset=utf-8",
        data: "",
        dataType: "json",
        success: function(response) {
            //增加一个option
            // provinceElement = document.getElementById("areaid");
            //清空
            //provinceElement.options.length = 0;
            //provinceElement.add(new Option("请选择省份", ""));
            //console.log(info[2].pid);
            for (var index = 0; index < response.length; index++) {
                //一个li的数值
                //var str = "<li id='" + response[index].area_id + "'>" + response[index].area_name + "</li>";
                str = "<li  id='" + response[index].area_id + "'>" + response[index].area_name + "</li>";
                $("#areaid").append("<li onclick='getarea_id(this)' id='" + response[index].area_id + "'>" + response[index].area_name + "</li>");
            }
        }
    });

}

function fillschool() {
    $.ajax({
        type: "POST",
        url: "queryProvinceSchool",
        contentType: "application/x-www-form-urlencoded;charset=utf-8",
        data: { "area_id": area_id },
        dataType: "json",
        success: function(response) {
            //增加一个option
            //provinceElement = document.getElementById("school");
            //清空
            // provinceElement.options.length = 0;
            // provinceElement.add(new Option("请选择学校", ""));
            //console.log(info[2].pid);
            var count = 0;
            for (var index = 0; index < response.length; index++) {
                count++;
                $("#schoolid").append("<li  id='" + response[index].school_id + "'>" +"<span>"+ count +"</span>"+ "." + response[index].school_name + "</li>");
            }
        }
    });

}
window.onload = function() {
        //首先调用函数,填充下拉框	
        //fillProvince();
        fillProvince();

    }
    // $(function() {
    //     $(document).click(function(e) { // 在页面任意位置点击而触发此事件
    //         var v_id = $(e.target).attr('id');
    //     })

// });　　
//拿到id的数值
var area_id;

function getarea_id(e) {
    //清空所有的li
    $("#schoolid").find("li").remove();
    area_id = e.id;
    fillschool();
}