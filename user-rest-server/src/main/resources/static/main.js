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

var UserTableView = Backbone.View.extend({
    el: '#userList',
    initialize: function () {
        console.log(this + " INITIALIZE");
    },
    render: function (userList) {
        var html = renderUserTable(userList);
        console.log(html);
        this.$el.html(html);
    }
});

var userTableView = new UserTableView();

userTableView.render(null);

function renderUserTable(userList) {
    var html = "<table id='userTable'>";
    html += "<tr id='userTableHeader'>";
    html += "<td>Number</td>";
    html += "<td>First name</td>";
    html += "<td>Middle name</td>";
    html += "<td>Last name</td>";
    html += "<td>Birth date</td>";
    html += "<td>email</td>";
    html += "<td>Login</td>";
    html += "<td>Password</td>";
    html += "<td>Logged in</td>";
    html += "<td>Register date</td>";
    html += "<td>Update date</td>";
    html += "</tr>";
    if (userList != null) {
        for (var i = 0; i < userList.length; i++) {
            html += "<tr id='user_" + userList[i].login + "'>";
            html += "<td>i</td>";
            html += "<td>" + userList[i].firstName + "</td>";
            html += "<td>" + userList[i].middleName + "</td>";
            html += "<td>" + userList[i].lastName + "</td>";
            html += "<td>" + userList[i].birthDate + "</td>";
            html += "<td>" + userList[i].email + "</td>";
            html += "<td>" + userList[i].login + "</td>";
            html += "<td>" + userList[i].password + "</td>";
            html += "<td>" + userList[i].loggedIn + "</td>";
            html += "<td>" + userList[i].registerDate + "</td>";
            html += "<td>" + userList[i].updateDate + "</td>";
            html += "</tr>";
        }
    }
    html += "</table>";
    return html;
}

$("#updateButton").on("click", function () {
    console.log("CLICK");
    getUserList();
})

function getUserList() {
    var array = [];
    $.ajax({
        type: "GET",
        url: "/users",
        success: function (response) {
            response.forEach(function (item) {
                array.push(new User(item));
            });
            userTableView.render(array);
        }
    });
}