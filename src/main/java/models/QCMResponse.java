/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models;

/**
 *
 * @author User
 */
public class QCMResponse implements Response {

    private int id;
    private static int next = 0;
    private String selectedOption;

    public QCMResponse(String selectedOption) {
        this.id = ++next;
        this.selectedOption = selectedOption;
    }

    @Override
    public boolean evaluate(Object correctAnswer) {
        return selectedOption.equals(correctAnswer);
    }
}
