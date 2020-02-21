package com.example.adonidesfall;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.view.View;
import android.widget.TextView;

public class Profile extends AppCompatActivity {
    private TextView journalText;

    private static final int optionCode = 0;
    private String KEY_VOLUME = "volumeSet";
    private String KEY_TEXT_SIZE = "textSet";
    private int volume;
    private int textSize;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        Bundle currentState = getIntent().getExtras();
        volume = currentState.getInt(KEY_VOLUME);
        textSize = currentState.getInt(KEY_TEXT_SIZE);

        journalText = findViewById(R.id.journalText);
        journalText.setMovementMethod(new ScrollingMovementMethod());
        journalText.setText("Lorem ipsum dolor sit amet, consectetur adipiscing elit. Praesent pulvinar finibus varius. Pellentesque lobortis neque eget urna euismod accumsan. Proin quis rhoncus nibh. Cras sit amet nisi at quam congue facilisis sagittis nec elit. Nunc enim lacus, tempus vel pharetra sit amet, dignissim at ex. Fusce ut massa vitae sapien hendrerit placerat. Nullam elit lacus, efficitur ac ex id, blandit dapibus risus. Sed mattis, erat vehicula luctus venenatis, urna neque consectetur leo, tincidunt placerat justo nisi ullamcorper arcu.\n" +
                "\n" +
                "Sed in porttitor ipsum. Nulla mattis justo a massa placerat luctus. Nam id pretium felis. Etiam euismod, massa non iaculis pretium, est leo congue libero, at luctus lacus elit condimentum dolor. Maecenas magna enim, mattis quis arcu ut, molestie euismod nisi. Morbi ac orci nec eros pretium interdum. Curabitur eget sem urna. Suspendisse id nisi vitae quam porta tincidunt at eu leo. Interdum et malesuada fames ac ante ipsum primis in faucibus. Nulla ut luctus risus, non scelerisque ante. Nulla facilisi. Phasellus vitae lorem sit amet purus finibus consectetur.\n" +
                "\n" +
                "Suspendisse non blandit tortor. Class aptent taciti sociosqu ad litora torquent per conubia nostra, per inceptos himenaeos. Nunc sit amet tortor in sem varius lacinia quis quis sapien. Nullam at orci et ex commodo lobortis id vel massa. Maecenas erat ex, dignissim eget arcu ac, ultricies ultrices ipsum. Duis purus nisl, suscipit eu feugiat eget, fringilla vel ex. Fusce et nulla nulla. Fusce commodo elit nibh, sed lobortis erat ullamcorper quis. Aenean egestas eget nisl a pretium. Vestibulum mattis vulputate commodo. Sed rutrum tempor nisi, ut accumsan mi laoreet vel. Cras sit amet orci nibh. Vestibulum sapien enim, rhoncus eu feugiat a, posuere ac ex.");

    }

    public void optionButtonProf(View v){
        //navigates to the options menu
        Intent settings = new Intent(this, options.class);
        settings.putExtra(KEY_VOLUME,volume);
        settings.putExtra(KEY_TEXT_SIZE,textSize);
        startActivityForResult(settings,optionCode);
    }
    @Override
    protected void onActivityResult(int reqCode, int resCode, Intent data) {
        volume = data.getExtras().getInt(KEY_VOLUME);
        textSize = data.getExtras().getInt(KEY_TEXT_SIZE);
    }
    public void backButton(View v){
        finish();
    }

    public void finish(){
        Intent settings = new Intent();
        settings.putExtra(KEY_VOLUME,volume);
        settings.putExtra(KEY_TEXT_SIZE,textSize);
        setResult(5,settings);
        super.finish();
    }

}
