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
public class Chapter implements LearningMaterial {

    private String id;
    private int chapterNo;
    private String content;
    private List<TrainingSession> allTrainingSessions = new ArrayList<>();

    public Chapter() {
        id = IdGenerator.generateId();
    }

    public Chapter(int chapterNo, String content) {
        this();
        this.chapterNo = chapterNo;
        this.content = content;
    }

    public Chapter(String c) {
        this();
        this.content = c;
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
        return "Chapter " + this.chapterNo + " Description: " + this.getContent();
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

    public void add(TrainingSession trainingSession) {
        this.allTrainingSessions.add(trainingSession);
    }

    public void remove(TrainingSession trainingSession) {
        this.allTrainingSessions.remove(trainingSession);
    }

    public List<TrainingSession> getTrainingSessions() {
        return this.allTrainingSessions;
    }

    public void setTrainingSession(List<TrainingSession> trainingSessions) {
        this.allTrainingSessions = trainingSessions;
    }

}
