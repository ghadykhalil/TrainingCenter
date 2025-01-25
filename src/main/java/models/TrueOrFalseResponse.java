/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models;

import dbWrapper.IdGenerator;

/**
 *
 * @author User
 */
public class TrueOrFalseResponse implements Response {

    private String id;
    private boolean selectedValue;

    public TrueOrFalseResponse(boolean selectedValue) {
        id = IdGenerator.generateId();
        this.selectedValue = selectedValue;
    }

    @Override
    public boolean evaluate(Object correctAnswer) {
        return selectedValue == (boolean) correctAnswer;
    }

    public String getId() {
        return this.id;
    }
}
