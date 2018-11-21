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

//查询
function query() {
    if($("#regionId").val() == ""){
        alert("选择国籍");
        return;
    }
    var currPageIndex = 0;
    var currPageSize = 10;

    $(".container a").click(function () {
        $(this).text();
    })

    var des = "asc";
    var vas ="id="+$("#regionId").val()+"&name="+$("#queryName").val()+"&lv="+$("#queryLv").val()
    +"&amount="+$("#queryAmount").val()+"&caliber="+$("#queryCali").val()+"&sortName="+$("input[name='lv']").attr("id")
    +"&sortOrder="+des+"&currPageIndex="+currPageIndex+"&currPageSize="+currPageSize;
    $.ajax({
        type:"post",
        url:"/torpedoList",
        data:vas,
        success:function (data) {
            console.info(data);
            if (data[0] == 0){
                $("#span").show();
            }else {
                $("#span").hide();
            }
            $(".table tr:not(:first)").empty();
            $.each(data[0],function(i,result){
                var trs = $("#tb");
                var sh = "<tr id='"+result["id"]+"'><td>"+na+"</td><td>"+result["name"]+"</td><td>"+
                    result["lv"]+"</td><td>"+result["price"]+"</td><td>"+result["amount"]+"</td><td>"+
                    result["time"]+"</td><td>"+result["caliber"]+"</td></tr>";
                trs.append(sh);

                for (var i=0;i<data.length;i++){
                    if (i == 1){
                        var toPage = data[i];
                        $("#spanPage").text(toPage)
                    }else if(i == 2){
                        var curNum = data[i];
                        $("#toPage").text(curNum);
                    }
                }
            })
        }
    })
    torpedoQuery();

}

function enter() {
    var vas = $("#id").val();
    $.ajax({
        url:"/torpedoQueryId",
        type:"post",
        data:"id="+vas,
        success:function (data) {
            console.info(data)
            if (data.length == 0){
                torpedo();
            }else {
                update();
            }
        }
    })

}
//添加
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

function torpedo() {
    var vas = $("#myFrom").serialize();
    console.info(vas);
    $.ajax({
        url:"/torpedoAdd",
        type:"post",
        data:vas,
        success:function (data) {
            alert(data);
            query();
            $("#myFrom input").each(function (i,item) {
                $(this).val("");
            })
            $("#myFrom select").each(function (i,item) {
                $(this).val("");
            })
        }
    })
}
//更新
function torpedoQuery() {
    $(".table > tbody > tr").click(function () {
        $("#myModal").modal("show");
        var lsid = $(this).attr("id");
        var col = $(this).find("td").length;
        var arr = new Array();
        for(var i=0;i<col;i++){
            arr.push($(this).children().eq(i).text());
        }
        $("#id").val(lsid);
        $("#sel1").val(ids);
        $("#torpedoName").val(arr[1]);
        $("#lv").val(arr[2]);
        $("#price").val(arr[3]);
        $("#amount").val(arr[4]);
        $("#time").val(arr[5]);
        $("#caliber").val(arr[6]);
    });
};
function update() {
    var id = $("#id").val();
    console.info(id);
    var vas = $("#myFrom").serialize();
    $.ajax({
        url:"/torpedoUpdate",
        type:"post",
        data:"id="+id+"&"+vas,
        success:function (data) {
            alert(data);
            query();
        }
    })
}
//删除
function torpedoDel() {
    $.ajax({
        url:"/torpedoDelete",
        type:"post",
        data:"id="+$("#id").val(),
        success:function (data) {
            alert(data);
            query();
            query();
        }
    })
}
