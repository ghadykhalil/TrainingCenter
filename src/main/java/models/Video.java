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
public class Video implements LearningMaterial {

    private int id;
    private static int next = 0;
    private String path;
    private List<LearningMaterial> children;

    public Video() {
        this.children = new ArrayList<>();
    }

    public Video(String c) {
        id = ++next;
        path = c;
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
        for (LearningMaterial child : children) {
            child.display();
        }
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
