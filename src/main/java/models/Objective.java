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
public class Objective implements LearningMaterial {

    private String id;
    private String content;
    private int objectiveNo;

    public Objective() {
        id = IdGenerator.generateId();
    }

    public Objective(String c, int objectiveNo) {
        this();
        content = c;
        this.objectiveNo = objectiveNo;
    }

    @Override
    public void display() {
        System.out.println("Objective Content: " + content);

    }

    @Override
    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public String getContent() {
        return content;
    }

    public int getObjectiveNo() {
        return objectiveNo;
    }

    public void setObjectiveNo(int objectiveNo) {
        this.objectiveNo = objectiveNo;
    }

}
