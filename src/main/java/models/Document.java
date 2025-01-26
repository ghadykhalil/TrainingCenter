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
public class Document implements LearningMaterial {

    private String id;
    private String path;

    public Document() {
        id = IdGenerator.generateId();
    }

    public Document(String c) {
        path = c;
    }

    public String getId() {
        return this.id;
    }

    @Override
    public void display() {

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
