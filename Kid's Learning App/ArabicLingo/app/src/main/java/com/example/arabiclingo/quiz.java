package com.example.arabiclingo;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.res.ResourcesCompat;
import androidx.core.content.res.TypedArrayUtils;

import android.annotation.SuppressLint;
import java.util.*;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class quiz extends AppCompatActivity {

    ProgressBar progressBar;
    TextView progressTV;
    ImageView questionIV;
    Button choice1btn, choice2btn, choice3btn, choice4btn;
    Button movebtn;

    int score;
    int totalQs = Questions.questions.length;
    int currentQsIndex = 0;
    int currentQs = 1;
    String selectedAns = "";
    int selectedOptionPosition = 0;
    int count = 0;
    String correctAns;
    int index = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);

        ((TextView) findViewById(R.id.progressTV)).setText(currentQs + "/" + totalQs);
        ((ProgressBar) findViewById(R.id.progressBar)).setProgress(currentQs);
        ((Button) findViewById(R.id.movebtn)).setText(getText(R.string.check));

        launchNewQuestion();
    }

    @SuppressLint("UseCompatLoadingForDrawables")
    public void doSmth(View v) {
        Button selectedBTN = (Button) v;

        Log.d("n", "doSmth:");
        //IF ANY OPTION WAS SELECTED
        //CHANGING VIEW OF THE SELECTED OPTION + GETTING SELECTED OPTION POSITION AND TEXT
        if (v.getId() == R.id.choice1btn) {
            selectedOptionView(v, 1);
            selectedAns = selectedBTN.getText().toString();
        } else if (v.getId() == R.id.choice2btn) {
            selectedOptionView(v, 2);
            selectedAns = selectedBTN.getText().toString();
        } else if (v.getId() == R.id.choice3btn) {
            selectedOptionView(v, 3);
            selectedAns = selectedBTN.getText().toString();
        } else if (v.getId() == R.id.choice4btn) {
            selectedOptionView(v, 4);
            selectedAns = selectedBTN.getText().toString();
        }

        //INCREASE SCORE IF CORRECT OPTION WAS SELECTED
        if (selectedBTN.getId() == R.id.movebtn) {
            count++;
            if(currentQsIndex == (Questions.questions.length - 1))
            {
                selectedBTN.setText(getText(R.string.finish));
            }
            else {
                selectedBTN.setText(getText(R.string.cntd));
            }

            if (selectedAns.equals(Questions.correctOption[currentQsIndex])) {
                score++;
            }

            Log.d("array answer", String.valueOf(currentQsIndex == Questions.questions.length));
            if (!Questions.correctOption[currentQsIndex].equals(selectedAns)) {
                answerView(selectedOptionPosition, R.drawable.wrong_option_border_bg);
            }

            correctAns = Questions.correctOption[currentQsIndex];

            String button1Text = ((Button) findViewById(R.id.choice1btn)).getText().toString();
            String button2Text = ((Button) findViewById(R.id.choice2btn)).getText().toString();
            String button3Text = ((Button) findViewById(R.id.choice3btn)).getText().toString();
            String button4Text = ((Button) findViewById(R.id.choice4btn)).getText().toString();

            if (correctAns.equals(button1Text)) {
                index = 1;
            } else if (correctAns.equals(button2Text)) {
                index = 2;
            } else if (correctAns.equals(button3Text)) {
                index = 3;
            } else if (correctAns.equals(button4Text)) {
                index = 4;
            }
            answerView(index, R.drawable.correct_option_border_bg);
            currentQsIndex++;
            currentQs++;
        }
    }

    public void doSmthBtn(View v) {
        //IF CHECK BUTTON WAS SELECTED WITHOUT ANY OPTION SELECTED
        if (v.getId() == R.id.movebtn && selectedOptionPosition == 0) {
            Toast.makeText(this, "Please select an answer", Toast.LENGTH_SHORT).show();
        }
        else if(count == 0)
        {
            doSmth(v);
        }
        else {
            launchNewQuestion();
        }
    }

    @SuppressLint({"UseCompatLoadingForDrawables", "SetTextI18n"})
    private void launchNewQuestion() {
        if (currentQsIndex == totalQs) {
            Toast.makeText(this, "You have completed the Quiz", Toast.LENGTH_SHORT).show();
            finishQuiz();
            return;
        }

        ((TextView) findViewById(R.id.progressTV)).setText(currentQs + "/" + totalQs);
        ((ProgressBar) findViewById(R.id.progressBar)).setProgress(currentQs);
        ((Button) findViewById(R.id.movebtn)).setText(getText(R.string.check));
        selectedOptionPosition = 0;
        count = 0;

        ImageView imageview = (ImageView) findViewById(R.id.questionIV);
        imageview.setImageDrawable(getResources().getDrawable(Questions.questions[currentQsIndex]));

        defaultOptionView();
        ((Button) findViewById(R.id.choice1btn)).setText(Questions.options[currentQsIndex][0]);
        ((Button) findViewById(R.id.choice2btn)).setText(Questions.options[currentQsIndex][1]);
        ((Button) findViewById(R.id.choice3btn)).setText(Questions.options[currentQsIndex][2]);
        ((Button) findViewById(R.id.choice4btn)).setText(Questions.options[currentQsIndex][3]);
    }

    //AFTER RESULT ACTIONS
    void finishQuiz() {
        String passStatus = "";
        if (score > totalQs * 0.60) {
            passStatus = "Passed";
        } else {
            passStatus = "Failed";
        }

        new AlertDialog.Builder(this)
                .setTitle(passStatus)
                .setMessage("You scored " + score + " out of " + totalQs)
                .setPositiveButton("Take Quiz again", (dialogInterface, i) -> restartQuiz())
                .setNegativeButton("Main Menu", (dialogInterface, i) -> launchMain())
                .setCancelable(false)
                .show();
    }

    private void restartQuiz() {
        score = 0;
        currentQsIndex = 0;
        currentQs = 1;
        launchNewQuestion();
    }
    private void launchMain() {
        Intent intent0 = new Intent(this, MainActivity.class);
        startActivity(intent0);
    }

    //VIEWS
    @SuppressLint("UseCompatLoadingForDrawables")
    private void answerView ( int answer, int drawableView){
        //defaultOptionView();
        if (answer == 1) {
            ((Button) findViewById(R.id.choice1btn)).setTextColor(getResources().getColor(R.color.white));
            ((Button) findViewById(R.id.choice1btn)).setBackground(getResources().getDrawable(drawableView));

        } else if (answer == 2) {
            ((Button) findViewById(R.id.choice2btn)).setTextColor(getResources().getColor(R.color.white));
            ((Button) findViewById(R.id.choice2btn)).setBackground(getResources().getDrawable(drawableView));

        } else if (answer == 3) {
            ((Button) findViewById(R.id.choice3btn)).setTextColor(getResources().getColor(R.color.white));
            ((Button) findViewById(R.id.choice3btn)).setBackground(getResources().getDrawable(drawableView));

        } else if (answer == 4) {
            ((Button) findViewById(R.id.choice4btn)).setTextColor(getResources().getColor(R.color.white));
            ((Button) findViewById(R.id.choice4btn)).setBackground(getResources().getDrawable(drawableView));

        }
    }

        @SuppressLint("UseCompatLoadingForDrawables")
        private void defaultOptionView ()
        {
            ((Button) findViewById(R.id.choice1btn)).setBackground(getResources().getDrawable(R.drawable.default_option_border_bg));
            ((Button) findViewById(R.id.choice1btn)).setTextColor(getResources().getColor(R.color.white));
            ((Button) findViewById(R.id.choice2btn)).setBackground(getResources().getDrawable(R.drawable.default_option_border_bg));
            ((Button) findViewById(R.id.choice2btn)).setTextColor(getResources().getColor(R.color.white));
            ((Button) findViewById(R.id.choice3btn)).setBackground(getResources().getDrawable(R.drawable.default_option_border_bg));
            ((Button) findViewById(R.id.choice3btn)).setTextColor(getResources().getColor(R.color.white));
            ((Button) findViewById(R.id.choice4btn)).setBackground(getResources().getDrawable(R.drawable.default_option_border_bg));
            ((Button) findViewById(R.id.choice4btn)).setTextColor(getResources().getColor(R.color.white));
        }

        @SuppressLint("UseCompatLoadingForDrawables")
        private void selectedOptionView (View v,int selectedOptionNum)
        {
            defaultOptionView();
            selectedOptionPosition = selectedOptionNum;

            Button b = (Button) v;

            b.setTextColor(getResources().getColor(R.color.purple_500));
            b.setBackground(getResources().getDrawable(R.drawable.selected_option_border_bg));
        }
    }