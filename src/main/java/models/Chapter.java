package models;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
import java.util.ArrayList;
import java.util.List;
import models.LearningMaterial;

/**
 *
 * @author User
 */
public class Chapter implements LearningMaterial {

    private int id;
    private static int next = 0;
    private String content;
    private List<LearningMaterial> children;

    public Chapter() {
        this.children = new ArrayList<>();
    }

    public Chapter(String c) {
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
