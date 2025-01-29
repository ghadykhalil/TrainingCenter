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
import models.Chapter;

public class ChapterController {

    private static final String CHAPTER_FILE = "src/main/java/data/chapter.json";
    private static final JsonUtils json = JsonUtils.getInstance();

    public static List<Chapter> getChapters() {
        try {
            List<Chapter> chapters = json.readData(CHAPTER_FILE, Chapter.class);
            return (chapters != null) ? chapters : new ArrayList<>();
        } catch (IOException e) {
            System.out.println("Error reading chapter data: " + e.getMessage());
            return new ArrayList<>();
        }
    }

    public static Chapter getChapterById(String chapterId) {
        List<Chapter> allChapters = getChapters();
        for (Chapter chapter : allChapters) {
            if (chapter.getId().equals(chapterId)) {
                return chapter;
            }
        }
        return null;
    }

    public static boolean addChapter(Chapter chapter) {
        boolean success = false;
        try {
            json.saveData(CHAPTER_FILE, chapter);
            success = true;
            JOptionPane.showMessageDialog(null,
                    "Chapter added successfully!",
                    "Success",
                    JOptionPane.INFORMATION_MESSAGE);

        } catch (IOException e) {
            JOptionPane.showMessageDialog(null,
                    "An error occurred while adding the chapter: " + e.getMessage(),
                    "Error",
                    JOptionPane.ERROR_MESSAGE);
        }
        return success;
    }

    public static boolean addChapters(List<Chapter> chapters) {
        boolean success = false;
        try {
            json.saveData(CHAPTER_FILE, chapters);
            success = true;
            JOptionPane.showMessageDialog(null,
                    "Chapters added successfully!",
                    "Success",
                    JOptionPane.INFORMATION_MESSAGE);

        } catch (IOException e) {
            JOptionPane.showMessageDialog(null,
                    "An error occurred while adding the chapters: " + e.getMessage(),
                    "Error",
                    JOptionPane.ERROR_MESSAGE);
        }
        return success;
    }

    public static void updateChapter(Chapter updatedChapter) {
        List<Chapter> allChapters = getChapters();
        for (int i = 0; i < allChapters.size(); i++) {
            Chapter chapter = allChapters.get(i);
            if (chapter.getId().equals(updatedChapter.getId())) {
                allChapters.set(i, updatedChapter);
                try {
                    json.writeData(CHAPTER_FILE, allChapters);
                    JOptionPane.showMessageDialog(null,
                            "Chapter updated successfully!",
                            "Success",
                            JOptionPane.INFORMATION_MESSAGE);
                    return;
                } catch (IOException e) {
                    System.out.println("Error updating chapter: " + e.getMessage());
                }
            }
        }
        System.out.println("Chapter not found: " + updatedChapter.getId());
    }
}
