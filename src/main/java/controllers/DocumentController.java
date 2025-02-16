/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controllers;

import dbWrapper.JsonUtils;
import java.awt.Desktop;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import models.Document; // Import your Document model

/**
 *
 * @author Ghady (or User, whichever you prefer)
 */
public class DocumentController {

    private static final String DOCUMENT_FILE = "src/main/java/data/documents.json"; // Path to your documents.json file
    private static final JsonUtils json = JsonUtils.getInstance();

    public static List<Document> getDocuments() {
        try {
            List<Document> documents = json.readData(DOCUMENT_FILE, Document.class);
            return documents != null ? documents : new ArrayList<>();
        } catch (IOException e) {
            System.out.println("Error reading documents data: " + e.getMessage());
            return new ArrayList<>();
        }
    }

    public static Document getDocumentById(String documentId) {
        List<Document> allDocuments = getDocuments();
        if (allDocuments != null) {
            for (Document document : allDocuments) {
                if (document.getId().equals(documentId)) {
                    return document;
                }
            }
        }
        return null; // Return null if no document with the given ID is found
    }

    public static boolean addDocument(Document document) {
        try {
            // Check if a document with the same ID already exists (important!)
            if (documentAlreadyExists(document.getId())) {
                JOptionPane.showMessageDialog(null,
                        "A document with the ID '" + document.getId() + "' already exists.",
                        "Duplicate Entry", JOptionPane.WARNING_MESSAGE);
                return false; // Return false to indicate failure
            }

            json.saveData(DOCUMENT_FILE, document); // Save the new document
            JOptionPane.showMessageDialog(null, "Document added successfully!",
                    "Success", JOptionPane.INFORMATION_MESSAGE);
            return true; // Return true to indicate success

        } catch (IOException e) {
            JOptionPane.showMessageDialog(null,
                    "An error occurred while adding the document: " + e.getMessage(),
                    "Error", JOptionPane.ERROR_MESSAGE);
            return false; // Return false to indicate failure
        }
    }

    private static boolean documentAlreadyExists(String documentId) {
        List<Document> allDocuments = getDocuments();
        if (allDocuments != null) {
            for (Document document : allDocuments) {
                if (document.getId().equals(documentId)) {
                    return true; // Document with this ID already exists
                }
            }
        }
        return false; // Document with this ID does not exist
    }

    public static void updateDocument(Document updatedDocument) {
        List<Document> allDocuments = getDocuments();
        for (int i = 0; i < allDocuments.size(); i++) {
            Document document = allDocuments.get(i);
            if (document.getId().equals(updatedDocument.getId())) {
                allDocuments.set(i, updatedDocument);
                try {
                    json.writeData(DOCUMENT_FILE, allDocuments);
                    return; // Exit after successful update
                } catch (IOException e) {
                    System.out.println("Error updating document: " + e.getMessage());
                    JOptionPane.showMessageDialog(null, "Error updating document: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE); //Show error to user.
                }
            }
        }
        System.out.println("Document not found for update: " + updatedDocument.getId()); // For debugging
        JOptionPane.showMessageDialog(null, "Document not found for update: " + updatedDocument.getId(), "Error", JOptionPane.ERROR_MESSAGE); //Show error to user.

    }

    public static boolean downloadDocument(String documentId) {
        Document document = getDocumentById(documentId);
        if (document == null) {
            JOptionPane.showMessageDialog(null, "Document not found.", "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }

        String documentPath = document.getPath();
        FileInputStream in = null;
        FileOutputStream out = null;

        try {
            // Prompt the user for a file to save the document
            JFileChooser fileChooser = new JFileChooser();
            fileChooser.setDialogTitle("Save Document");
            fileChooser.setSelectedFile(new File(document.getFilename())); // Default name as the document's name

            // Open the file chooser dialog
            int userChoice = fileChooser.showSaveDialog(null);
            if (userChoice != JFileChooser.APPROVE_OPTION) {
                return false; // User cancelled the save operation
            }

            File destinationFile = fileChooser.getSelectedFile(); // Get the chosen file

            // Check if the file path is valid (URL or local file)
            if (isValidURL(documentPath)) {
                // It's a URL, so we download from the web
                URL url = new URL(documentPath);
                in = (FileInputStream) url.openStream(); // Open the input stream from the URL
            } else {
                // It's a local file, so we copy it from the filesystem
                File file = new File(documentPath);
                if (!file.exists()) {
                    JOptionPane.showMessageDialog(null, "File not found: " + documentPath, "Error", JOptionPane.ERROR_MESSAGE);
                    return false;
                }
                in = new FileInputStream(file); // Open the input stream for the local file
            }

            // Ensure the file output stream is ready
            out = new FileOutputStream(destinationFile);

            // Download process (read from source and write to the destination file)
            byte[] buffer = new byte[4096];
            int bytesRead;
            while ((bytesRead = in.read(buffer)) != -1) {
                out.write(buffer, 0, bytesRead);
            }

            // Close streams
            in.close();
            out.close();

            JOptionPane.showMessageDialog(null, "Document downloaded successfully to " + destinationFile.getAbsolutePath(),
                    "Success", JOptionPane.INFORMATION_MESSAGE);
            return true;

        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Error downloading document: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        } finally {
            try {
                if (in != null) {
                    in.close();
                }
                if (out != null) {
                    out.close();
                }
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }
// Helper method to check if the string is a valid URL

// Helper method to check if the string is a valid URL
    private static boolean isValidURL(String path) {
        try {
            new URL(path);  // Try creating a URL object
            return true;  // If successful, it is a valid URL
        } catch (MalformedURLException e) {
            return false;  // If exception occurs, it's not a URL
        }
    }

    // Method to open the downloaded document
    public static void openDocument(String documentId) {
        Document document = getDocumentById(documentId);
        if (document == null) {
            JOptionPane.showMessageDialog(null, "Document not found.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        try {
            File file = new File(document.getPath());  // Assuming Document has a 'getFilePath()' method with the file location
            if (file.exists()) {
                Desktop.getDesktop().open(file);  // This will open the document with the default associated program
            } else {
                JOptionPane.showMessageDialog(null, "The document file does not exist at the specified location.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Error opening document: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    // Add other methods as needed (e.g., deleteDocument, searchDocuments, etc.)
}
