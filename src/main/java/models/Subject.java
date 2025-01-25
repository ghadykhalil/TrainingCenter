/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models;

import dbWrapper.IdGenerator;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author User
 */
public class Subject {

    private String id;
    private String name;
    private String desciption;
    private int level;
    private List<Enroll> enrollments = new ArrayList<>();

    public Subject() {
        id = IdGenerator.generateId();

    }

    ;
    
    public Subject(String n, String d, int l) {
        this();
        this.name = n;
        this.desciption = d;
        this.level = l;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDesciption() {
        return desciption;
    }

    public void setDesciption(String desciption) {
        this.desciption = desciption;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public List<Enroll> getEnrollments() {
        return enrollments;
    }

    public void addEnrollment(Enroll enrollment) {
        enrollments.add(enrollment);
    }

    public void removeEnrollment(Enroll enrollment) {
        enrollments.remove(enrollment);
    }
}
