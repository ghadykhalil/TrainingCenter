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
public class Syllabus implements CompositeLearningMaterial {

    private String id;
    private String title;
    private String content;
    private List<LearningMaterial> children = new ArrayList<>();

    public Syllabus() {
        id = IdGenerator.generateId();

    }

    public Syllabus(String title, String content) {
        this();
        this.title = title;
        this.content = content;
    }

    @Override
    public String toString() {
        List<String> output = new ArrayList<>();
        for (LearningMaterial child : children) {
            output.add(child.toString() + "\n");
        }
        return this.content + output;
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

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getId() {
        return this.id;
    }
}
