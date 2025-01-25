/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models;

import dbWrapper.IdGenerator;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author User
 */
public class TrainingSession {

    private String id;
    private Date startDuration;
    private Date endDuration;
    private String title;
    private String scope;
    private double totalpayments;
    private List<Payment> payments = new ArrayList<>();
    private List<Meeting> meetings = new ArrayList<>();

    public TrainingSession() {
        id = IdGenerator.generateId();

    }

    public TrainingSession(Date startDuration, Date endDuration, String title, String scope) {
        this();
        this.startDuration = startDuration;
        this.endDuration = endDuration;
        this.title = title;
        this.scope = scope;
    }

    public Date getStartDuration() {
        return startDuration;
    }

    public void setStartDuration(Date startDuration) {
        this.startDuration = startDuration;
    }

    public Date getEndDuration() {
        return endDuration;
    }

    public void setEndDuration(Date endDuration) {
        this.endDuration = endDuration;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getScope() {
        return scope;
    }

    public void setScope(String scope) {
        this.scope = scope;
    }

    public List<Meeting> getMeetings() {
        return meetings;
    }

    public void setMeetings(List<Meeting> meetings) {
        this.meetings = meetings;
    }

    public List<Payment> getPayments() {
        return payments;
    }

    public void setPayments(List<Payment> payments) {
        this.payments = payments;
    }

}
