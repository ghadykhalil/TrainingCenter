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
    private List<Subject> prerequisites = new ArrayList<>();
    private Syllabus syllabus = new Syllabus();

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

    public Subject(String n, String d, int l, Syllabus syllabus) {
        this();
        this.name = n;
        this.desciption = d;
        this.level = l;
        this.syllabus = syllabus;
    }

    @Override
    public String toString() {
        return this.name + "\t" + this.level;
    }

    public String getId() {
        return this.id;
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

    public List<Subject> getPrerequisites() {
        return prerequisites;
    }

    public void addPrerequisite(Subject prerequisite) {
        prerequisites.add(prerequisite);
    }

    public void removeEnrollment(Subject prerequisite) {
        prerequisites.remove(prerequisite);
    }

    public Syllabus getSyllabus() {
        return syllabus;
    }

    public void setSyllabus(Syllabus syllabus) {
        this.syllabus = syllabus;
    }

}
