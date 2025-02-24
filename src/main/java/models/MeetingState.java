/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models;

public interface MeetingState {

    void startMeeting(Meeting meeting, Instructor instructor);

    void endMeeting(Meeting meeting);

    void admitStudent(Meeting meeting, Student student);
}
