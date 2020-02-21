package com.example.adonidesfall;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class HelpScreen extends AppCompatActivity {
    private String KEY_ORIGIN = "originButton";
    private TextView helpText;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_help_screen);

        helpText = findViewById(R.id.helpText);
        String baseText = (String)helpText.getText();
        Bundle currentState = getIntent().getExtras();
        String origin = currentState.getString(KEY_ORIGIN);
        String fullText = baseText + origin + ")";
        //Toast.makeText(HelpScreen.this,fullText, Toast.LENGTH_SHORT).show();
        helpText.setText(fullText);
    }

    public void backButton(View v){
        super.finish();
    }
}
