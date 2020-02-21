package com.example.adonidesfall;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.Arrays;
import java.util.List;

public class Knowledges extends AppCompatActivity {

    private String[] knowledges;
    private String KEY_KNOWLEDGES = "theKnowledges";
    private int whichButton;
    private String KEY_BUTTON = "whichButton";
    private String KEY_ORIGIN = "originButton";
    private static final int helpCode = 4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_knowledges);

        Bundle currentState = getIntent().getExtras();
        knowledges = currentState.getStringArray(KEY_KNOWLEDGES);
        whichButton = currentState.getInt(KEY_BUTTON);
    }

    public void buttonPress(View v){
        Button pressed = (Button)v;
        String returnText = (String)pressed.getText();
        List<String> knowledgeList = Arrays.asList(knowledges);
        if(knowledgeList.contains(returnText)){
            Toast.makeText(Knowledges.this,knowledges[0] + " " + knowledges[1]+ " " + knowledges[2]+ " " + knowledges[3], Toast.LENGTH_SHORT).show();
        }
        else{
            knowledges[whichButton] = returnText;
        }
    }
    public void backButton(View v){
        finish();
    }

    public void finish(){
        Intent settings = new Intent();
        settings.putExtra(KEY_KNOWLEDGES,knowledges);
        setResult(3,settings);
        super.finish();
    }
    public void helpButton(View v){
        Intent helpB = new Intent(this,HelpScreen.class);
        String origin ="";
        helpB.putExtra(KEY_ORIGIN,origin);
        //ToDo flesh out
        startActivityForResult(helpB,helpCode);
    }
}
