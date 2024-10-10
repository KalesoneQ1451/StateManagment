package com.example.statemanagmentextended;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

public class MainActivity extends AppCompatActivity{

    private static final String KEY_COUNT = "count";
    private static final String KEY_CHECK = "checkbox";
    private static final String KEY_SWITCH = "switch";
    private static final String KEY_TEXT = "textedit";
    private TextView textViewCount;
    private Button buttonIncrement;
    private EditText textEdit;
    private CheckBox checkBox;
    private Switch aSwitch;
    private ConstraintLayout wallpaper;
    private int count = 0;
    private boolean isChecked = false;
    private boolean isSwitched = false;
    private String text = "";
    private TextView hidden;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textViewCount = findViewById(R.id.textViewCount);
        buttonIncrement = findViewById(R.id.buttonIncrement);
        textEdit = findViewById(R.id.userText);
        checkBox = findViewById(R.id.checkBox);
        aSwitch = findViewById(R.id.switch1);
        wallpaper = findViewById(R.id.wallpaper);
        hidden = findViewById(R.id.hidden);

        if (savedInstanceState != null){
            count = savedInstanceState.getInt(KEY_COUNT);
            isChecked = savedInstanceState.getBoolean(KEY_CHECK);
            isSwitched = savedInstanceState.getBoolean(KEY_SWITCH);
            text = savedInstanceState.getString(KEY_TEXT);
        }
        updateCountText();
        updateSwitch();
        updateCheckbox();
        updateText();

        buttonIncrement.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                count++;
                updateCountText();

            }
        });
        aSwitch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                isSwitched = aSwitch.isChecked();
                updateSwitch();
            }
        });
        checkBox.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                isChecked = checkBox.isChecked();
                updateCheckbox();
            }
        });
    }
    @Override
    protected void onSaveInstanceState(Bundle outState){
        super.onSaveInstanceState(outState);
        outState.putInt(KEY_COUNT, count);
        outState.putBoolean(KEY_CHECK, isChecked);
        outState.putBoolean(KEY_SWITCH, isSwitched);
        outState.putString(KEY_TEXT, text);
    }
    private void updateSwitch(){
        if(isSwitched){
            wallpaper.setBackgroundColor(Color.BLACK);
            aSwitch.setChecked(true);
        } else {
           wallpaper.setBackgroundColor(Color.WHITE);
            aSwitch.setChecked(false);
        }
    }
    private void updateCheckbox(){
        if(isChecked){
            hidden.setVisibility(View.VISIBLE);
            checkBox.setChecked(true);
        } else {
            hidden.setVisibility(View.INVISIBLE);
            aSwitch.setChecked(false);
        }
    }
    private void updateText(){
        textEdit.setText(text);
    }
    private void  updateCountText() {
        textViewCount.setText("Licznik: " + count);
    }
}