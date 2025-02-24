/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package models;

import gui.Meeting_Screen;
import javax.swing.JFrame;

/**
 *
 * @author User
 */
public abstract class MeetingScreenBuilder {

    Meeting meeting;
    Meeting_Screen meeting_Screen;

    public MeetingScreenBuilder(Meeting meeting) {
        this.meeting = meeting;
        meeting_Screen = new Meeting_Screen(meeting);
        meeting_Screen.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }

    public final void buildScreen() { // Template Method
        fillLabels();
        fillLists();
        fillButtons();
        meeting_Screen.pack();
        meeting_Screen.setVisible(true);
    }

    // Methods to be implemented by subclasses
    protected abstract void fillLabels();

    protected abstract void fillLists();

    protected abstract void fillButtons();
}
