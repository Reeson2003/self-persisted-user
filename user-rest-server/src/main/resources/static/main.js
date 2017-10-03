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
                console.log(new User(response[0]));
            }
        })
    });
})

function User(data) {
    this.firstName = data.firstName;
    this.middleName = data.middleName;
    this.lastName = data.lastName;
    this.birthDate = new Date(data.birthDate);
    this.email = data.email;
    this.login = data.login;
    this.password = data.password;
    this.loggedIn = data.loggedIn;
    this.registerDate = new Date(data.registerDate);
    this.updateDate = new Date(data.updateDate);
}