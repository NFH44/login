//国籍下拉列表查询
var na;
var ids;
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
                    }
                })
            })
        }
    })
})

function count() {
    var sav ="id="+$("#regionId").val()+"&gunName="+$("#queryName").val()
        +"&Lv="+$("#queryLv").val()+"&caliber="+$("#queryCali").val()
        +"&gunType="+$("#queryType").val()+"&note="+$("#queryNote").val();

    $.ajax({
        url:"/queryListCount",
        type:"post",
        data:sav,
        success:function (data) {
            $("#spanPage").text(data);
        }
    })
}

/*查询*/
function query() {
    $("#span").hide();
    if($("#regionId").val() == ""){
        alert("选择国籍");
        return;
    }

    var currPageIndex = 0;
    var currPageSize = 10;
    var des = "asc";
    var sav ="id="+$("#regionId").val()+"&gunName="+$("#queryName").val()+"&Lv="+$("#queryLv").val()+"&caliber="+$("#queryCali").val()
        +"&gunType="+$("#queryType").val()+"&note="+$("#queryNote").val()+"&sortName="+$("input[name='Lv']").attr("id")
        +"&sortOrder="+des+"&currPageIndex="+currPageIndex+"&currPageSize="+currPageSize;

    $.ajax({
        url:"/queryList",
        type:"post",
        data:sav,
        success:function (data) {
            console.info(data);
            if (data == 0){
                $("#span").show();
            }else {
                $("#span").hide();
            }
            $(".table tr:not(:first)").empty();
            $.each(data,function(i,result){
                var trs = $("#tb");
                if (result["note"] == null){
                    result["note"]="";
                }
                var sh = "<tr id='"+result["id"]+"'><td>"+na+"</td><td>"+result["gunName"]+"</td><td>"+
                    result["lv"]+"</td><td>"+result["angle"]+"</td><td>"+result["rotSpeet"]+"</td><td>"+
                    result["loadTime"]+"</td><td>"+result["muzzV"]+"</td><td>"+result["price"]+"</td><td>"+
                    result["caliber"]+"</td><td>"+result["gunType"]+"</td><td>"+result["note"]+"</td></tr>";
                trs.append(sh);
            })
        }
    });
    count();
}

/*添加*/
$(function () {
    $.each(datas, function (i, res) {
        var opts = "<option value=" + res["id"] + ">" + res["name"] + "</option>";
        $("#sel1").append(opts);
        $("#sel1").on("change", function () {
            var ids = $("#sel1").val();
            if (ids == res["id"]) {
                na = res["name"];
            }
        })
    })
})


function inser() {
    $("input").val("").focus();
    $("a").click(function () {
        $("#up").hide()
    })
    var vas = $("#myFrom").serialize();
    $.ajax({
        url:"/gunInsert",
        type:"post",
        data:vas,
        success:function (data) {
            alert(data);
            query();
        }
    })
}


/*更新*/
function cli() {
    $(".table > tbody > tr").click(function () {
        $("#myModal").modal("show");
        $("#save").hide();
        var lsid = $(this).attr("id");
        var col = $(this).find("td").length;
        var arr = new Array();
        for(var i=0;i<col;i++){
            arr.push($(this).children().eq(i).text());
        }
        $("#id").val(lsid);
        $("#sel1").val(ids);
        $("#gunName").val(arr[1]);
        $("#Lv").val(arr[2]);
        $("#angle").val(arr[3]);
        $("#rotSpeet").val(arr[4]);
        $("#loadTime").val(arr[5]);
        $("#muzzV").val(arr[6]);
        $("#Price").val(arr[7]);
        $("#caliber").val(arr[8]);
        $("#gunType").val(arr[9]);
        $("#note").val(arr[10]);
    });
};
function update() {
    var id = $("#id").val();
    var vas = $("#myFrom").serialize();
    $.ajax({
        url:"/gunUpdate",
        type:"post",
        data:"id="+id+"&"+vas,
        success:function (data) {
            alert(data);
            query();
        }
    })
}

//删除
function gunDel() {
    var id = $("#id").val();
    alert(id)
    $.ajax({
        url:"/gunDelete",
        type:"post",
        data:"id="+$("#id").val(),
        success:function (data) {
            alert(data);
            query();
        }
    })
}