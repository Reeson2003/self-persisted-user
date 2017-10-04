if (window.UserApp == undefined) {
    UserApp = {};
}
UserApp.Models = {};
UserApp.Views = {};
UserApp.Collections = {};


UserApp.Models.User = Backbone.Model.extend({
    defaults: {
        firstName: "",
        middleName: "",
        lastName: "",
        birthDate: "",
        email: "",
        login: "",
        password: "",
        loggedIn: "",
        registerDate: "",
        updateDate: ""
    },

    delete: function () {
        // todo
    }

});

UserApp.Collections.Users = Backbone.Collection.extend({
    model: UserApp.Models.User,
    update: function () {
        $.ajax({
            url: '/users',
            method: 'GET',
            cache: false,
            success: function (response) {
                this.models = response;
            }
        })
    }
});

var Users = new UserApp.Collections.Users;

UserApp.Views.UserListItem = Backbone.View.extend({
    tagName: 'div',
    template: _.template($("#userListItemTemplate").html()),
    events: {
        'click': console.log("CLICK")
    },
    initialize: function (user) {
        this.model = user;
        this.model.bind('change', this.render, this);
        this.model.bind('destroy', this.remove, this);
    },
    render: function () {
        this.$el.html(this.template(this.model.toJSON()));
    }
});

UserApp.Views.UserList = Backbone.View.extend({
    tagName: 'ul',
    el: $('#userList'),
    model: Users,
    render: function () {
        var html = '';
        Users.each(function (user) {
            html += '<li>';
            html += user.render();
            html += '</li>'
            console.log(html)
        })
    }
});


/*
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

 */
