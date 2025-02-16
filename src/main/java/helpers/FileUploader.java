package helpers;

import controllers.ChapterController;
import controllers.DocumentController;
import models.Document;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.logging.Level;
import java.util.logging.Logger;
import models.Chapter;

public class FileUploader extends JPanel {

    private JFileChooser fileChooser;
    private JLabel filePathLabel;
    private JButton confirmButton;
    private File selectedFile;
    private String chapterId; // Store chapter ID

    public FileUploader(String chapterId) {
        this.chapterId = chapterId;

        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets(5, 5, 5, 5); // Padding

        fileChooser = new JFileChooser();
        filePathLabel = new JLabel("No file selected.");
        confirmButton = new JButton("Confirm Upload");
        confirmButton.setEnabled(false);
        JButton browseButton = new JButton("Browse");

        // Browse Button Action
        browseButton.addActionListener((ActionEvent e) -> {
            int returnValue = fileChooser.showOpenDialog(this);
            if (returnValue == JFileChooser.APPROVE_OPTION) {
                selectedFile = fileChooser.getSelectedFile();
                filePathLabel.setText("Selected: " + selectedFile.getName());
                confirmButton.setEnabled(true);
            }
        });

        // Confirm Button Action
        confirmButton.addActionListener((ActionEvent e) -> {
            if (selectedFile != null) {
                try {
                    saveFile(selectedFile, ChapterController.getChapterById(chapterId));
                } catch (IOException ex) {
                    Logger.getLogger(FileUploader.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });

        // Add components to the panel
        gbc.gridy = 0;
        add(browseButton, gbc);

        gbc.gridy = 1;
        add(filePathLabel, gbc);

        gbc.gridy = 2;
        add(confirmButton, gbc);
    }

    private void saveFile(File file, Chapter chapter) throws IOException {
        Path storageDir = Paths.get("src", "main", "java", "data", "documents");
        Files.createDirectories(storageDir); // Ensure the directory exists

        Path destinationPath = storageDir.resolve(file.getName());

        if (!file.exists()) {
            return;
        }

        try {
            Files.copy(file.toPath(), destinationPath, StandardCopyOption.REPLACE_EXISTING);
        } catch (IOException e) {
            e.printStackTrace();
        }

        String relativePath = "src/main/java/data/documents/" + file.getName();
        Document document = new Document(relativePath, file.getName());
        DocumentController.addDocument(document);
        chapter.addDocument(document);
        ChapterController.updateChapter(chapter);
        
        
        JOptionPane.showMessageDialog(null, "File uploaded successfully!", "Success", JOptionPane.INFORMATION_MESSAGE);
    }

}
