/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models;

import dbWrapper.IdGenerator;

/**
 *
 * @author User
 */
public class Test {

    private String id;
    private String title;
    private double duration;

    public Test() {
        id = IdGenerator.generateId();

    }

    public Test(String title, double duration, double note) {
        this();
        this.title = title;
        this.duration = duration;
        this.note = note;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public double getDuration() {
        return duration;
    }

    public void setDuration(double duration) {
        this.duration = duration;
    }

    public double getNote() {
        return note;
    }

    public void setNote(double note) {
        this.note = note;
    }
    private double note;

    private double calculateNote() {
        return this.note;
    }
}
