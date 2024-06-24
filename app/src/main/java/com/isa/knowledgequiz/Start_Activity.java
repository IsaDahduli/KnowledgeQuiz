package com.isa.knowledgequiz;

import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

public class Start_Activity extends AppCompatActivity
{

    /**
     * This function is auto created by Android when the Activity Class is created.
     */
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        // This is used to align the xml view to this class
        setContentView(R.layout.activity_start);

        // To hide the status bar.
        getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_FULLSCREEN);

        Button btnStart = findViewById(R.id.btn_start);
        EditText etName = findViewById(R.id.et_name);

        btnStart.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                if (etName.getText().toString().isEmpty())
                {
                    Toast.makeText(Start_Activity.this, "Please enter your name", Toast.LENGTH_SHORT).show();
                } else
                {
                    Intent intent = new Intent(Start_Activity.this, Questions_Activity.class);
                    // TODO (STEP 2: Pass the name through intent using the constant variable which we have created.)
                    // START
                    intent.putExtra(Questions_Constants.USER_NAME, etName.getText().toString());
                    // END
                    startActivity(intent);
                    finish();
                }
            }
        });
    }
}