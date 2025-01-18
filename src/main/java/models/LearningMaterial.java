/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package models;

import java.util.List;

/**
 *
 * @author User
 */
public interface LearningMaterial {

    void add(LearningMaterial material);

    void remove(LearningMaterial material);

    List<LearningMaterial> getChildren();

    void display();

    void setContent(String content);

    String getContent();
}
