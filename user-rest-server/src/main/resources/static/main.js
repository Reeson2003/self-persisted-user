$(document).ready(function () {
    console.log("Ready")
})

$(function () {
    var button = $("#button");
    button.on("click",function () {
        $.ajax({
            type: "GET",
            url: "/users",
            success: function (response) {
                console.log(response)
            }
        })
    });
})