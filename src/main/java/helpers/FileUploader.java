package helpers;

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
import java.util.UUID;

public class FileUploader extends JFrame {

    private JFileChooser fileChooser;
    private JLabel filePathLabel;
    private JButton confirmButton;
    private File selectedFile;
    private Path destinationPath;

    public FileUploader() {
        setTitle("File Uploader");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new FlowLayout());
        setSize(400, 200);

        fileChooser = new JFileChooser();
        filePathLabel = new JLabel("No file selected.");
        confirmButton = new JButton("Confirm");
        confirmButton.setEnabled(false);

        JButton browseButton = new JButton("Browse");

        // Browse Button - Select File
        browseButton.addActionListener((ActionEvent e) -> {
            int returnValue = fileChooser.showOpenDialog(null);
            if (returnValue == JFileChooser.APPROVE_OPTION) {
                selectedFile = fileChooser.getSelectedFile();
                filePathLabel.setText("Selected: " + selectedFile.getName());
                confirmButton.setEnabled(true);
            }
        });

        // Confirm Button - Save File
        confirmButton.addActionListener((ActionEvent e) -> {
            if (selectedFile != null) {
                try {
                    saveFile(selectedFile);
                } catch (IOException ex) {
                    JOptionPane.showMessageDialog(this, "Error saving file: " + ex.getMessage(),
                            "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        add(browseButton);
        add(filePathLabel);
        add(confirmButton);
        setVisible(true);
    }

    private void saveFile(File file) throws IOException {
        // Define storage directory and ensure it exists
        String storageDir = "src/main/java/data/documents";
        Files.createDirectories(Paths.get(storageDir));

        // Define file destination path
        destinationPath = Paths.get(storageDir, file.getName());

        // Copy file to destination
        Files.copy(file.toPath(), destinationPath, StandardCopyOption.REPLACE_EXISTING);

        // Create document metadata and save it to database
        Document document = new Document(file.getName(), destinationPath.toString());
        DocumentController.addDocument(document);

// Notify user
    }
}
