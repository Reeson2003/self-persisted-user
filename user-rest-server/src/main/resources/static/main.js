if (window.UserApp == undefined) {
    UserApp = {};
}
UserApp.Models = {};
UserApp.Views = {};
UserApp.Collections = {};

/*
 |----------|
 |User model|
 |----------|
 */
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
    isDefaults: true,
    url: '/user',
    set: function (attributes, options) {
        attributes.birthDate = new Date(attributes.birthDate);
        attributes.registerDate = new Date(attributes.registerDate);
        attributes.updateDate = new Date(attributes.updateDate);
        return Backbone.Model.prototype.set.call(this, attributes, options)
    },
    sync: function () {
        var context = this;
        $.ajax({
            type: "GET",
            cache: false,
            url: this.url,
            data: {'login': this.get('login')},
            success: function (response) {
                if (response == "")
                    context.destroy();
                context.set(response);
            }
        })
    },
    add: function (callback) {
        var context = this;
        context['onAdd'] = callback;
        $.ajax({
            type: "POST",
            cache: false,
            url: this.url,
            data: {'login': this.get('login'), 'password': this.get('password')},
            success: function (response) {
                if (response === true) {
                    context.update();
                    context.onAdd();
                }
            }
        });
    },
    delete: function () {
        var context = this;
        $.ajax({
            type: "DELETE",
            cache: false,
            url: this.url + "?login=" + this.get('login'),
            success: function (response) {
                if (response === true)
                    context.destroy();
            }
        });
    },
    update: function () {
        var context = this;
        $.ajax({
            type: 'PUT',
            cache: false,
            url: this.url,
            data: JSON.stringify(this.attributes),
            contentType: 'application/json',
            success: function (response) {
                if (response === false)
                    context.destroy();
            }
        });
    }
});

UserApp.Collections.Users = Backbone.Collection.extend({
    model: UserApp.Models.User,
    url: '/users'
});


var Users = new UserApp.Collections.Users;

UserApp.Views.NewUserEditor = Backbone.View.extend({
    el: $('#newUserEditorHolder'),
    template: _.template($('#newUserEditorTemplate').html()),
    events: {
        'submit #newUserForm' : 'onSubmit'
    },
    render: function () {
        this.$el.html(this.template());
        return this;
    },
    onSubmit: function (event) {
        event.preventDefault();
        var formData = $('#newUserForm').serializeArray();
        var formObject = {};
        for (var i in formData) {
            formObject[formData[i]['name']] = formData[i]['value'];
        }
        if (formObject.loggedIn)
            formObject.loggedIn = true;
        else
            formObject.loggedIn = false;
        this.model = new UserApp.Models.User(formObject);
        this.model.add(function () {
            Users.fetch();
        });
    }
});

UserApp.Views.UserListItem = Backbone.View.extend({
    tagName: 'li',
    className: 'listItem',
    template: _.template($("#userListItemTemplate").html()),
    events: {
        'click': function () {
            console.log(this.model.get('login'))
            this.model.delete();
        }
    },
    initialize: function (user) {
        this.model = user;
        this.model.bind('sync', this.render, this);
        this.model.bind('destroy', this.remove, this);
    },
    render: function () {
        this.$el.html(this.template(this.model.attributes));
        return this;
    }
});

UserApp.Views.UserList = Backbone.View.extend({
    el: $('#userList'),
    model: UserApp.Collections.Users,
    initialize: function (collection) {
        this.model = collection;
    },
    render: function () {
        this.$el.empty();
        this.model.each(function (user) {
            var listItemView = new UserApp.Views.UserListItem(user);
            this.$el.append(listItemView.render().el);
        }, this);
        return this;
    }
});

var App = new UserApp.Views.UserList(Users);

var NewUserForm = new UserApp.Views.NewUserEditor();
NewUserForm.render();

Users.on('sync', function () {
    App.render();
});

Users.fetch();

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
