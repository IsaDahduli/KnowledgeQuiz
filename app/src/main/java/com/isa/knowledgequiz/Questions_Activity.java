package com.isa.knowledgequiz;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.View;
import android.widget.*;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import java.util.ArrayList;

public class Questions_Activity extends AppCompatActivity implements View.OnClickListener
{
    TextView questionsNumber;
    TextView questionTextView;
    RadioGroup radioGroup;
    RadioButton OptionA, OptionB, OptionC, OptionD;

    int QuestionNumber = Questions_Constants.getQuestions().indexOf(questionsNumber);

    private int mCurrentPosition = 1; // Default and the first question position
    private ArrayList<Question> mQuestionsList;
    private int mSelectedOptionPosition = 0;
    private int mCorrectAnswers = 0;
    private String mUserName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_questions);

        mUserName = getIntent().getStringExtra(Questions_Constants.USER_NAME);
        mQuestionsList = Questions_Constants.getQuestions();

        //questionsNumber = findViewById(R.id.question_numbers);
        questionTextView = findViewById(R.id.question);
        radioGroup = findViewById(R.id.radioGruppe);
        OptionA = findViewById(R.id.a_option);
        OptionB = findViewById(R.id.b_option);
        OptionC = findViewById(R.id.c_option);
        OptionD = findViewById(R.id.d_option);

    /*    TextView tvOptionOne = findViewById(R.id.tv_option_one);
        TextView tvOptionTwo = findViewById(R.id.tv_option_two);
        TextView tvOptionThree = findViewById(R.id.tv_option_three);
        TextView tvOptionFour = findViewById(R.id.tv_option_four); */
        Button btnSubmit = findViewById(R.id.submit_button);
        setQuestion();

     /*   tvOptionOne.setOnClickListener(this);
        tvOptionTwo.setOnClickListener(this);
        tvOptionThree.setOnClickListener(this);
        tvOptionFour.setOnClickListener(this); */

        OptionA.setOnClickListener(this);
        OptionB.setOnClickListener(this);
        OptionC.setOnClickListener(this);
        OptionD.setOnClickListener(this);

        //questionsNumber.setText("Total questions : "+QuestionNumber);

        btnSubmit.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.a_option:
                selectedOptionView((TextView) v, 1);
                break;
            case R.id.b_option:
                selectedOptionView((TextView) v, 2);
                break;
            case R.id.c_option:
                selectedOptionView((TextView) v, 3);
                break;
            case R.id.d_option:
                selectedOptionView((TextView) v, 4);
                break;
            case R.id.submit_button:
                Button btnSubmit = (Button) v;
                if (mSelectedOptionPosition == 0) {
                    mCurrentPosition++;
                    if (mCurrentPosition <= mQuestionsList.size()) {
                        setQuestion();
                        OptionA.setEnabled(true);
                        OptionA.setChecked(false);
                        OptionB.setEnabled(true);
                        OptionB.setChecked(false);
                        OptionC.setEnabled(true);
                        OptionC.setChecked(false);
                        OptionD.setEnabled(true);
                        OptionD.setChecked(false);

                    } else {
                        Intent intent = new Intent(Questions_Activity.this, Results_Activity.class);
                        intent.putExtra(Questions_Constants.USER_NAME, mUserName);
                        intent.putExtra(Questions_Constants.CORRECT_ANSWERS, mCorrectAnswers);
                        intent.putExtra(Questions_Constants.TOTAL_QUESTIONS, mQuestionsList.size());
                        startActivity(intent);
                        finish();
                    }
                } else {
                    Question question = mQuestionsList.get(mCurrentPosition - 1);
                    if (question.getCorrectAnswer() != mSelectedOptionPosition) {
                        answerView(mSelectedOptionPosition, R.drawable.wrong_option_border_bg);
                        OptionA.setEnabled(false);
                        OptionB.setEnabled(false);
                        OptionC.setEnabled(false);
                        OptionD.setEnabled(false);
                    }
                    else
                    {
                        mCorrectAnswers++;
                    }
                    answerView(question.getCorrectAnswer(), R.drawable.correct_option_border_bg);
                    OptionA.setEnabled(false);
                    OptionB.setEnabled(false);
                    OptionC.setEnabled(false);
                    OptionD.setEnabled(false);

                    if (mCurrentPosition == mQuestionsList.size()) {
                        btnSubmit.setText("FINISH");
                    } else {
                        btnSubmit.setText("GO TO NEXT QUESTION");
                    }
                    mSelectedOptionPosition = 0;
                }
                break;
        }
    }

    private void setQuestion() {
        Question question = mQuestionsList.get(mCurrentPosition - 1);
        TextView tvQuestion = findViewById(R.id.question);
        //ImageView ivImage = findViewById(R.id.iv_image);
        TextView tvOptionOne = findViewById(R.id.a_option);
        TextView tvOptionTwo = findViewById(R.id.b_option);
        TextView tvOptionThree = findViewById(R.id.c_option);
        TextView tvOptionFour = findViewById(R.id.d_option);
        ProgressBar progressBar = findViewById(R.id.progressBar);
        TextView tvProgress = findViewById(R.id.tv_progress);

        defaultOptionsView();

        if (mCurrentPosition == mQuestionsList.size()) {
            Button btnSubmit = findViewById(R.id.submit_button);
            btnSubmit.setText("FINISH");
        } else {
            Button btnSubmit = findViewById(R.id.submit_button);
            btnSubmit.setText("SUBMIT");
        }

        progressBar.setProgress(mCurrentPosition);
        tvProgress.setText(mCurrentPosition + "/" + progressBar.getMax());

        tvQuestion.setText(question.getQuestion());
        //ivImage.setImageResource(question.getImage());
        tvOptionOne.setText(question.getOptionOne());
        tvOptionTwo.setText(question.getOptionTwo());
        tvOptionThree.setText(question.getOptionThree());
        tvOptionFour.setText(question.getOptionFour());
    }

    private void selectedOptionView(TextView tv, int selectedOptionNum) {
        defaultOptionsView();
        mSelectedOptionPosition = selectedOptionNum;
        tv.setTextColor(Color.parseColor("#363A43"));
        tv.setTypeface(tv.getTypeface(), Typeface.BOLD);
        tv.setBackground(ContextCompat.getDrawable(this, R.drawable.selected_option_border_bg));
    }

    private void defaultOptionsView() {
        TextView[] options = {
                findViewById(R.id.a_option),
                findViewById(R.id.b_option),
                findViewById(R.id.c_option),
                findViewById(R.id.d_option)
        };
        for (TextView option : options) {
            option.setTextColor(Color.parseColor("#7A8089"));
            option.setTypeface(Typeface.DEFAULT);
            option.setBackground(ContextCompat.getDrawable(this, R.drawable.default_option_border_bg));
        }
    }

    private void answerView(int answer, int drawableView) {
        TextView[] options = {
                findViewById(R.id.a_option),
                findViewById(R.id.b_option),
                findViewById(R.id.c_option),
                findViewById(R.id.d_option)
        };
        if (answer >= 1 && answer <= 4) {
            options[answer - 1].setBackground(ContextCompat.getDrawable(this, drawableView));
        }
    }
}