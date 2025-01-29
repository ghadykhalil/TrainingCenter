package models;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
import dbWrapper.IdGenerator;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author User
 */
public class Chapter implements CompositeLearningMaterial {

    private String id;
    private int chapterNo;
    private String content;
    private List<LearningMaterial> children = new ArrayList<>();

    public Chapter() {
        id = IdGenerator.generateId();
    }

    public Chapter(int chapterNo) {
        this();
        this.chapterNo = chapterNo;
    }

    public Chapter(int chapterNo, String c) {
        this();
        this.content = c;
        this.chapterNo = chapterNo;
    }

    public String getId() {
        return this.id;
    }

    public int getChapterNo() {
        return chapterNo;
    }

    public void setChapterNo(int chapterNo) {
        this.chapterNo = chapterNo;
    }

    @Override
    public String toString() {
        return "Chapter " + this.chapterNo;
    }

    @Override
    public void display() {
        System.out.println("Chapter Content: " + content);

    }

    @Override
    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public String getContent() {
        return content;
    }

    @Override
    public void add(LearningMaterial material) {
        this.children.add(material);
    }

    @Override
    public void remove(LearningMaterial material) {
        this.children.remove(material);
    }

    @Override
    public List<LearningMaterial> getChildren() {
        return this.children;
    }

    public void setChildren(List<LearningMaterial> children) {
        this.children = children;
    }

}
