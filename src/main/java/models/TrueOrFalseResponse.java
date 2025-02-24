package models;

import helpers.IdGenerator;

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

    public boolean getSelectedValue() {
        return selectedValue;
    }

    public String getId() {
        return this.id;
    }
}
