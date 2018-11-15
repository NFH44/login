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
                        console.info(na);
                        console.info(ids);
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
            console.info(data)
            $(".table tr:not(:first)").empty();
            $.each(data,function(i,result){
                var trs = $("#tb");
                if (result["note"] == null){
                    result["note"]="";
                }
                var sh = "<tr id='"+result["id"]+"'><td>"+na+"</td><td>"+result["gunName"]+"</td><td>"+
                    result["lv"]+"</td><td>"+result["price"]+"</td><td>"+result["caliber"]+"</td><td>"+
                    result["gunType"]+"</td><td>"+result["note"]+"</td></tr>";
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
                console.info(na);
                console.info(ids);
            }
        })
    })
})


function inser() {
    $('#myModal').modal();
    var vas = $("#myFrom").serialize();
    console.info(vas);
    $.ajax({
        url:"/gunInsert",
        type:"post",
        data:vas,
        success:function (data) {
            alert(data);
        }
    })
}


/*更新*/
function cli() {
    $(".table > tbody > tr").click(function () {
        /*$('#myModal').modal();
        $('h4 .modal-title').html("修改装备信息");*/
        var ids = $(this).attr("id");
        alert(ids)
        var col = $(this).find("td").length;
        var arr = new Array();
        for(var i=0;i<col;i++){
            arr.push($(this).children().eq(i).text());
        }
        console.info(arr);
        /*$("#id").val(ids);
        $("#sel1").val(arr[0]);
        $("#gunName").val(arr[1]);
        $("#Lv").val(arr[2]);
        $("#Price").val(arr[3]);
        $("#caliber").val(arr[4]);
        $("#gunType").val(arr[5]);
        $("#note").val(arr[6]);*/
    });
};
function update() {
    var id = $("#sel1").val();
    console.info(id);
    var vas = $(".update").serialize();
    //console.info(vas)
    $.ajax({
        url:"/gunUpdate",
        type:"post",
        data:"id="+id+"&nationId="+ids+"&"+vas,
        success:function (data) {
            alert(data);
            select();
        }
    })
}

//删除信息
function gunDel() {

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