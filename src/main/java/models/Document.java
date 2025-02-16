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
public class Document {

    private String id;
    private String path;
    private String filename;

    public Document() {
        id = IdGenerator.generateId();
    }

    public Document(String c, String filename) {
        this();
        path = c;
        this.filename = filename;
    }

    public String getId() {
        return this.id;
    }

    @Override
    public String toString(){
        return this.filename;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getFilename() {
        return filename;
    }

    public void setFilename(String filename) {
        this.filename = filename;
    }
    
    

}
