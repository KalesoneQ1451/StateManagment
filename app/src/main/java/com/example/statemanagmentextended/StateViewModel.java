package com.example.statemanagmentextended;

import androidx.lifecycle.ViewModel;

public class StateViewModel extends ViewModel{
    private int count = 0;
    private boolean isChecked = false;
    private boolean isSwitched = false;
    private String text = "";

    public int getCount() {
        return count;
    }

    public boolean isChecked() {
        return isChecked;
    }

    public boolean isSwitched() {
        return isSwitched;
    }

    public String getText() {
        return text;
    }

    public void setChecked(boolean checked) {
        isChecked = checked;
    }

    public void setSwitched(boolean switched) {
        isSwitched = switched;
    }

    public void setText(String text) {
        this.text = text;
    }

    public void countIncrement(){
        count++;
    }
}
