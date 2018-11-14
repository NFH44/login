var na;
var ids;
//国籍下拉列表查询
$(document).ready(function () {
    $.ajax({
        type:"post",
        url:"/list",
        async : false,
        success:function (data) {
            datas = data;
            console.info(data);
            //清空下拉选项除第一行以外的其他数据
            $("#regionId option:not(:first)").empty();
            $.each(data, function (i, result) {
               var opts = "<option value=" + result["id"] + ">" + result["name"] + "</option>";
                $("#regionId").append(opts);
                $("#regionId").on("change",function () {
                    ids = $("#regionId").val();
                    if (ids == result["id"]){
                        na = result["name"];
                        console.info(na);
                        console.info(ids);
                    }
                })
            })
        }
    })
})
//封装ajax
var ajaxs = {
    ajax:function (url,dataa,callback) {
        $.ajax({
            type:"post",
            url:url,
            data:dataa,
            success:function (data) {
                callback.call(this,data);
            }
        })
    }
}

var curNum;
function count() {
    var da = "id="+$("#regionId").val()+"&shipName="+$("#queryName").val()+"&Lv="+$("#queryLv").val()
        +"&shipType="+$("#queryType").val()+"&note="+$("#queryNote").val();
    $.ajax({
        url:"/count",
        type:"post",
        data:da,
        success:function (data) {
            curNum = data;
            $("#spanPage").text(data);
        }
    })
}

//查询战舰
function select() {
    $("#span").hide();
    if($("#regionId").val() == ""){
        alert("选择国籍");
        return;
    }
    var currPageIndex = 0;
    var currPageSize = 10;
    var des = "asc";
    var dataa ="id="+$("#regionId").val()+"&shipName="+$("#queryName").val()+"&Lv="+$("#queryLv").val()
    +"&shipType="+$("#queryType").val()+"&note="+$("#queryNote").val()+"&sortName="+$("input[name='Lv']").attr("id")
    +"&sortOrder="+des+"&currPageIndex="+currPageIndex+"&currPageSize="+currPageSize;

    ajaxs.ajax("/ship",""+dataa+"",callback);
    count();

}

function callback(data) {
        console.info(data);
        $(".table tr:not(:first)").empty();
        $.each(data,function(i,result){
            var trs = $("#tb");
            if (result["note"] == null){
                result["note"]="";
            }
            var sh = "<tr id='"+result["id"]+"'><td>"+na+"</td><td>"+result["shipName"]+"</td><td>"+
                result["lv"]+"</td><td>"+result["shipType"]+"</td><td>"+result["price"]+"</td><td>"+
                result["dp"]+"</td><td>"+result["displacement"]+"</td><td>"+result["soldier"]+"</td><td>"+
                result["pos"]+"</td><td>"+result["aid"]+"</td><td>"+result["lowSpeed"]+"</td><td>"+
                result["extSpeed"]+"</td><td>"+result["note"]+"</td></tr>";
            trs.append(sh);
        })
        pri();
}
//添加战舰
$(function () {
    $.each(datas, function (i, res) {
        var opts = "<option value=" + res["id"] + ">" + res["name"] + "</option>";
        $("#sel1").append(opts);
        $("#sel1").on("change", function () {
            var ids = $("#sel1").val();
            if (ids == res["id"]) {
                na = res["name"];
                console.info(na);
                console.info(ids);
            }
        })
    })
})
function insert() {
    var vas = $("#myFrom").serialize();
    console.info(vas);
    $.ajax({
        url:"/add",
        type:"post",
        data:vas,
        success:function (data) {
            alert(data);
            select();
            $("#myFrom input").each(function (i,item) {
                $(this).val("");
            })
            $("#myFrom select").each(function (i,item) {
                $(this).val("");
            })
        }
    })
}
//更新信息
function pri() {
    $(".table > tbody > tr").click(function () {
        $("#myModalAndUpdate").modal("show");
        var ids = $(this).attr("id");
        var col = $(this).find("td").length;
        var arr = new Array();
        for(var i=0;i<col;i++){
            arr.push($(this).children().eq(i).text());
        }
        console.info(arr);
        $("#id").val(ids);
        $("#nation").val(arr[0]);
        $("#shipNames").val(arr[1]);
        $("#Lvs").val(arr[2]);
        $("#shipTypes").val(arr[3]);
        $("#Prices").val(arr[4]);
        $("#DPs").val(arr[5]);
        $("#Displacements").val(arr[6]);
        $("#Soldiers").val(arr[7]);
        $("#Poss").val(arr[8]);
        $("#Aids").val(arr[9]);
        $("#lowSpeeds").val(arr[10]);
        $("#extSpeeds").val(arr[11]);
        $("#notes").val(arr[12]);
    });
};
function update() {
    var id = $("#id").val();
    console.info(id);
    var vas = $(".update").serialize();
    //console.info(vas)
    $.ajax({
        url:"/shipUpdate",
        type:"post",
        data:"id="+id+"&nationId="+ids+"&"+vas,
        success:function (data) {
            alert(data);
            select();
        }
    })
}
//删除信息
function del() {
    $.ajax({
        url:"/shipDelete",
        type:"post",
        data:"id="+$("#id").val(),
        success:function (data) {
            alert(data);
            select();
        }
    })
}
