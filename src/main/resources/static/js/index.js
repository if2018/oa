//获取房产的id属性
var first = null;
//根据id获取的数据
var msg = null;

//post请求报403错误的解决
var token = $("meta[name='_csrf']").attr("content");
var header = $("meta[name='_csrf_header']").attr("content");
$(document).ajaxSend(function(e, xhr, options) {
    xhr.setRequestHeader(header, token);
});

$(function () {
    AccessHouse()

})
//房源获取
function AccessHouse() {
    $.ajax({
        url:"/operating/houseSourceList",
        success:function (data) {
            var dataList=data.data.content
            new Vue({
                el: '#app',
                data: {
                    items:dataList
                }
            })
        },
        error:function () {
            alert("服务器异常，请刷新重试")
        }
    })
}
//获取详情页的id并执行查询
function inDetail(id) {
    //alert("详情正在开发中....")
    first=$(id).children("td").get(0).innerText
    //alert("id为"+first)
    inquireHouseId(first)
}
//根据id查询房子
function inquireHouseId(id){
    $.ajax({
        url:"/operating/houseSourceHouseId",
        data:{
            houseId : id
        },
        success: function (data) {
            //alert(data)
            msg=data.data;
            $("#recipient_detailed_name").attr("value",msg.houseEstate);
            $("#house_detailed_number").attr("value",msg.houseNumber);
            $("#house_detailed_size").attr("value",msg.houseSize);
            $("#house_detailed_price").attr("value",msg.totalPrice);
            $("#landlord_detailed_name").attr("value",msg.landlordName);
            $("#landlord_detailed_phone").attr("value",msg.landlordPhone);
            $("#message_detailed_text").attr("value",(msg.houseRemark == null) ?  "空" : msg.houseRemark );
            $(".house_id").text(msg.houseId);
            $(".broker_name").text(msg.broker);

            var access=msg.accessRecords;

            $("#access_text").empty();
            //遍历回访记录
            access.forEach(function (msg ) {
                var date=dateFormat(msg.setupTime);
                // console.log(id.record + " " + date)

                $("#access_text").append('<p class="form-control access_p">'
                    + msg.userName
                    + '&nbsp;&nbsp;&nbsp;&nbsp;--&nbsp;&nbsp;&nbsp;&nbsp;'
                    + date
                    + '&nbsp;&nbsp;&nbsp;&nbsp;'
                    + msg.record
                    + '</p>')
            })
        },
        error:function () {
            alert("系统异常！！！请稍后重试")
        }
    })
}

//添加房源按钮组,绑定信息的调用
$('#exampleModal').on('show.bs.modal', function (event) {
    var button = $(event.relatedTarget) // Button that triggered the modal
    var recipient = button.data('whatever') // Extract info from data-* attributes
    // If necessary, you could initiate an AJAX request here (and then do the updating in a callback).
    // Update the modal's content. We'll use jQuery here, but you could use a data binding library or other methods instead.
    var modal = $(this)
    modal.find('.modal-title').text('房源' + recipient)
    //modal.find('.modal-body input').val(recipient)
})



//添加房源
function submitHouse() {
    //alert("111")
    var houseEstate=$("#recipient_name").val();
    var houseNumber=$("#house_number").val();
    var houseSize=$("#house_size").val();
    var totalPrice=$("#total_price").val();
    var houseRemark=$("#message_text").val();
    var landlordName=$("#landlord_name").val();
    var landlordPhone=$("#landlord_phone").val();
    var accessRecord=$("#access_record").val();
    //var nav_a=$("#nav_a").innerHTML
    //alert(nav_a);
    var input  = /^[\s]*$/;

    if(houseEstate.length == 0 || input.test(houseEstate)){
        alert("小区不能为空");
    }else
    if(houseNumber === "" || input.test(houseNumber)){
        alert("房号不能为空")
    }else
    if(houseSize === "" || input.test(houseSize)){
        alert("面积不能为空")
    }else
    if(totalPrice === "" || input.test(totalPrice)){
        alert("价格不能为空")
    }else
    if(landlordName === "" || input.test(landlordName)){
        alert("房东姓名不能为空")
    }else
    if(landlordPhone === "" || input.test(landlordPhone)){
        alert("房东电话不能为空")
    }else {
        $.ajax({
            type:"post",
            url:"/operating/setupData",
            data:{
                houseEstate : houseEstate,
                houseNumber : houseNumber,
                houseSize : houseSize,
                totalPrice : totalPrice,
                houseRemark : houseRemark,
                landlordName : landlordName,
                landlordPhone : landlordPhone,
                accessRecord : accessRecord
            },
            success:function (data) {
                window.location.href="/index";
                alert(data);

            },
            error:function () {
                alert("添加失败")
            }
        });
        $(".myModal").modal('hide')
    }


    //alert(houseEstate)


}

//根据json中的日期格式，转换成yyyy-mm-dd HH:mm:ss
// function jsonDateFormat(jsonDate) {//json日期格式转换为正常格式
//     try {
//         var date = new Date(parseInt(jsonDate.replace("/Date(", "").replace(")/", ""), 10));
//         var month = date.getMonth() + 1 < 10 ? "0" + (date.getMonth() + 1) : date.getMonth() + 1;
//         var day = date.getDate() < 10 ? "0" + date.getDate() : date.getDate();
//         var hours = date.getHours();
//         var minutes = date.getMinutes();
//         var seconds = date.getSeconds();
//         var milliseconds = date.getMilliseconds();
//         return date.getFullYear() + "-" + month + "-" + day + " " + hours + ":" + minutes + ":" + seconds + "." + milliseconds;
//     } catch (ex) {
//         return "";
//     }
// }
//格式化json传来的时间 2018-08-12T01:37:37.000+0000
function dateFormat(time) {
    var d = new Date(time);

    return d.getFullYear() + '-' + (d.getMonth() + 1) + '-' + d.getDate() + ' ' + d.getHours() + ':' + d.getMinutes() + ':' + d.getSeconds();;
}

