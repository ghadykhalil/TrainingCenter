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
public class Meeting implements Observable {

    private String id;
    private Date dateTime;
    private double duration;
    private String topic;
    private List<Observer> observers = new ArrayList<>();
    private List<Student> admittedStudents = new ArrayList<>();

    public Meeting() {
        id = IdGenerator.generateId();

    }

    public Meeting(Date dateTime, double duration, String topic) {
        this();
        this.dateTime = dateTime;
        this.duration = duration;
        this.topic = topic;
    }

    public void announce(String message) {
        System.out.println("Meeting on " + topic + ": " + message);
        notifyObservers(message);
    }

    public void requestJoin(Student student) {
        System.out.println("Student " + student.getName() + " has requested to join the meeting on " + topic);
        admitStudent(student);
    }

    public void admitStudent(Student student) {
        if (!admittedStudents.contains(student)) {
            admittedStudents.add(student);
            System.out.println("Student " + student.getName() + " has been admitted to the meeting on " + topic);
        } else {
            System.out.println("Student " + student.getName() + " is already admitted.");
        }
    }

    public void messageStudent(String studentName, String message) {
        for (Student student : admittedStudents) {
            if (student.getName().equalsIgnoreCase(studentName)) {
                student.update("Message from meeting on " + topic + ": " + message);
                return;
            }
        }
        System.out.println("No student found with the name: " + studentName);
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

    public String getId() {
        return this.id;
    }

    public void addObserver(Observer observer) {
        observers.add(observer);
    }

    public void removeObserver(Observer observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObservers(String message) {
        for (Observer observer : observers) {
            observer.update(message);
        }
    }

}
