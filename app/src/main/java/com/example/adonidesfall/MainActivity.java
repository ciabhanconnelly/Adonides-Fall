package com.example.adonidesfall;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    public Button continueButton;
    public Button newGameButton;
    public Button optionButton;
    public boolean saveState = false;
    private int volume;
    private int textSize;
    private static final int optionCode = 0;
    private String KEY_VOLUME = "volumeSet";
    private String KEY_TEXT_SIZE = "textSet";
    private String KEY_MOOD = "currentMood";
    private String KEY_IDEAS = "theIdeas";
    private String KEY_KNOWLEDGES = "theKnowledges";
    private String KEY_STATUSES = "theStatuses";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        continueButton = findViewById(R.id.buttonContinue);
        newGameButton = findViewById(R.id.buttonNewGame);
        optionButton = findViewById(R.id.buttionOptionsMain);
    }

    public void continueButton(View v){
        //Continues game if a savestate exists
        if(saveState){
            //ToDo: impliment saved games (with database section)
        }
        else{
            Toast.makeText(MainActivity.this, "No Saved Game to Continue!", Toast.LENGTH_SHORT).show();
        }
    }
    public void newGameButton(View v){
        //starts a new game
        Intent newGame = new Intent(this, Gameplay.class);
        newGame.putExtra(KEY_VOLUME,volume);
        newGame.putExtra(KEY_TEXT_SIZE,textSize);
        //sets the player's mood. For a new game the default is neutral.
        int[] mood = {0,0,0,0};
        newGame.putExtra(KEY_MOOD,mood);
        //Sets the current active ideas, knowledges, and statuses. Blank on new game.
        //A status is set to show that these settings do carry over
        String[] ideas = {"...","...","...","..."};
        String[] knowledges = {"...","...","...","..."};
        String[] statuses = {"Exhausted","...","...","..."};
        newGame.putExtra(KEY_IDEAS,ideas);
        newGame.putExtra(KEY_KNOWLEDGES,knowledges);
        newGame.putExtra(KEY_STATUSES,statuses);
        startActivity(newGame);
    }
    public void optionButton(View v){
        //navigates to the options menu
        Intent settings = new Intent(this, options.class);
        settings.putExtra(KEY_VOLUME,volume);
        settings.putExtra(KEY_TEXT_SIZE,textSize);
        startActivityForResult(settings,optionCode);
    }

    @Override
    protected void onActivityResult(int reqCode, int resCode, Intent data){
        if(reqCode==optionCode){
            volume = data.getExtras().getInt(KEY_VOLUME);
            textSize = data.getExtras().getInt(KEY_TEXT_SIZE);
        }

    }
}