//添加回访记录
function access_add() {
    var accessText=$(".access_text").val();
    if(accessText === ""){
        alert("不能为空")
    }

    //console.log(accessText)
    //console.log(getCookie("userName"));
    var userName=getCookie("userName");
    if(first == null){
        alert("未知错误！请刷新重试！")
    }else {
        $.ajax({
            url:"/operating/accessAdd",
            type:"post",
            data:{
                'houseId' : first,
                'record' : accessText,
                'userName' : userName
            },
            success:function (data) {
                alert(data);
                $(".access_modal").modal('hide');
                var id=$(".house_id").text();
                inquireHouseId(id);
            },
            error:function () {
                alert("添加失败，请稍后重试！！！")
            }
        })
    }

}
//删除cookie
function delCookie(name){//为了删除指定名称的cookie，可以将其过期时间设定为一个过去的时间
    var date = new Date();
    date.setTime(date.getTime() - 10000);
    document.cookie = name + "=a; expires=" + date.toGMTString();
}
//获取cookie
function getCookie(cname) {
    var name = cname + "=";
    var ca = document.cookie.split(';');
    for(var i=0; i<ca.length; i++) {
        var c = ca[i];
        while (c.charAt(0)==' ') c = c.substring(1);
        if (c.indexOf(name) != -1) return c.substring(name.length, c.length);
    }
    return "";
}
//修改房源信息
function updataHouse() {
    var houseEstate=$("#recipient_detailed_name").val();
    var houseNumber=$("#house_detailed_number").val();
    var houseSize=$("#house_detailed_size").val();
    var totalPrice=$("#house_detailed_price").val();
    var houseRemark=$("#message_detailed_text").val();
    var landlordName=$("#landlord_detailed_name").val();
    var landlordPhone=$("#landlord_detailed_phone").val();
    var broker=$(".broker_name").text();

    var input  = /^[\s]*$/;

    if(houseEstate.length == 0 || input.test(houseEstate)){
        alert("小区不能为空");
    }else
    if(houseNumber === "" || input.test(houseNumber)){
        alert("房号不能为空")
    }else
    if(houseSize === "" || input.test(houseSize)){
        alert("面积不能为空")
    }else
    if(totalPrice === "" || input.test(totalPrice)){
        alert("价格不能为空")
    }else
    if(landlordName === "" || input.test(landlordName)){
        alert("房东姓名不能为空")
    }else
    if(landlordPhone === "" || input.test(landlordPhone)){
        alert("房东电话不能为空")
    }else {
        if(houseRemark == "空"){
            houseRemark = null;
        }
        if(houseEstate != msg.houseEstate || houseNumber != msg.houseNumber || houseSize != msg.houseSize || totalPrice != msg.totalPrice
            || houseRemark != msg.houseRemark || landlordName != msg.landlordName || landlordPhone != msg.landlordPhone){
            sendUpData();
        }else {
            $(".bs-example-modal-lg").modal("hide");
        }
    }


    function sendUpData() {
        if(confirm("确定修改吗？")){
            var houseId=$(".house_id").text();
            $.ajax({
                url : "/operating/upDataHouse",
                type : "post",
                data : {
                    houseId : houseId,
                    houseEstate : houseEstate,
                    houseNumber : houseNumber,
                    houseSize : houseSize,
                    totalPrice : totalPrice,
                    houseRemark : houseRemark,
                    landlordName : landlordName,
                    landlordPhone : landlordPhone,
                    broker : broker
                },
                success: function (data) {
                    window.location.href="/index";
                    $(".bs-example-modal-lg").modal("hide");
                    alert(data)
                },
                error: function () {
                    alert("修改失败，请刷新重试！")
                }
            })
            //alert("修改成功")
        }else{
            window.location.href="/index"
        }
    }
}
//房源转公
function turnToThePublic() {

    if(confirm("确定转公吗？")){
        var houseId=$(".house_id").text();
        //var broker=$(".broker_name").text();

        $.ajax({
            url : "/operating/turnToThePublic",
            type : "post",
            data : {
                houseId : houseId,
                broker : "公盘"
            },
            success: function (data) {
                window.location.href="/index";
                $(".bs-example-modal-lg").modal("hide");
                alert(data)
            },
            error: function () {
                alert("无法转公，请刷新重试！")
            }
        })
    }

    

}
//搜索功能
function searchFor() {

    var text=$(".search_for").val();
    //console.log(text);
    if(text === "" && text === undefined){
        AccessHouse();
    }else{
        $.ajax({
            url:"/operating/fuzzyQueryHouse",
            data:{
                name:text
            },
            success:function (data) {

                var list=data.dataList;

                $(".house_theme").empty();

                $.each(list,function(index,value){
                    //console.log(index+"+"+value);
                    $(".house_theme")
                        .append('<tr onclick=inDetail(this); data-toggle="modal" data-target=".bs-example-modal-lg"  v-for="item in items" id="house_td">' +
                            '<td>'+value.houseId+'</td>\n' +
                            '<td>'+value.houseEstate+'</td>\n' +
                            '<td>'+value.houseNumber+'</td>\n' +
                            '<td>'+value.houseSize+'</td>\n' +
                            '<td>'+value.totalPrice+'</td>\n' +
                            '<td>'+value.broker+'</td>\n' +
                            '<td>'+value.landlordPhone+'</td>'+
                            '</tr>')
                });

            },
            error:function (data) {
                alert("系统异常！！！")
            }
        })
    }
    
}
