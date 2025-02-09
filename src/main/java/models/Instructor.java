/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models;

import helpers.IdGenerator;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author User
 */
public class Instructor implements User, Observer {

    private String id;
    private String username;
    private String name;
    private boolean onlineStatus;
    private List<Subject> subjects = new ArrayList<>();

    public Instructor() {
        id = IdGenerator.generateId();
    }

    ;
    
    public Instructor(String u, String n) {
        this();
        this.username = u;
        this.name = n;
    }

    public void addSubject(Subject subject) {
        this.subjects.add(subject);
    }

    public List<Subject> getSubjects() {
        return this.subjects;
    }
    
    public void removeubject(Subject subject) {
        this.subjects.remove(subject);
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
        return username;
    }

    public void update(String message) {
        System.out.println("Instructor " + name + " received message: " + message);
    }

}
