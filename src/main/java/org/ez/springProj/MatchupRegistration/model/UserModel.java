package org.ez.springProj.MatchupRegistration.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Table(name = "users")
public class UserModel implements Serializable {
    @Id
    private String userId;

    @Column(name = "password")
    private String passWord;

    @Column(name = "username")
    private String userName;

    @Column(name = "calendarid")
    private String calendarId;

    protected UserModel() {}

    public UserModel(String userId, String passWord, String userName, String calendarId) {
        this.userId = userId;
        this.passWord = passWord;
        this.userName = userName;
        this.calendarId = calendarId;
    }

    public String getUserId() {return this.userId;}
    public String getPassWord() {return this.passWord;}
    public String getUserName() {return this.userName;}
    public String getCalendarId() {return this.calendarId;}

    @Override
    public String toString() {
        return userId + " " + userName + " " + calendarId;
    }

}
