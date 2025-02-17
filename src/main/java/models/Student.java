/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models;

import helpers.IdGenerator;
/**
 *
 * @author User
 */
public class Student implements User, Observer {

    private String id;
    private String username;
    private String name;
    private boolean onlineStatus;

    public Student() {
        id = IdGenerator.generateId();
    }

    ;
    
    public Student(String u, String n) {
        this();
        this.username = u;
        this.name = n;
    }

    @Override
    public String getId() {
        return this.id;
    }

    @Override
    public String getUsername() {
        return this.username;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public void setUsername(String username) {
        this.username = username;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean getOnlineStatus() {
        return onlineStatus;
    }

    @Override
    public void setOnlineStatus(boolean status) {
        this.onlineStatus = status;
    }

    @Override
    public String toString() {
        return this.username;
    }

    @Override
    public void update(String message) {
        System.out.println("Student " + name + " received update: " + message);
    }
}
