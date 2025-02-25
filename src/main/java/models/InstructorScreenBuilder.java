/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models;

import controllers.ChapterController;
import controllers.MeetingController;
import controllers.StudentController;
import java.util.ArrayList;
import java.util.List;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JOptionPane;

/**
 *
 * @author User
 */
public class InstructorScreenBuilder extends MeetingScreenBuilder {

    Instructor instuctor;
    Chapter chapter;

    public InstructorScreenBuilder(Meeting meeting, Instructor instructor, Chapter chapter) {
        super(meeting);
        this.instuctor = instructor;
        this.chapter = chapter;
        this.instuctor.setMeetingGUI(this.meeting_Screen);  // This sets the meetingGUI in Instructor
    }

    @Override
    protected void fillLabels() {
        this.meeting_Screen.nameLabel.setText(instuctor.getName());
        this.meeting_Screen.subjectLabel.setText(this.meeting.getSubject().toString());
        this.meeting_Screen.roleLabel.setText("Instructor");
        this.meeting_Screen.topicLabel.setText(this.meeting.getTopic());
        this.meeting_Screen.chapterLabel.setText(this.chapter.getChapterTitle());
    }

    @Override
    protected void fillLists() {
        DefaultListModel<String> objectivesModel = new DefaultListModel<>();
        DefaultListModel<Student> awaitingListModel = new DefaultListModel<>();
        awaitingListModel.addAll(meeting.getPendingAttendance());
        Chapter actualChapter = ChapterController.getChapterById(chapter.getId());

        objectivesModel.addAll(actualChapter.getObjectives());

        this.meeting_Screen.objectives.setModel(objectivesModel);
        this.meeting_Screen.awaitingStudentsList.setModel(awaitingListModel);
    }

    @Override
    protected void fillButtons() {
        JButton button1 = this.meeting_Screen.button1;
        button1.setText("Notify Students to Join");
        button1.addActionListener(e -> {
            DefaultListModel<Student> model = (DefaultListModel<Student>) this.meeting_Screen.awaitingStudentsList.getModel();

            if (model.isEmpty()) {
                JOptionPane.showMessageDialog(null, "No students in the waiting list.", "Notification", JOptionPane.WARNING_MESSAGE);
                return;
            }

            List<Student> onlineStudents = new ArrayList<>();
            for (int i = 0; i < model.getSize(); i++) {
                Student student = model.getElementAt(i);
                Student updatedStudent = StudentController.getStudentById(student.getId()); // Get the latest student data
                if (updatedStudent.getOnlineStatus()) {
                    onlineStudents.add(updatedStudent);
                }
            }

            // Notify only online students
            if (!onlineStudents.isEmpty()) {
                for (Student student : onlineStudents) {
                    student.meetingStarted(meeting, instuctor);
                }
            } else {
                JOptionPane.showMessageDialog(null, "No online students to notify.", "Notification", JOptionPane.WARNING_MESSAGE);
            }
        });

        JButton button2 = this.meeting_Screen.button2;
        button2.setText("End Meeting");
        button2.addActionListener(e -> {
            meeting.endMeeting(instuctor.getName());
            this.meeting.setEnded(true);
            Chapter actualChapter = ChapterController.getChapterById(chapter.getId());
            actualChapter.addMeeting(meeting);
            ChapterController.updateChapter(actualChapter);
            MeetingController.addMeeting(meeting);
            this.meeting_Screen.dispose();
        });
    }

}
