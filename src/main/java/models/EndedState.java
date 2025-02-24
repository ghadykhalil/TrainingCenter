/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models;

import controllers.ChapterController;
import controllers.MeetingController;

/**
 *
 * @author User
 */
public class EndedState implements MeetingState {

    @Override
    public void startMeeting(Meeting meeting, Instructor instructor) {
        System.out.println("Meeting has already ended.");
    }

    @Override
    public void endMeeting(Meeting meeting) {
        if (MeetingController.getMeetingById(meeting.getId()) != null) {
            ChapterController.updateChapter(meeting.getChapter());
            MeetingController.updateMeeting(meeting);
        } else {
            ChapterController.updateChapter(meeting.getChapter());
            MeetingController.addMeeting(meeting);
        }
    }

    @Override
    public void admitStudent(Meeting meeting, Student student) {
        System.out.println("Meeting has ended. " + student.getName() + " cannot be admitted.");
    }
}
