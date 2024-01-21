package com.genshin_javafx.entities;

import javax.persistence.*;
@Entity
@Table(name = "user_info")

public class UserInfo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "login")
    private String login;
    @Column(name = "password")
    private String password;

    @Column(name = "role")
    private String role;

    // Gettery
    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public String getLogin() {
        return login;
    }
    public String getRole(){
        return role;
    }
    // Settery
    public void setLogin(String login) {
        this.login = login;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public void setRole(String role){
        this.role = role;
    }
}
