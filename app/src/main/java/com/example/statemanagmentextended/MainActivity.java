package com.example.statemanagmentextended;

import android.graphics.Color;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.lifecycle.ViewModelProvider;

public class MainActivity extends AppCompatActivity{

    private StateViewModel stateViewModel;

    private TextView textViewCount;
    private Button buttonIncrement;
    private EditText textEdit;
    private CheckBox checkBox;
    private Switch aSwitch;
    private ConstraintLayout wallpaper;
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

        stateViewModel = new ViewModelProvider(this).get(StateViewModel.class);

        updateCountText();
        updateSwitch();
        updateCheckbox();
        updateText();

        buttonIncrement.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                stateViewModel.countIncrement();
                updateCountText();

            }
        });
        aSwitch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                stateViewModel.setSwitched(aSwitch.isChecked());
                updateSwitch();
            }
        });
        checkBox.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                stateViewModel.setChecked(checkBox.isChecked());
                updateCheckbox();
            }
        });
        TextWatcher textWatcher = new TextWatcher() {

            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                stateViewModel.setText(textEdit.getText().toString());
            }

            @Override
            public void afterTextChanged(Editable editable) {


            }
        };
        textEdit.addTextChangedListener(textWatcher);
    }

    private void updateSwitch(){
        if(stateViewModel.isSwitched()){
            wallpaper.setBackgroundColor(Color.BLACK);
            aSwitch.setChecked(true);
        } else {
            wallpaper.setBackgroundColor(Color.WHITE);
            aSwitch.setChecked(false);
        }
    }
    private void updateCheckbox(){
        if(stateViewModel.isChecked()){
            hidden.setVisibility(View.VISIBLE);
            checkBox.setChecked(true);
        } else {
            hidden.setVisibility(View.INVISIBLE);
            aSwitch.setChecked(false);
        }
    }
    private void updateText(){
        textEdit.setText(stateViewModel.getText());
    }
    private void  updateCountText() {
        textViewCount.setText("Licznik: " + stateViewModel.getCount());
    }
}