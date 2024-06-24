package com.isa.knowledgequiz;

import android.widget.ImageView;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class Results_Activity extends AppCompatActivity
{

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_results);

        // TODO (STEP 6: Hide the status bar and get the details from intent and set it to the UI. And also add a click event to the finish button.)
        // START
        // Hide the status bar.
        getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_FULLSCREEN);

        ImageView trophyImage = findViewById(R.id.iv_trophy);

        TextView congratsText = findViewById(R.id.tv_congratulations);

        TextView tvName = findViewById(R.id.tv_name);
        TextView tvScore = findViewById(R.id.tv_score);
        Button btnFinish = findViewById(R.id.btn_finish);

        // Getting the details from intent
        String userName = getIntent().getStringExtra(Questions_Constants.USER_NAME);
        int totalQuestions = getIntent().getIntExtra(Questions_Constants.TOTAL_QUESTIONS, 0);
        int correctAnswers = getIntent().getIntExtra(Questions_Constants.CORRECT_ANSWERS, 0);

        // Set the details to the UI
        tvName.setText(userName);
        if(correctAnswers > totalQuestions * 0.60)
        {
            tvScore.setText("Your Score is " + correctAnswers + " out of " + totalQuestions + " you passed.");
        }
        else
        {
            tvScore.setText("Your Score is " + correctAnswers + " out of " + totalQuestions + " you failed.");
            trophyImage.setVisibility(View.GONE);
            congratsText.setVisibility(View.GONE);
        }


        // Setting the click event to the finish button
        btnFinish.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Results_Activity.this, Start_Activity.class));
                finish();
            }
        });
        // END
    }
}