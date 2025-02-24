package helpers;

import javax.swing.*;
import java.awt.*;
import models.Subject;
import models.Syllabus;
import models.Chapter;
import models.Document;
import controllers.ChapterController;
import controllers.SyllabusController;
import javax.swing.border.TitledBorder;

public class SyllabusDisplay extends JFrame {

    private SyllabusController syllabusController;

    public SyllabusDisplay(Subject subject) {
        this.syllabusController = new SyllabusController();  // Store the controller reference
        setTitle("Syllabus Display");
        setSize(800, 600);  // Increased size for better visibility
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);

        // Set modern look and feel
        setLookAndFeel();

        // Main panel with padding
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));
        mainPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        // Add components with new modern style
        mainPanel.add(createStyledLabelPanel("Subject:", subject.getName()));
        mainPanel.add(createStyledLabelPanel("Level:", String.valueOf(subject.getLevel())));
        mainPanel.add(createStyledLabelPanel("Description:", subject.getDesciption()));

        // Prerequisites section
        mainPanel.add(new JLabel("Prerequisites:", JLabel.LEFT));
        JTextArea prereqArea = new JTextArea(getPrerequisiteText(subject));
        styleTextArea(prereqArea);
        mainPanel.add(new JScrollPane(prereqArea));

        // Add the syllabus content (fetch from controller)
        mainPanel.add(new JLabel("Syllabus Content:", JLabel.LEFT));
        Syllabus syllabus = this.syllabusController.getSyllabusForSubject(subject);  // Fetch from controller
        if (syllabus != null) {
            // Loop through all chapters in the syllabus
            for (Chapter chapter : syllabus.getChapters()) {
                // Use ChapterController to get the updated chapter object
                Chapter updatedChapter = ChapterController.getChapterById(chapter.getId());
                if (updatedChapter != null) {
                    mainPanel.add(createChapterPanel(updatedChapter));
                }
            }
        }

        // Add to scrollable container
        JScrollPane scrollPane = new JScrollPane(mainPanel);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);  // Disable horizontal scroll
        add(scrollPane, BorderLayout.CENTER);
    }

    // Set the modern look and feel
    private void setLookAndFeel() {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private JPanel createStyledLabelPanel(String title, String value) {
        JPanel panel = new JPanel(new BorderLayout());
        panel.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
        JLabel label = new JLabel(title);
        label.setFont(new Font("Arial", Font.BOLD, 18));
        label.setForeground(Color.DARK_GRAY);
        JTextField textField = new JTextField(value);
        textField.setEditable(false);
        textField.setFont(new Font("Arial", Font.PLAIN, 18));
        textField.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY));
        panel.add(label, BorderLayout.WEST);
        panel.add(textField, BorderLayout.CENTER);
        return panel;
    }

    private void styleTextArea(JTextArea textArea) {
        textArea.setEditable(false);
        textArea.setFont(new Font("Arial", Font.PLAIN, 18));
        textArea.setLineWrap(true);
        textArea.setWrapStyleWord(true);
        textArea.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY));
        textArea.setBackground(new Color(250, 250, 250));  // Light background for readability
        textArea.setPreferredSize(new Dimension(740, 100)); // Limit the size to avoid overflow
    }

    private String getPrerequisiteText(Subject subject) {
        if (subject.getPrerequisites().isEmpty()) {
            return "None";
        }
        StringBuilder sb = new StringBuilder();
        for (Subject prereq : subject.getPrerequisites()) {
            sb.append("- ").append(prereq.getName()).append("\n");
        }
        return sb.toString();
    }

    private JPanel createChapterPanel(Chapter chapter) {
        JPanel chapterPanel = new JPanel();
        chapterPanel.setLayout(new BoxLayout(chapterPanel, BoxLayout.Y_AXIS));
        chapterPanel.setBorder(BorderFactory.createTitledBorder(null, "Chapter " + chapter.getChapterNo() + ": " + chapter.getChapterTitle(),
                TitledBorder.DEFAULT_JUSTIFICATION, TitledBorder.DEFAULT_POSITION,
                new Font("Arial", Font.BOLD, 20), Color.DARK_GRAY));

        // Display objectives
        if (chapter.getObjectives() != null && !chapter.getObjectives().isEmpty()) {
            chapterPanel.add(new JLabel("Objectives:", JLabel.LEFT));
            JTextArea objectivesArea = new JTextArea();
            for (String objective : chapter.getObjectives()) {
                objectivesArea.append("- " + objective + "\n");
            }
            styleTextArea(objectivesArea);
            chapterPanel.add(new JScrollPane(objectivesArea));
        } else {
            chapterPanel.add(new JLabel("No objectives available."));
        }

        // Display documents
        if (chapter.getDocuments() != null && !chapter.getDocuments().isEmpty()) {
            chapterPanel.add(new JLabel("Documents:", JLabel.LEFT));
            for (Document document : chapter.getDocuments()) {
                JTextArea docArea = new JTextArea(document.getFilename());
                styleTextArea(docArea);
                chapterPanel.add(new JScrollPane(docArea));
            }
        } else {
            chapterPanel.add(new JLabel("No documents available."));
        }

        // Revalidate and repaint the panel to ensure all components are properly rendered
        chapterPanel.revalidate();
        chapterPanel.repaint();

        return chapterPanel;
    }

    public static void showSyllabus(Subject subject) {
        SwingUtilities.invokeLater(() -> {
            SyllabusDisplay frame = new SyllabusDisplay(subject);
            frame.setVisible(true);
        });
    }
}
