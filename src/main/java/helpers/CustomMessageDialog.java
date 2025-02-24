package helpers;

import gui.Meeting_Screen;
import javax.swing.*;
import java.awt.*;
import java.util.HashMap;
import java.util.Map;
import models.Instructor;
import models.Meeting;
import models.Student;

public class CustomMessageDialog {

    private JDialog dialog;
    private JLabel messageLabel;
    private static Map<String, JDialog> instructorModals = new HashMap<>(); // Track instructor modals

    public CustomMessageDialog(JFrame parentFrame, Student student, Instructor instructor, String subjectName, String chapterName, double duration, Meeting meeting) {
        dialog = new JDialog(parentFrame, "New Notification (" + student.getName() + ")", false);
        dialog.setSize(400, 300);
        dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        dialog.setLocationRelativeTo(parentFrame);
        dialog.setLayout(new BorderLayout());

        // Header
        JPanel headerPanel = new JPanel(new BorderLayout());
        JLabel headerLabel = new JLabel("Meeting Started", SwingConstants.CENTER);
        headerLabel.setFont(new Font("Arial", Font.BOLD, 20));
        headerPanel.add(headerLabel, BorderLayout.CENTER);
        dialog.add(headerPanel, BorderLayout.NORTH);

        // Message
        String message = "<html><div style='width: 350px;'>"
                + "<b>Instructor:</b> " + instructor.getName() + "<br>"
                + "<b>Subject:</b> " + subjectName + "<br>"
                + "<b>Chapter:</b> " + chapterName + "<br>"
                + "<b>Duration:</b> " + duration + " minutes<br>"
                + "<b>Topic:</b> " + meeting.getTopic() + "</div></html>";
        messageLabel = new JLabel(message, SwingConstants.CENTER);
        messageLabel.setPreferredSize(new Dimension(350, 120));
        dialog.add(messageLabel, BorderLayout.CENTER);

        // Buttons
        JPanel buttonPanel = new JPanel();
        JButton acceptButton = new JButton("Accept");
        JButton rejectButton = new JButton("Reject");

        acceptButton.addActionListener(e -> {
            dialog.dispose();
            updateMessage("Awaiting admittance...");
            showInstructorNotification(student, instructor, subjectName, chapterName, duration, meeting);
        });

        rejectButton.addActionListener(e -> dialog.dispose());

        buttonPanel.add(acceptButton);
        buttonPanel.add(rejectButton);
        dialog.add(buttonPanel, BorderLayout.SOUTH);
    }

    public void showMessage() {
        SwingUtilities.invokeLater(() -> dialog.setVisible(true));
    }

    public void updateMessage(String newMessage) {
        messageLabel.setText("<html><div style='width: 350px;'>" + newMessage + "</div></html>");
    }

    private void showInstructorNotification(Student student, Instructor instructor, String subjectName, String chapterName, double duration, Meeting meeting) {
        String instructorKey = instructor.getName() + "_" + meeting.getId() + "_" + student.getId();

        if (instructorModals.containsKey(instructorKey)) {
            instructorModals.get(instructorKey).setVisible(true);
            return;
        }

        JDialog instructorDialog = new JDialog((Frame) null, "Student Request: " + student.getName(), false);
        instructorDialog.setSize(400, 300);
        instructorDialog.setLocationRelativeTo(null);

        // Header
        JPanel headerPanel = new JPanel(new BorderLayout());
        JLabel instructorLabel = new JLabel("Instructor: " + instructor.getName());
        instructorLabel.setFont(new Font("Arial", Font.BOLD, 14));
        headerPanel.add(instructorLabel, BorderLayout.WEST);
        instructorDialog.add(headerPanel, BorderLayout.NORTH);

        // Message
        String message = "<html><div style='width: 350px;'>"
                + "<b>Student:</b> " + student.getName() + "<br>"
                + "<b>Subject:</b> " + subjectName + "<br>"
                + "<b>Chapter:</b> " + chapterName + "<br>"
                + "<b>Duration:</b> " + duration + " minutes<br>"
                + "<b>Topic:</b> " + meeting.getTopic() + "</div></html>";
        JLabel messageLabel = new JLabel(message, SwingConstants.CENTER);
        messageLabel.setPreferredSize(new Dimension(350, 120));
        instructorDialog.add(messageLabel, BorderLayout.CENTER);

        // Buttons
        JPanel buttonPanel = new JPanel();
        JButton admitButton = new JButton("Admit");
        JButton rejectButton = new JButton("Reject");

        admitButton.addActionListener(e -> {
            instructor.studentAdmitted(meeting, student);
            instructorDialog.dispose();
        });

        rejectButton.addActionListener(e -> {
            instructorDialog.dispose();
        });

        buttonPanel.add(admitButton);
        buttonPanel.add(rejectButton);
        instructorDialog.add(buttonPanel, BorderLayout.SOUTH);

        instructorModals.put(instructorKey, instructorDialog);
        instructorDialog.setVisible(true);
    }
}
