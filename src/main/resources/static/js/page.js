function pages() {
    $(".page-item").on("click,.size");
    next();
}



function next() {
    var currPageSize = 10;
    //总页数

    var toNum = (curNum + currPageSize - 1) / currPageSize;
    return toNum;
}
