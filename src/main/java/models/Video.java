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
public class Video implements LearningMaterial {

    private String id;
    private String path;

    public Video() {
        id = IdGenerator.generateId();
    }

    public Video(String c) {
        path = c;
    }

    @Override
    public void display() {

    }

    public String getId() {
        return this.id;
    }

    @Override
    public void setContent(String content) {
        this.path = content;
    }

    @Override
    public String getContent() {
        return path;
    }

}
