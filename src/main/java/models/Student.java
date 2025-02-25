/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import gui.Meeting_Screen;
import gui.Student_Main;
import helpers.CustomMessageDialog;
import helpers.IdGenerator;
import javax.swing.JOptionPane;

/**
 *
 * @author User
 */
public class Student implements User, Observer {

    private String id;
    private String username;
    private String name;
    private boolean onlineStatus;

    @JsonIgnore
    private transient Student_Main studentMainScreen;
    @JsonIgnore
    private transient Meeting_Screen meetingGUI;

    public Student() {
        id = IdGenerator.generateId();
    }

    ;
    
    public Student(String u, String n) {
        this();
        this.username = u;
        this.name = n;
    }

    @Override
    public String getId() {
        return this.id;
    }

    @Override
    public String getUsername() {
        return this.username;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public void setUsername(String username) {
        this.username = username;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean getOnlineStatus() {
        return onlineStatus;
    }

    @Override
    public void setOnlineStatus(boolean status) {
        this.onlineStatus = status;
    }

    @Override
    public String toString() {
        return this.username;
    }

    @Override
    public void update(Student newStudentState) {
    }

    @Override
    public void meetingStarted(Meeting meeting, Instructor instructor) {
        if (!onlineStatus) {
            return; // Do not notify offline students
        }

        String subjectName = meeting.getSubject().getName();
        String chapterName = meeting.getChapter().toString();
        double duration = meeting.getDuration();

        // Create the dialog and show it
        CustomMessageDialog messageDialog = new CustomMessageDialog(studentMainScreen, this, instructor, subjectName, chapterName, duration, meeting);
        messageDialog.showMessage();
    }

    @Override
    public void meetingEnded(Meeting meeting, String instructorName) {
        if (this.meetingGUI != null) {
            String message = "The meeting \"" + meeting.getTopic() + "\" has been ended. by "
                    + "Instructor: " + instructorName + "\n"
                    + "Subject: " + meeting.getSubject().toString() + "\n"
                    + "Chapter: " + meeting.getChapter().getChapterTitle() + "\n"
                    + "Thank you for attending!";

            JOptionPane.showMessageDialog(null, message, this.getName() + " - Meeting Summary", JOptionPane.INFORMATION_MESSAGE);

            this.meetingGUI.dispose();  // Close the GUI screen
            setMeetingGUI(null);  // Optionally set it to null to prevent further references
        }
    }

    @Override
    public void meetingUpdated(Meeting meeting
    ) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void studentAdmitted(Meeting meeting, Student student, Chapter chapter) {
        StudentVisitor studentVisitor = new StudentVisitor(student, chapter);
        studentVisitor.visit(meeting);
    }

    @Override
    public void studentRejected(Meeting meeting, Student student
    ) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public Student_Main getStudentMainScreen() {
        return studentMainScreen;
    }

    public void setStudentMainScreen(Student_Main studentMainScreen) {
        this.studentMainScreen = studentMainScreen;
    }

    public Meeting_Screen getMeetingGUI() {
        return meetingGUI;
    }

    public void setMeetingGUI(Meeting_Screen meetingGUI) {
        this.meetingGUI = meetingGUI;
    }

}
