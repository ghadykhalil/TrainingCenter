package controllers;

import dbWrapper.JsonUtils;
import models.Meeting; // Assuming you have a Meeting model

import javax.swing.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class MeetingController {

    private static final String MEETING_FILE = "src/main/java/data/meeting.json"; // Path to your meeting data file
    private static final JsonUtils json = JsonUtils.getInstance();

    public static List<Meeting> getMeetings() {
        try {
            List<Meeting> meetings = json.readData(MEETING_FILE, Meeting.class);
            return (meetings != null) ? meetings : new ArrayList<>();
        } catch (IOException e) {
            System.out.println("Error reading Meeting data: " + e.getMessage());
            return new ArrayList<>();
        }
    }

    public static Meeting getMeetingById(String meetingId) { // Assuming Meeting has an ID
        List<Meeting> allMeetings = getMeetings();
        for (Meeting meeting : allMeetings) {
            if (meeting.getId().equals(meetingId)) { // Adjust based on your ID field name
                return meeting;
            }
        }
        return null;
    }

    public static boolean addMeeting(Meeting meeting) {
        boolean success = false;
        try {
            json.saveData(MEETING_FILE, meeting); // Use saveData for single object
            success = true;
            JOptionPane.showMessageDialog(null,
                    "Meeting added successfully!",
                    "Success",
                    JOptionPane.INFORMATION_MESSAGE);
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null,
                    "An error occurred while adding the Meeting: " + e.getMessage(),
                    "Error",
                    JOptionPane.ERROR_MESSAGE);
        }
        return success;
    }

    public static boolean addMeetings(List<Meeting> meetings) {
        boolean success = false;
        try {
            json.saveData(MEETING_FILE, meetings); // Use saveData for lists
            success = true;
            JOptionPane.showMessageDialog(null,
                    "Meetings added successfully!",
                    "Success",
                    JOptionPane.INFORMATION_MESSAGE);
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null,
                    "An error occurred while adding the Meetings: " + e.getMessage(),
                    "Error",
                    JOptionPane.ERROR_MESSAGE);
        }
        return success;
    }

    public static void updateMeeting(Meeting updatedMeeting) {
        List<Meeting> allMeetings = getMeetings();
        for (int i = 0; i < allMeetings.size(); i++) {
            Meeting meeting = allMeetings.get(i);
            if (meeting.getId().equals(updatedMeeting.getId())) { // Adjust based on your ID field name
                allMeetings.set(i, updatedMeeting);
                try {
                    json.writeData(MEETING_FILE, allMeetings); // writeData for updating the whole file
                    JOptionPane.showMessageDialog(null,
                            "Meeting updated successfully!",
                            "Success",
                            JOptionPane.INFORMATION_MESSAGE);
                    return;
                } catch (IOException e) {
                    System.out.println("Error updating Meeting: " + e.getMessage());
                }
            }
        }
        System.out.println("Meeting not found: " + updatedMeeting.getId());
    }
}
