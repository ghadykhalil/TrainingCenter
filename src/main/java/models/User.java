/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package models;

/**
 *
 * @author User
 */
public interface User {

    int getId();

    String getUsername();

    void setUsername(String username);

    String getName();
    
    void setName(String name);
    
    boolean isLoggedIn(boolean state);
}
