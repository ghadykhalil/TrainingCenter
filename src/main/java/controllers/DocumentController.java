/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controllers;

import dbWrapper.JsonUtils;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
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

    // Add other methods as needed (e.g., deleteDocument, searchDocuments, etc.)
}