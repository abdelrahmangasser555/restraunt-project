package com.example.restraunt2;

public class User {
    int id;
    String name;
    String email;
    public void login(){

    }
    public void logout(){

    }

    public User(int id, String name, String email) {
        this.id = id;
        this.name = name;
        this.email = email;
    }

    public User() {
        id = 0;
        name = "";
        email = "";
    }
}
