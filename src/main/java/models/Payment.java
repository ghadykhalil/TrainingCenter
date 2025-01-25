/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models;

import dbWrapper.IdGenerator;
import java.util.Date;

/**
 *
 * @author User
 */
public class Payment {

    private String id;
    private double amount;
    private boolean status;
    private Date paymentDate;
    private Student student;
    private TrainingSession trainingSession;
    private PaymentMethod paymentMethod;

    public Payment() {
        id = IdGenerator.generateId();
    }

    public Payment(double amount, boolean status, Date paymentDate, Student student, PaymentMethod paymentMethod) {
        this();
        this.amount = amount;
        this.status = false;
        this.paymentDate = paymentDate;
        this.student = student;
        this.paymentMethod = paymentMethod;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public Date getPaymentDate() {
        return paymentDate;
    }

    public void setPaymentDate(Date paymentDate) {
        this.paymentDate = paymentDate;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public TrainingSession getTrainingSession() {
        return trainingSession;
    }

    public void setTrainingSession(TrainingSession trainingSession) {
        this.trainingSession = trainingSession;
    }

    public PaymentMethod getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(PaymentMethod paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

}
