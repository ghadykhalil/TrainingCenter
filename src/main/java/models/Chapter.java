package models;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
import helpers.IdGenerator;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author User
 */
public class Chapter {

    private String id;
    private int chapterNo;
    private String chapterTitle;
    private List<String> objectives;
    private List<Document> documents;
    private List<Video> videos;
    private List<Test> tests;
    private List<Meeting> meetings;

    public Chapter() {
        id = IdGenerator.generateId();
        objectives = new ArrayList<>();
        documents = new ArrayList<>();
        videos = new ArrayList<>();
        tests = new ArrayList<>();
        meetings = new ArrayList<>();
    }

    public Chapter(int chapterNo, String chapterTitle) {
        this();
        this.chapterNo = chapterNo;
        this.chapterTitle = chapterTitle;
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
        return "Chapter " + this.chapterNo + " " + this.chapterTitle;
    }

    public List<String> getObjectives() {
        return objectives;
    }

    public void setObjectives(List<String> objectives) {
        this.objectives = objectives;
    }

    public List<Document> getDocuments() {
        return documents;
    }

    public void setDocuments(List<Document> documents) {
        this.documents = documents;
    }

    public List<Video> getVideos() {
        return videos;
    }

    public void setVideos(List<Video> videos) {
        this.videos = videos;
    }

    public List<Test> getTests() {
        return tests;
    }

    public void setTests(List<Test> tests) {
        this.tests = tests;
    }

    public String getChapterTitle() {
        return chapterTitle;
    }

    public void setChapterTitle(String chapterTitle) {
        this.chapterTitle = chapterTitle;
    }

    public void addObjective(String objective) {
        this.objectives.add(objective);
    }

    public void addDocument(Document document) {
        this.documents.add(document);
    }

    public void addTest(Test test) {
        if (test != null) {
            this.tests.add(test);
        }
    }

    public List<Meeting> getMeetings() {
        return meetings;
    }

    public void setMeetings(List<Meeting> meetings) {
        this.meetings = meetings;
    }

    public void addMeeting(Meeting meeting) {
        this.meetings.add(meeting);
    }
}
