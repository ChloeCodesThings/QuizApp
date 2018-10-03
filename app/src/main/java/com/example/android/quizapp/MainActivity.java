package com.example.android.quizapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private RadioGroup hamRadioGroup;
    private RadioButton radioHamButton;
    int quizScore = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    boolean answerEgot = false;
    boolean answerRadio = false;


    public void submitQuiz(View view) {
        EditText nameText = (EditText) findViewById(R.id.name_text);
        String userName = nameText.getText().toString();


        hamRadioGroup = (RadioGroup) findViewById(R.id.hamilton_radio);
        boolean answerRadio = getRadioAnswer(hamRadioGroup);

        EditText lopezAnswer = (EditText) findViewById(R.id.lopez_answer);
        String egotAnswer = lopezAnswer.getText().toString();
        boolean answerEgot = getLopezAnswer(egotAnswer);

        int finalScore = calculateScore(answerRadio, answerEgot);

        String scoreMessage = createTotalMessage(finalScore, userName);
        displayTotal(scoreMessage);


    }


    private boolean getRadioAnswer(View view) {
        int selectedId = hamRadioGroup.getCheckedRadioButtonId();
        radioHamButton = (RadioButton) findViewById(selectedId);

        if (radioHamButton == findViewById(R.id.radio_martha))    {
            answerRadio = true;
        }

        return  answerRadio;
    }

    private boolean getLopezAnswer(String answer) {
        if (answer == "EGOT"){
            answerEgot = true;
        }
        return  answerEgot;
    }

    private String createTotalMessage(int userTotal, String userName) {
        String totalMessage = userName + "'s Total: " + userTotal;

        return totalMessage;
    }


    private int calculateScore(boolean answerRadio, boolean answerEgot ) {

        if (answerRadio) {
            quizScore = quizScore + 1;
        }

        if (answerEgot) {
            quizScore = quizScore + 1;
        }

        return quizScore;

    }

    private void displayTotal (String message) {
        TextView scoreMessage = (TextView) findViewById(R.id.total_score_text);
        scoreMessage.setText(message);
        scoreMessage.setVisibility(View.VISIBLE);
    }

}





//
//    private void displayTotal(String userTotal) {
//        TextView userTotalDisplay = (TextView) findViewById(R.id.total_score_text);
//        userTotalDisplay.setText("Score " + radioHamButton);
//        userTotalDisplay.setVisibility(View.VISIBLE);
//    }
