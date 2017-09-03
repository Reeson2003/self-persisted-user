package ru.reeson2003.user.persist;

import javax.persistence.*;
import java.util.Date;

/**
 * Date: 31.08.2017.
 * Time: 22:26.
 *
 * @author Pavel Gavrilov.
 */
@Entity
@Table(name = "user")
@Access(AccessType.PROPERTY)
public class PersistedUser {
    private long id;
    private String firstName;
    private String middleName;
    private String lastName;
    private Date birthDate;
    private String email;
    private String login;
    private String password;
    private Date registerDate;
    private Date updateDate;
    private boolean loggedIn;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Column(name = "first_name")
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    @Column(name = "middle_name")
    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    @Column(name = "last_name")
    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Column(name = "birth_date")
    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    @Column(name = "email")
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Column(name = "login", nullable = false, unique = true)
    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    @Column(name = "password", nullable = false)
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Column(name = "register_date")
    public Date getRegisterDate() {
        return registerDate;
    }

    public void setRegisterDate(Date registerDate) {
        this.registerDate = registerDate;
    }

    @Column(name = "update_date")
    public Date getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }

    public boolean isLoggedIn() {
        return loggedIn;
    }

    @Column(name = "logged_in")
    public void setLoggedIn(boolean loggedIn) {
        this.loggedIn = loggedIn;
    }
}
