/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models;

import helpers.IdGenerator;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author User
 */
public class Syllabus{

    private String id;
    private String title;
    private String content;
    private List<Chapter> allChapters = new ArrayList<>();

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
        for (Chapter child : allChapters) {
            output.add(child.toString() + "\n");
        }
        return this.content + output;
    }

    public void add(Chapter chapter) {
        this.allChapters.add(chapter);
    }

    public void remove(Chapter chapter) {
        this.allChapters.remove(chapter);
    }

    public List<Chapter> getChapters() {
        return allChapters;
    }

    public void setContent(String content) {
        this.content = content;
    }

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
