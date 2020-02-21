package com.example.adonidesfall;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Gameplay extends AppCompatActivity {
    //0 = neutral
    //1 = happy
    //2 = sad
    private int happySad;
    private Button happySadButton;
    //0 = neutral
    //1 = passive
    //2 = pushy
    private int passivePushy;
    private Button passivePushyButton;
    //0 = neutral
    //1 = excited
    //2 = calm
    private int excitedCalm;
    private Button excitedCalmButton;
    //0 = truth
    //1 = mislead
    //2 = lie
    private int truth;
    private Button truthButton;

    //[happy/sad,passive/pushy,excited/calm,truth]
    private int[] mood;

    private static final int optionCode = 0;
    private static final int inventoryCode = 1;
    private static final int helpCode = 4;
    private static final int profileCode = 5;

    //variables for the options screen
    private String KEY_VOLUME = "volumeSet";
    private String KEY_TEXT_SIZE = "textSet";
    private int volume;
    private int textSize;

    private String KEY_IDEAS = "theIdeas";
    private String KEY_KNOWLEDGES = "theKnowledges";
    private String KEY_STATUSES = "theStatuses";
    private String[] ideas;
    private String[] knowledges;
    private String[] statuses;


    private String KEY_MOOD = "currentMood";
    private String KEY_ORIGIN = "originButton";

    private TextView textBoxOne;
    private TextView textBoxTwo;
    private TextView textBoxThree;
    private TextView textBoxFour;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gameplay);

        happySadButton = findViewById(R.id.buttonHappySad);
        passivePushyButton = findViewById(R.id.buttonPassivePushy);
        excitedCalmButton = findViewById(R.id.buttonExcitedCalm);
        truthButton = findViewById(R.id.buttonTruth);

        textBoxOne = findViewById(R.id.optionOne);
        textBoxTwo = findViewById(R.id.optionTwo);
        textBoxThree = findViewById(R.id.optionThree);
        textBoxFour = findViewById(R.id.optionFour);

        textBoxOne.setText("HELLO");
        textBoxTwo.setText("World");
        textBoxThree.setText("testing");
        textBoxFour.setText("functions");

        Bundle currentState = getIntent().getExtras();
        volume = currentState.getInt(KEY_VOLUME);
        textSize = currentState.getInt(KEY_TEXT_SIZE);
        mood = currentState.getIntArray(KEY_MOOD);
        ideas = currentState.getStringArray(KEY_IDEAS);
        knowledges = currentState.getStringArray(KEY_KNOWLEDGES);
        statuses = currentState.getStringArray(KEY_STATUSES);
        setMood(mood);

        //Relevant to initialize once this method can be passed states outside of the start state
        updateTextStyle(0,happySad);
        updateTextStyle(1,passivePushy);
        updateTextStyle(2,excitedCalm);


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
        if(reqCode==optionCode||reqCode==inventoryCode||reqCode==profileCode) {
            volume = data.getExtras().getInt(KEY_VOLUME);
            textSize = data.getExtras().getInt(KEY_TEXT_SIZE);
        }
        if(reqCode==inventoryCode){
            ideas = data.getExtras().getStringArray(KEY_IDEAS);
            knowledges = data.getExtras().getStringArray(KEY_KNOWLEDGES);
        }
    }

    public void inventoryButton(View v){
        Intent inventory = new Intent(this, Inventory.class);
        inventory.putExtra(KEY_VOLUME,volume);
        inventory.putExtra(KEY_TEXT_SIZE,textSize);
        inventory.putExtra(KEY_IDEAS,ideas);
        inventory.putExtra(KEY_KNOWLEDGES,knowledges);
        inventory.putExtra(KEY_STATUSES,statuses);
        startActivityForResult(inventory,inventoryCode);
    }

    public void buttonHappySad(View v){
        if(happySad == 0){
            happySad++;
            happySadButton.setText("Happy");
        }
        else if(happySad == 1){
            happySad++;
            happySadButton.setText("Sad");
        }
        else{
            happySad = 0;
            happySadButton.setText("Neutral");
        }
        updateTextStyle(0,happySad);
        //toDo create updateOptions() function
        // updateOptions()
    }
    public void buttonPassivePushy(View v){
        if(passivePushy == 0){
            passivePushy++;
            passivePushyButton.setText("Passive");
        }
        else if(passivePushy == 1){
            passivePushy++;
            passivePushyButton.setText("Pushy");
        }
        else{
            passivePushy = 0;
            passivePushyButton.setText("Neutral");
        }
        updateTextStyle(1,passivePushy);
        // updateOptions()
    }
    public void buttonExcitedCalm(View v){
        if(excitedCalm == 0){
            excitedCalm++;
            excitedCalmButton.setText("Excited");
        }
        else if(excitedCalm == 1){
            excitedCalm++;
            excitedCalmButton.setText("Calm");
        }
        else{
            excitedCalm = 0;
            excitedCalmButton.setText("Neutral");
        }
        updateTextStyle(2,excitedCalm);
        // updateOptions()

    }
    public void buttonTruth(View v){
        if(truth == 0){
            truth++;
            truthButton.setText("Mislead");
        }
        else if(truth == 1){
            truth++;
            truthButton.setText("Lie");
        }
        else{
            truth = 0;
            truthButton.setText("Truth");
        }
        // updateOptions()
    }

    public void setMood(int[] m){
        //sets buttons and mood variables based on the mood passed by intent, or sets all to 0
        //if called from new game
        happySad = m[0];
        passivePushy = m[1];
        excitedCalm = m[2];
        truth = m[3];
        if(happySad == 1){
            happySadButton.setText("Happy");
        }
        else if(happySad ==2){
            happySadButton.setText("Sad");
        }
        if(passivePushy == 1){
            passivePushyButton.setText("Passive");
        }
        else if(passivePushy ==2){
            passivePushyButton.setText("Pushy");
        }
        if(excitedCalm == 1){
            excitedCalmButton.setText("Excited");
        }
        else if(excitedCalm ==2){
            excitedCalmButton.setText("Calm");
        }
        if(truth == 1){
            truthButton.setText("Mislead");
        }
        else if(truth ==2){
            truthButton.setText("Lie");
        }
    }
    public void helpButton(View v){
        Intent helpB = new Intent(this,HelpScreen.class);
        String origin ="";
        helpB.putExtra(KEY_ORIGIN,origin);
        //ToDo flesh out
        startActivityForResult(helpB,helpCode);
    }
    public void profileButton(View v){
        Intent toProfile = new Intent(this,Profile.class);
        toProfile.putExtra(KEY_VOLUME,volume);
        toProfile.putExtra(KEY_TEXT_SIZE,textSize);
        startActivityForResult(toProfile,profileCode);
    }
    public void updateTextStyle(int b, int state){
        //note that the truth button doesn't update the style of all text boxes. Specific options will be "lies" if lie is selected, and another
        //function will need to define their formatting, which will be more complex.
        if(b==0){
            int tc;
            if(state==0){
                tc=Color.BLACK;
            }
            else if(state == 1){
                tc=Color.RED;
            }
            else{
                tc=Color.BLUE;
            }
            textBoxOne.setTextColor(tc);
            textBoxTwo.setTextColor(tc);
            textBoxThree.setTextColor(tc);
            textBoxFour.setTextColor(tc);
        }
        else if(b==1){
            Typeface tf;
            if(state==0){
                tf = Typeface.defaultFromStyle(Typeface.NORMAL);
            }
            else if(state ==1){
                tf = Typeface.defaultFromStyle(Typeface.ITALIC);
            }
            else{
                tf=Typeface.defaultFromStyle(Typeface.BOLD);
            }
            textBoxOne.setTypeface(tf);
            textBoxTwo.setTypeface(tf);
            textBoxThree.setTypeface(tf);
            textBoxFour.setTypeface(tf);
        }
        else{
            float opacity;
            if(state == 0){
                opacity = 191;
            }
            else if (state ==1){
                opacity = 255;
            }
            else{
                opacity = 128;
            }
            //ToDo Debug
            textBoxOne.setAlpha(opacity);
            textBoxTwo.setAlpha(opacity);
            textBoxThree.setAlpha(opacity);
            textBoxFour.setAlpha(opacity);
        }
    }

}
