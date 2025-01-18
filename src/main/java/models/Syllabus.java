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
public class Syllabus implements LearningMaterial {

    private int id;
    private static int next = 0;
    private String content;
    private List<LearningMaterial> children;
    private int objectiveNo;

    public Syllabus() {
        this.children = new ArrayList<>();
    }

    public Syllabus(String c) {
        id = ++next;
        content = c;
    }

    @Override
    public void add(LearningMaterial material) {
        children.add(material);
    }

    @Override
    public void remove(LearningMaterial material) {
        children.remove(material);
    }

    @Override
    public List<LearningMaterial> getChildren() {
        return children;
    }

    @Override
    public void display() {
        System.out.println("Objective Content: " + content);
        for (LearningMaterial child : children) {
            child.display();
        }
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
