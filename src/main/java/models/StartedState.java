/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models;

import java.util.List;

/**
 *
 * @author User
 */
public class StartedState implements MeetingState {

    @Override
    public void startMeeting(Meeting meeting, Instructor instructor) {
        List<Student> observers = meeting.getPendingAttendance();
        for (Observer observer : observers) {
            observer.meetingStarted(meeting, instructor);
        }
    }

    @Override
    public void endMeeting(Meeting meeting) {
        meeting.setState(new EndedState());
        meeting.notifyObservers("The meeting has ended!");
    }

    @Override
    public void admitStudent(Meeting meeting, Student student) {
        if (!meeting.getAdmittedStudents().contains(student)) {
            meeting.getAdmittedStudents().add(student);
        } else {
            System.out.println("Student " + student.getName() + " is already admitted.");
        }
    }
}
