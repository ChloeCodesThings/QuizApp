package com.example.android.quizapp;

import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    int correctAnswers = 0;
    Button submit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        submit = (Button) findViewById(R.id.submitButton);
        submit.setOnClickListener(submitButtonOnClickListener);
    }

    private String getQuestion1Input() {
        EditText memoryAnswer = (EditText) findViewById(R.id.memory_answer);
        String question1Answer = memoryAnswer.getText().toString();
        return question1Answer;
    }

    private void checkQuestion1 () {
        String question1Answer = getQuestion1Input();
        if (question1Answer.equalsIgnoreCase("memory")) {
            correctAnswers += 1;
        }

    }

    private void checkQuestion2 () {
        RadioButton radioButtonMartha = (RadioButton) findViewById(R.id.radio_martha);
        boolean isMarthaChecked = radioButtonMartha.isChecked();
        if (isMarthaChecked) {
            correctAnswers += 1;
        }

    }

    private String getQuestion3Input() {
        EditText lopezAnswer = (EditText) findViewById(R.id.lopez_answer);
        String fourLetterWord = lopezAnswer.getText().toString();
        return fourLetterWord;
    }

    private void checkQuestion3 () {
        String fourLetterWord = getQuestion3Input();
        if (fourLetterWord.equalsIgnoreCase("egot")) {
            correctAnswers += 1;
        }

    }


    private void checkQuestion4 (){
        CheckBox Question3Simba = (CheckBox) findViewById(R.id.simba);
        CheckBox Question3Ham = (CheckBox) findViewById(R.id.hamilton);
        CheckBox Question3Usnavi = (CheckBox) findViewById(R.id.usnavi);
        CheckBox Question3Sweeney = (CheckBox) findViewById(R.id.sweeney);

        boolean isSimbaChecked = Question3Simba.isChecked();
        boolean isHamiltonChecked = Question3Ham.isChecked();
        boolean isUsnaviChecked = Question3Usnavi.isChecked();
        boolean isSweeneyChecked = Question3Sweeney.isChecked();


        if (isSimbaChecked && isSweeneyChecked && !isUsnaviChecked && !isHamiltonChecked) {
            correctAnswers += 1;
        }
    }


    private void checkQuestions() {
        checkQuestion1();
        checkQuestion2();
        checkQuestion3();
        checkQuestion4();
    }

    private void resetCounterCorrectAnswers(){
        correctAnswers = 0;
    }

    final View.OnClickListener submitButtonOnClickListener = new View.OnClickListener() {
        public void onClick(final View v){
            checkQuestions();
            Toast.makeText(MainActivity.this, "Correct Answers: " + correctAnswers + "/4",
                    Toast.LENGTH_LONG).show();
            resetCounterCorrectAnswers();
        }
    };
}