package com.example.adonidesfall;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.Arrays;
import java.util.List;

public class Ideas extends AppCompatActivity {


    private String[] ideas;
    private String KEY_IDEAS = "theIdeas";
    private int whichButton;
    private String KEY_BUTTON = "whichButton";
    private String KEY_ORIGIN = "originButton";
    private static final int helpCode = 4;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ideas);

        Bundle currentState = getIntent().getExtras();
        ideas = currentState.getStringArray(KEY_IDEAS);
        whichButton = currentState.getInt(KEY_BUTTON);
    }

    //handles if any of the ideas buttons are selected
    public void buttonPress(View v){
        Button pressed = (Button)v;
        String returnText = (String)pressed.getText();
        List<String> ideaList = Arrays.asList(ideas);
        if(ideaList.contains(returnText)){
            Toast.makeText(Ideas.this,ideas[0] + " " + ideas[1]+ " " + ideas[2]+ " " + ideas[3], Toast.LENGTH_SHORT).show();
        }
        else{
            ideas[whichButton] = returnText;
        }
    }

    public void helpButton(View v){
        Intent helpB = new Intent(this,HelpScreen.class);
        String origin ="";
        //ToDo troubleshoot, abstract
        if(R.id.buttonConservative == v.getId()){
            origin = "Conservative Idea";
        }
        else if(R.id.buttonLiberal == v.getId()){
            origin = "Liberal Idea";
        }
        else if(R.id.buttonPatient == v.getId()){
            origin = "Patient Idea";
        }
        else if(R.id.buttonSkeptic == v.getId()){
            origin = "Skeptic Idea";
        }
        else if(R.id.buttonFoundationalist == v.getId()){
            origin = "Foundationalist Idea";
        }
        else if(R.id.buttonCreationist == v.getId()){
            origin = "Creationist Idea";
        }
        else if(R.id.buttonParanoid == v.getId()){
            origin = "Paranoid Idea";
        }
        else if(R.id.buttonAltruistic == v.getId()){
            origin = "Altruistic Idea";
        }
        else if(R.id.buttonEgoist== v.getId()){
            origin = "Egoist Idea";
        }
        else if(R.id.buttonTrusting == v.getId()){
            origin = "Trusting Idea";
        }
        helpB.putExtra(KEY_ORIGIN,origin);
        startActivityForResult(helpB,helpCode);
    }

    public void backButton(View v){
        finish();
    }

    public void finish(){
        Intent settings = new Intent();
        settings.putExtra(KEY_IDEAS,ideas);
        setResult(2,settings);
        super.finish();
    }



}
