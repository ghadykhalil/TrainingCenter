/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models;

import enums.enrollStatus;
import helpers.IdGenerator;
import java.util.Date;

/**
 *
 * @author User
 */

public class Enroll {

    private String id;
    private enrollStatus status;
    private Payment payment;
    private Student student;
    private Subject subject;

    public Enroll() {
        id = IdGenerator.generateId();
    }

    public Enroll(enrollStatus status, Student student, Subject subject) {
        this();
        this.status = status;
        this.student = student;
        this.subject = subject;
        this.payment = new Payment(subject.getSubjectPrice());
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

    public Payment getPayment() {
        return payment;
    }

    public void setPayment(Payment payment) {
        this.payment = payment;
    }

    public String getId() {
        return this.id;
    }
}
