package models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import gui.Meeting_Screen;
import helpers.IdGenerator;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import javax.swing.DefaultListModel;

public class Instructor implements User {

    private String id;
    private String username;
    private String name;
    private boolean onlineStatus;
    private List<Subject> subjects = new ArrayList<>();

    @JsonIgnore
    private transient Meeting_Screen meetingGUI;

    public Instructor() {
        id = IdGenerator.generateId();
    }

    public Instructor(String u, String n) {
        this();
        this.username = u;
        this.name = n;
    }

    public void addSubject(Subject subject) {
        this.subjects.add(subject);
    }

    public List<Subject> getSubjects() {
        return this.subjects;
    }

    public void removeSubject(Subject subject) { // Fixed typo (removeubject -> removeSubject)
        this.subjects.remove(subject);
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
        return username;  // Now returns username instead of name for uniqueness
    }

    public void update(String message) {
        System.out.println("Instructor " + username + " received message: " + message);
    }

    public Meeting_Screen getMeetingGUI() {
        return meetingGUI;
    }

    public void setMeetingGUI(Meeting_Screen meetingGUI) {
        this.meetingGUI = meetingGUI;
    }

    public void studentAdmitted(Meeting meeting, Student student) {
        meeting.admitStudent(student);

        // Refresh UI
        if (getMeetingGUI() != null) {
            getMeetingGUI().updateMeetingView(student);

            // Remove admitted student from awaitingStudentsList (JList)
            DefaultListModel<Student> model = (DefaultListModel<Student>) getMeetingGUI().awaitingStudentsList.getModel();
            for (int i = 0; i < model.getSize(); i++) {
                if (model.getElementAt(i).getId().equals(student.getId())) {
                    model.remove(i);
                    break; // Remove only the first match
                }
            }

            // Refresh the list UI
            getMeetingGUI().awaitingStudentsList.revalidate();
            getMeetingGUI().awaitingStudentsList.repaint();
        }
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Instructor that = (Instructor) obj;
        return Objects.equals(username, that.username);
    }

    @Override
    public int hashCode() {
        return Objects.hash(username);
    }
}
