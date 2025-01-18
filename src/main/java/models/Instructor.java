/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author User
 */
public class Instructor implements User{
    private int id;
    private static int next=0;
    private String username;
    private String name;
    private List<Subject> subjects; 
    
    public Instructor(){
        subjects=new ArrayList<>();
    };
    
    public Instructor(String u, String n){
        this.id=++next;
        this.username=u;
        this.name=n;
    }
    
    public void addSubject(Subject subject){
        this.subjects.add(subject);
    }
    
    public List<Subject> getSubjects(){
        return this.subjects;
    }
    
    @Override
    public int getId(){
        return this.id;
    }
    
    @Override
    public String getUsername(){
        return this.username;
    }
    
    @Override
    public String getName(){
        return this.name;
    }

    @Override
    public void setUsername(String username) {
        this.username=username;
    }

    @Override
    public void setName(String name) {
        this.name=name;
    }
    
    @Override
    public boolean isLoggedIn(boolean state){
        return state;
    }
   
    @Override
    public String toString(){
        return "Instructor: id= "+this.id+",\n"
                + "name= "+this.name+",\n"
                + "username ="+this.username;                
    }
}
