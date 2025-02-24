/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models;

/**
 *
 * @author User
 */
public class NotStartedState implements MeetingState {

    @Override
    public void startMeeting(Meeting meeting, Instructor instructor) {
        meeting.setState(new StartedState());
        meeting.notifyObservers("The meeting has started!");
    }

    @Override
    public void endMeeting(Meeting meeting) {
        // Cannot end a meeting that hasn't started
        System.out.println("Cannot end a meeting that hasn't started.");
    }

    @Override
    public void admitStudent(Meeting meeting, Student student) {
        System.out.println("Meeting has not started yet. " + student.getName() + " cannot be admitted.");
    }
}
