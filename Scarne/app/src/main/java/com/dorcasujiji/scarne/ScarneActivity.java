package com.dorcasujiji.scarne;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.*;
import android.widget.Button;
import android.widget.ImageView;

import java.*;
import java.util.Random;

public class ScarneActivity extends AppCompatActivity {

    // scores
    public int userOverallScore = 0;
    public int compOverallScore = 0;
    public int userTurnScore = 0;
    public int compTurnScore = 0;
    public int rolledvalue =0;

    // buttons
    Button rollButton;
    Button holdButton;
    Button resetButton;

    // turn tracker
    Boolean turn = true;

    public void ScarneActivity(){

    }

    public void roll(){
        Random rand = new Random();
        int randNum = rand.nextInt(5) +1;
        ImageView imageView = (ImageView) findViewById(R.id.diceImage);
        if(randNum == 1){
            imageView.setImageDrawable(getResources().getDrawable(R.drawable.dice1));
        }
        else if(randNum == 2){
            imageView.setImageDrawable(getResources().getDrawable(R.drawable.dice2));
        }
        else if(randNum == 3){
            imageView.setImageDrawable(getResources().getDrawable(R.drawable.dice3));
        }
        else if(randNum == 4){
            imageView.setImageDrawable(getResources().getDrawable(R.drawable.dice4));
        }


//        if(randNum==1){
//            userTurnScore=0;
//            compTurnScore =0;
//        }
//        else{
//
//        }
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scarne);

        rollButton = (Button) findViewById(R.id.rollButton);
        holdButton = (Button) findViewById(R.id.holdButton);
        resetButton = (Button) findViewById(R.id.resetButton);

    }
}
