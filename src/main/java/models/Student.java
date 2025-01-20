/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author User
 */
public class Student implements User {

    private int id;
    private static int next = 0;
    private String username;
    private String name;
    private boolean onlineStatus;
    private List<Enroll> enrollments;
    private List<Payment> payments;

    public Student() {
        this.enrollments = new ArrayList<>();
        this.payments = new ArrayList<>();
    }

    ;
    
    public Student(String u, String n) {
        this.id = ++next;
        this.username = u;
        this.name = n;
    }

    @Override
    public int getId() {
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
        return "Instructor: id= " + this.id + ",\n"
                + "name= " + this.name + ",\n"
                + "username =" + this.username;
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

    public List<Payment> getPayments() {
        return payments;
    }

    public void addPayment(Payment payment) {
        payments.add(payment);
    }

    public void removePayment(Payment payment) {
        payments.remove(payment);
    }
}
