package controllers;

import dbWrapper.JsonUtils;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import models.TrainingSession;

public class TrainingSessionController {

    private static final String TRAINING_SESSION_FILE = "src/main/java/data/training_session.json";
    private static final JsonUtils json = JsonUtils.getInstance();

    public static List<TrainingSession> getTrainingSessions() {
        try {
            List<TrainingSession> trainingSessions = json.readData(TRAINING_SESSION_FILE, TrainingSession.class);
            return (trainingSessions != null) ? trainingSessions : new ArrayList<>();
        } catch (IOException e) {
            System.out.println("Error reading training session data: " + e.getMessage());
            return new ArrayList<>();
        }
    }

    public static TrainingSession getTrainingSessionById(String sessionId) {
        List<TrainingSession> allSessions = getTrainingSessions();
        for (TrainingSession session : allSessions) {
            if (session.getId().equals(sessionId)) {
                return session;
            }
        }
        return null;
    }

    public static boolean addTrainingSession(TrainingSession session) {
        boolean success = false;
        try {
            json.saveData(TRAINING_SESSION_FILE, session);
            success = true;
            JOptionPane.showMessageDialog(null,
                    "Training Session added successfully!",
                    "Success",
                    JOptionPane.INFORMATION_MESSAGE);
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null,
                    "An error occurred while adding the training session: " + e.getMessage(),
                    "Error",
                    JOptionPane.ERROR_MESSAGE);
        }
        return success;
    }

    public static boolean addTrainingSessions(List<TrainingSession> sessions) {
        boolean success = false;
        try {
            json.saveData(TRAINING_SESSION_FILE, sessions);
            success = true;
            JOptionPane.showMessageDialog(null,
                    "Training Sessions added successfully!",
                    "Success",
                    JOptionPane.INFORMATION_MESSAGE);
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null,
                    "An error occurred while adding the training sessions: " + e.getMessage(),
                    "Error",
                    JOptionPane.ERROR_MESSAGE);
        }
        return success;
    }

    public static void updateTrainingSession(TrainingSession updatedSession) {
        List<TrainingSession> allSessions = getTrainingSessions();
        for (int i = 0; i < allSessions.size(); i++) {
            TrainingSession session = allSessions.get(i);
            if (session.getId().equals(updatedSession.getId())) {
                allSessions.set(i, updatedSession);
                try {
                    json.writeData(TRAINING_SESSION_FILE, allSessions);
                    JOptionPane.showMessageDialog(null,
                            "Training Session updated successfully!",
                            "Success",
                            JOptionPane.INFORMATION_MESSAGE);
                    return;
                } catch (IOException e) {
                    System.out.println("Error updating training session: " + e.getMessage());
                }
            }
        }
        System.out.println("Training session not found: " + updatedSession.getId());
    }
}
