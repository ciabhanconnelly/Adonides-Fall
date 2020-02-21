package com.example.adonidesfall;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Inventory extends AppCompatActivity {
    private static final int optionCode = 0;
    private static final int ideaCode = 2;
    private static final int knowledgeCode = 3;
    private static final int profileCode = 5;

    private String KEY_VOLUME = "volumeSet";
    private String KEY_TEXT_SIZE = "textSet";
    private int volume;
    private int textSize;

    private String KEY_IDEAS = "theIdeas";
    private String KEY_KNOWLEDGES = "theKnowledges";
    private String KEY_STATUSES = "theStatuses";
    private String KEY_BUTTON = "whichButton";

    private String[] ideas;
    private String[] knowledges;
    private String[] statuses;

    private Button ideaOne;
    private Button ideaTwo;
    private Button ideaThree;
    private Button ideaFour;

    private Button knowledgeOne;
    private Button knowledgeTwo;
    private Button knowledgeThree;
    private Button knowledgeFour;

    private Button statusOne;
    private Button statusTwo;
    private Button statusThree;
    private Button statusFour;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inventory);
        Bundle currentState = getIntent().getExtras();
        volume = currentState.getInt(KEY_VOLUME);
        textSize = currentState.getInt(KEY_TEXT_SIZE);

        ideas = currentState.getStringArray(KEY_IDEAS);
        knowledges = currentState.getStringArray(KEY_KNOWLEDGES);
        statuses = currentState.getStringArray(KEY_STATUSES);

        //Sets button text based on the current ideas selected in the player's inventory
        ideaOne = findViewById(R.id.ideaOne);
        ideaOne.setText(ideas[0]);
        ideaTwo = findViewById(R.id.ideaTwo);
        ideaTwo.setText(ideas[1]);
        ideaThree = findViewById(R.id.ideaThree);
        ideaThree.setText(ideas[2]);
        ideaFour = findViewById(R.id.ideaFour);
        ideaFour.setText(ideas[3]);

        knowledgeOne = findViewById(R.id.knowledgeOne);
        knowledgeOne.setText(knowledges[0]);
        knowledgeTwo = findViewById(R.id.knowledgeTwo);
        knowledgeTwo.setText(knowledges[1]);
        knowledgeThree = findViewById(R.id.knowledgeThree);
        knowledgeThree.setText(knowledges[2]);
        knowledgeFour = findViewById(R.id.knowledgeFour);
        knowledgeFour.setText(knowledges[3]);

        statusOne = findViewById(R.id.statusOne);
        statusOne.setText(statuses[0]);
        statusTwo = findViewById(R.id.statusTwo);
        statusTwo.setText(statuses[1]);
        statusThree = findViewById(R.id.statusThree);
        statusThree.setText(statuses[2]);
        statusFour = findViewById(R.id.statusFour);
        statusFour.setText(statuses[3]);
    }

    public void optionButtonInv(View v){
        //navigates to the options menu
        Intent settings = new Intent(this, options.class);
        settings.putExtra(KEY_VOLUME,volume);
        settings.putExtra(KEY_TEXT_SIZE,textSize);
        startActivityForResult(settings,optionCode);
    }

    public void ideaButtons(View v){
        Intent toIdeaList = new Intent(this,Ideas.class);
        //not currently used
        toIdeaList.putExtra(KEY_VOLUME,volume);
        toIdeaList.putExtra(KEY_TEXT_SIZE,textSize);
        //the ideas the player has currently selected
        toIdeaList.putExtra(KEY_IDEAS,ideas);
        //which button was pressed
        int butNumb;
        if(v.getId()==R.id.ideaOne){
            butNumb = 0;
        }
        else if(v.getId()==R.id.ideaTwo){
            butNumb = 1;
        }
        else if(v.getId()==R.id.ideaThree){
            butNumb = 2;
        }
        else{
            butNumb = 3;
        }
        toIdeaList.putExtra(KEY_BUTTON,butNumb);
        startActivityForResult(toIdeaList,ideaCode);
    }

    public void knowledgeButtons(View v){
        Intent toKnowledgeList = new Intent(this,Knowledges.class);
        //not currently used
        toKnowledgeList.putExtra(KEY_VOLUME,volume);
        toKnowledgeList.putExtra(KEY_TEXT_SIZE,textSize);
        //the ideas the player has currently selected
        toKnowledgeList.putExtra(KEY_KNOWLEDGES,knowledges);
        //which button was pressed
        int butNumb;
        if(v.getId()==R.id.knowledgeOne){
            butNumb = 0;
        }
        else if(v.getId()==R.id.knowledgeTwo){
            butNumb = 1;
        }
        else if(v.getId()==R.id.knowledgeThree){
            butNumb = 2;
        }
        else{
            butNumb = 3;
        }
        toKnowledgeList.putExtra(KEY_BUTTON,butNumb);
        startActivityForResult(toKnowledgeList,knowledgeCode);
    }

    public void backButton(View v){
        finish();
    }

    public void finish(){
        Intent settings = new Intent();
        settings.putExtra(KEY_VOLUME,volume);
        settings.putExtra(KEY_TEXT_SIZE,textSize);
        //note that statuses don't change through the inventory, they are just viewed through that screen, hence the lack of relevant menu
        //statuses will eventually be updated based on player choices through the gameplay activity
        settings.putExtra(KEY_IDEAS,ideas);
        settings.putExtra(KEY_KNOWLEDGES,knowledges);
        setResult(1,settings);
        super.finish();
    }

    @Override
    protected void onActivityResult(int reqCode, int resCode, Intent data){
        volume = data.getExtras().getInt(KEY_VOLUME);
        textSize = data.getExtras().getInt(KEY_TEXT_SIZE);
        if(reqCode == ideaCode){
            ideas = data.getExtras().getStringArray(KEY_IDEAS);
            ideaOne.setText(ideas[0]);
            ideaTwo.setText(ideas[1]);
            ideaThree.setText(ideas[2]);
            ideaFour.setText(ideas[3]);
        }
        else if(reqCode == knowledgeCode){
            knowledges = data.getExtras().getStringArray(KEY_KNOWLEDGES);
            knowledgeOne.setText(knowledges[0]);
            knowledgeTwo.setText(knowledges[1]);
            knowledgeThree.setText(knowledges[2]);
            knowledgeFour.setText(knowledges[3]);
        }
    }
    public void profileButton(View v){
        Intent toProfile = new Intent(this,Profile.class);
        toProfile.putExtra(KEY_VOLUME,volume);
        toProfile.putExtra(KEY_TEXT_SIZE,textSize);
        startActivityForResult(toProfile,profileCode);
    }
}
