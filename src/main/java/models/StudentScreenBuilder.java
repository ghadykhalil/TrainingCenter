/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models;

import controllers.ChapterController;
import javax.swing.DefaultListModel;

/**
 *
 * @author User
 */
public class StudentScreenBuilder extends MeetingScreenBuilder {

    Student student;  // Add student object to handle student-specific data
    Chapter chapter;

    public StudentScreenBuilder(Meeting meeting, Student student, Chapter chapter) {
        super(meeting);
        this.student = student;
        this.chapter = chapter;
        this.student.setMeetingGUI(this.meeting_Screen);  // This sets the meetingGUI in Student
    }

    @Override
    protected void fillLabels() {
        // Fill in labels with student-specific information
        this.meeting_Screen.nameLabel.setText(student.getName());
        this.meeting_Screen.subjectLabel.setText(this.meeting.getSubject().toString());
        this.meeting_Screen.roleLabel.setText("Student");
        this.meeting_Screen.topicLabel.setText(this.meeting.getTopic());
    }

    @Override
    protected void fillLists() {
        // Clear the lists
        DefaultListModel<String> objectivesModel = new DefaultListModel<>();
        DefaultListModel<Student> awaitingListModel = new DefaultListModel<>();

        // Set the empty models to the lists
        this.meeting_Screen.awaitingStudentsList.setModel(awaitingListModel);
        this.meeting_Screen.objectives.setModel(objectivesModel);
        Chapter actualChapter = ChapterController.getChapterById(chapter.getId());

        objectivesModel.addAll(actualChapter.getObjectives());

        // Hide the labels and lists first
        this.meeting_Screen.awaitingStudentsLabel.setVisible(false);
        this.meeting_Screen.awaitingStudentsList.setVisible(false);
        this.meeting_Screen.jLabel2.setVisible(false);
        this.meeting_Screen.admittedStudentsList.setVisible(false);

        // Remove components from the layout (important for some layout managers)
        this.meeting_Screen.getContentPane().remove(this.meeting_Screen.awaitingStudentsLabel);
        this.meeting_Screen.getContentPane().remove(this.meeting_Screen.awaitingStudentsList);
        this.meeting_Screen.getContentPane().remove(this.meeting_Screen.jLabel2);
        this.meeting_Screen.getContentPane().remove(this.meeting_Screen.admittedStudentsList);

        // Revalidate and repaint to update the UI properly
        this.meeting_Screen.getContentPane().revalidate();
        this.meeting_Screen.getContentPane().repaint();

        // Force the layout manager to re-layout the components
        this.meeting_Screen.getContentPane().doLayout();
    }

    @Override
    protected void fillButtons() {
        // Here, you can add the logic for student-specific buttons like "Join Meeting" or other interactions.
    }
}
