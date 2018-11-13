$(function(){
    var currentPage=Number(20);
    var pageNum=Number(50);

    $("#page_btn2").text(currentPage-2);
    $("#page_btn3").text(currentPage-1);
    $("#page_btn4").text(currentPage);
    $("#page_btn5").text(currentPage+1);
    $("#page_btn6").text(currentPage+2);
    $("#page_btn7").text(pageNum);


    $("#page_btn4").css("background-color","#4f90fb");
    $("#page_btn4").css("border","1px solid #ddd");
    $("#page_btn4").css("color","#fff");


    if(currentPage==1)
    {
        $("#prePage").hide();
    }

    if(currentPage==pageNum)
    {
        $("#sufPage").hide();
    }


    if(currentPage<=3){
        $("#prePoint").hide();
        $("##page_btn1").hide();
    }
    else if(currentPage==4){
        $("#prePoint").hide();
    }

    if(currentPage==1)
    {
        $("##page_btn2").hide();
        $("##page_btn3").hide();
    }
    else if(currentPage==2)
    {
        $("##page_btn2").hide();
    }

    if(currentPage>=pageNum-2){
        $("#sufPoint").hide();
        $("##page_btn7").hide();
    }
    else if(currentPage==pageNum-3){
        $("#sufPoint").hide();
    }

    if(currentPage==pageNum)
    {
        $("#page_btn5").hide();
        $("#page_btn6").hide();
    }

    if(currentPage==pageNum-1)
    {
        $("#page_btn6").hide();
    }
});
