/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models;

import java.util.Date;

/**
 *
 * @author User
 */
enum enrollStatus {
    Active,
    Completed,
    Dropped
}

public class Enroll {

    private int id;
    private static int next = 0;
    private Date enrollDate;
    private enrollStatus status;

    public Enroll() {
    }

    public Enroll(Date enrollDate, enrollStatus status, Student student, Subject subject) {
        this.id = ++next;
        this.enrollDate = enrollDate;
        this.status = status;
        this.student = student;
        this.subject = subject;
    }

    public Date getEnrollDate() {
        return enrollDate;
    }

    public void setEnrollDate(Date enrollDate) {
        this.enrollDate = enrollDate;
    }

    public enrollStatus getStatus() {
        return status;
    }

    public void setStatus(enrollStatus status) {
        this.status = status;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public Subject getSubject() {
        return subject;
    }

    public void setSubject(Subject subject) {
        this.subject = subject;
    }
    private Student student;
    private Subject subject;

}
