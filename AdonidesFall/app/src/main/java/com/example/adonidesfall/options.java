package com.example.adonidesfall;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RatingBar;

public class options extends AppCompatActivity {
    public Button lessVolume;
    public Button moreVolume;
    public Button lessText;
    public Button moreText;
    public Button backButton;
    private int volume;
    private RatingBar volumeBar;
    private int textSize;
    private RatingBar textSizeBar;
    private String KEY_VOLUME = "volumeSet";
    private String KEY_TEXT_SIZE = "textSet";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_options);
        //ToDo -> Switch icons for volume/text from stars to something more intuitive.
        //     -> Hook up these variables to control actual volume
        Bundle currentSettings = getIntent().getExtras();
        volume = currentSettings.getInt(KEY_VOLUME);
        textSize = currentSettings.getInt(KEY_TEXT_SIZE);
        lessVolume = findViewById(R.id.lessVolume);
        moreVolume = findViewById(R.id.moreVolume);
        lessText = findViewById(R.id.lessText);
        moreText = findViewById(R.id.moreText);
        backButton = findViewById(R.id.buttonBackOptions);
        volumeBar = findViewById(R.id.volumeBar);
        textSizeBar = findViewById(R.id.textBar);
        volumeBar.setRating(volume);
        textSizeBar.setRating(textSize);
    }

    public void lessVolume(View v){
        //Increments volume unless volume is less than the minimum
        if(volume > 0){
            volume--;
            volumeBar.setRating(volume);
        }
    }
    public void moreVolume(View v){
        //Increments volume unless volume is more than the maximum
        if(volume < 5){
            volume++;
            volumeBar.setRating(volume);
        }
    }
    public void lessText(View v){
        //Increments text unless text is less than the minimum
        if(textSize > 0){
            textSize--;
            textSizeBar.setRating(textSize);
        }
    }
    public void moreText(View v){
        //Increments text unless text is more than the maximum
        if(textSize < 5){
            textSize++;
            textSizeBar.setRating(textSize);
        }
    }
    public void resetGame(View v){
        //ToDo: Hook up and write function that resets game state (once saved games exist)
    }
    public void report(View v){
        //ToDo: Hook up report button to open an email field for user reported issues
    }
    public void backButton(View v){
        finish();
    }
    public void finish(){
        Intent settings = new Intent();
        settings.putExtra(KEY_VOLUME,volume);
        settings.putExtra(KEY_TEXT_SIZE,textSize);
        setResult(0,settings);
        super.finish();
    }

}
