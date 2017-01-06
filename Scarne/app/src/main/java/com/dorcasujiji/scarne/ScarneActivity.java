package com.dorcasujiji.scarne;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.*;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.*;
import java.util.Random;

public class ScarneActivity extends AppCompatActivity {

    // scores
    public int userOverallScore = 0;
    public int compOverallScore = 0;
//    public int userTurnScore = 0;
//    public int compTurnScore = 0;
    public int turnScore = 0;
    public int rolledvalue =0;

    // buttons
    Button rollButton;
    Button holdButton;
    Button resetButton;

    // track running of app
    Boolean running = true;

    // turn tracker
    public enum Turn{
        User,Computer
    }

    public boolean presPlayer = true;

    public void roll(){
        Random rand = new Random();
        int randNum = rand.nextInt(5) +1;
        Turn turn = Turn.User;
        ImageView imageView = (ImageView) findViewById(R.id.diceImage);

            if(randNum == 1){
                imageView.setImageDrawable(getResources().getDrawable(R.drawable.dice1));
                turnScore = 0;
                if(presPlayer? false:true);
            }
            else if(randNum == 2){
                imageView.setImageDrawable(getResources().getDrawable(R.drawable.dice2));
                turnScore += 2;
            }
            else if(randNum == 3){
                imageView.setImageDrawable(getResources().getDrawable(R.drawable.dice3));
                turnScore += 3;
            }
            else if(randNum == 4){
                imageView.setImageDrawable(getResources().getDrawable(R.drawable.dice4));
                turnScore += 4;
            }
            else if(randNum == 5){
                imageView.setImageDrawable(getResources().getDrawable(R.drawable.dice5));
                turnScore += 5;
            }
            else if(randNum == 6){
                imageView.setImageDrawable(getResources().getDrawable(R.drawable.dice6));
                turnScore += 6;
            }
            scoreChange(userOverallScore,compOverallScore,turnScore);
        }

    /** Handles display of scores on screen */
    private void scoreChange(int userScore, int compScore, int presturnScore){
        TextView textView = (TextView) findViewById(R.id.one);
        textView.setText("Your score " + userScore + " Computer score " + compScore + " Turn score " + presturnScore);
    }

    /** Handles rolling when computer's turn to play*/
    private void computerTurn(){
        rollButton.setEnabled(false);
        holdButton.setEnabled(false);
//        while(!presPlayer){
//            roll();
//        }
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scarne);

        // ROLL BUTTON
        rollButton = (Button) findViewById(R.id.rollButton);
        rollButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                roll();
            }
    });

        // HOLD BUTTON
        holdButton = (Button) findViewById(R.id.holdButton);
        holdButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(presPlayer){
                    userOverallScore += turnScore;
                    presPlayer = false;
                }
                else{
                    compOverallScore += turnScore;
                    presPlayer = true;
                    computerTurn();
                }
                // reset turnScore
                turnScore =0;
                // update scores display
                scoreChange(userOverallScore,compOverallScore,turnScore);

            }
        });

        // RESET BUTTON
        resetButton = (Button) findViewById(R.id.resetButton);
        resetButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                userOverallScore = 0;
                compOverallScore = 0;
                turnScore = 0;
                presPlayer = true;
            }
        });

    }
}

// to do
/*
* - keep track of scores and display them
*  - keep track of changing users turns
*  */
