function cli() {
    $(".container a").click(function () {
        var currPageSize = $(this).text();
        currPageSize++;
        alert(currPageSize)
    })
}