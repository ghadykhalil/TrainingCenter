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
public class Meeting {

    private int id;
    private static int next = 0;
    private Date dateTime;
    private double duration;
    private String topic;

    public Meeting(Date dateTime, double duration, String topic) {
        this.id = ++next;
        this.dateTime = dateTime;
        this.duration = duration;
        this.topic = topic;
    }

    public void studentJoins(Student student) {

    }

    public void admitStudent(Student student) {
    }

    public Date getDateTime() {
        return dateTime;
    }

    public void setDateTime(Date dateTime) {
        this.dateTime = dateTime;
    }

    public double getDuration() {
        return duration;
    }

    public void setDuration(double duration) {
        this.duration = duration;
    }

    public String getTopic() {
        return topic;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }

    public int getId() {
        return this.id;
    }

}
