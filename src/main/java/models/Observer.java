/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package models;

/**
 *
 * @author User
 */
public interface Observer {

    void update(Student newStudentState);

    void meetingStarted(Meeting meeting, Instructor instructor);

    void meetingEnded(Meeting meeting, String instructorName);

    void meetingUpdated(Meeting meeting);  // For general updates, like time change

    void studentAdmitted(Meeting meeting, Student student, Chapter chapter); // Student-specific events

    void studentRejected(Meeting meeting, Student student);
}
