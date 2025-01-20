/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models;

/**
 *
 * @author User
 */
public class TrueOrFalseResponse implements Response {

    private int id;
    private static int next = 0;
    private boolean selectedValue;

    public TrueOrFalseResponse(boolean selectedValue) {
        this.id = ++next;
        this.selectedValue = selectedValue;
    }

    @Override
    public boolean evaluate(Object correctAnswer) {
        return selectedValue == (boolean) correctAnswer;
    }

    public int getId() {
        return this.id;
    }
}
