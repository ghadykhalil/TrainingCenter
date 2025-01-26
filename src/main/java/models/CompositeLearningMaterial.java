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
public interface CompositeLearningMaterial extends LearningMaterial {

    void add(LearningMaterial material);

    void remove(LearningMaterial material);

    List<LearningMaterial> getChildren();
}
