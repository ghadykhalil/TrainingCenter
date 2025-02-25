package models;

import helpers.IdGenerator;

public class TrueOrFalseResponse implements Response {

    private String id;
    private boolean selectedValue;

    public TrueOrFalseResponse() {
        id = IdGenerator.generateId();
    }

    public TrueOrFalseResponse(boolean selectedValue) {
        this();
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

    public boolean isSelectedValue() {
        return selectedValue;
    }

    public void setSelectedValue(boolean selectedValue) {
        this.selectedValue = selectedValue;
    }

}
