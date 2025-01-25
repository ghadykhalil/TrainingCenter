package models;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
import dbWrapper.IdGenerator;
import java.util.ArrayList;
import java.util.List;
import models.LearningMaterial;

/**
 *
 * @author User
 */
public class Chapter implements LearningMaterial {

    private String id;
    private String content;
    private List<LearningMaterial> children = new ArrayList<>();

    public Chapter() {
        id = IdGenerator.generateId();
    }

    public Chapter(String c) {
        this();
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
        System.out.println("Chapter Content: " + content);
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

}
