/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models;

import helpers.IdGenerator;

/**
 *
 * @author User
 */
public class Video {

    private String id;
    private String path;

    public Video() {
        id = IdGenerator.generateId();
    }

    public Video(String c) {
        path = c;
    }

    public String getId() {
        return this.id;
    }

}
