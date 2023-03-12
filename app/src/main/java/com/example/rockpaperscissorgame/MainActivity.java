package com.example.rockpaperscissorgame;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    TextView tvYouScore, tvComputerScore,tvRoundResult;
    Button btRock, btPaper, btScissor;
    ImageView IvUserChoice, IvComputerChoice;

    int userScore, computerScore;
    int roundCount = 1;
    String ComputerChoice = "";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        handleClick();
        gameBreak();
    }

    private void initView() {
        tvYouScore = findViewById(R.id.tvYouScore);
        tvComputerScore = findViewById(R.id.tvComputerScore);
        tvRoundResult = findViewById(R.id.tvRoundResult);

        btRock = findViewById(R.id.btRock);
        btPaper = findViewById(R.id.btPaper);
        btScissor = findViewById(R.id.btScissor);

        IvUserChoice = findViewById(R.id.IvUserChoice);
        IvComputerChoice = findViewById(R.id.IvComputerChoice);
    }

    private void handleClick() {
            btRock.setOnClickListener(v -> {
                IvUserChoice.setImageResource(R.mipmap.rock);
                playing("rock");
                roundCount++;

            });
            btPaper.setOnClickListener(v -> {
                IvUserChoice.setImageResource(R.mipmap.paper);
                playing("paper");
                roundCount++;

            });
            btScissor.setOnClickListener(v -> {
                IvUserChoice.setImageResource(R.mipmap.scissor);
                playing("scissors");
                roundCount++;

            });


    }

    private void playing(String userChoice) {

        Random r = new Random();
        int ComputerChoiceNumber = r.nextInt(3) + 1;
        if (ComputerChoiceNumber == 1) {
            ComputerChoice = "rock";
            IvComputerChoice.setImageResource(R.mipmap.rock);
        } else if (ComputerChoiceNumber == 2) {
            ComputerChoice = "paper";
            IvComputerChoice.setImageResource(R.mipmap.paper);

        } else if (ComputerChoiceNumber == 3) {
            ComputerChoice = "scissors";
            IvComputerChoice.setImageResource(R.mipmap.scissor);
        }

        if (ComputerChoice == userChoice) {
            tvRoundResult.setText("Draw in " + roundCount);
            //return "Draw";
        } else if (userChoice == "rock" && ComputerChoice== "scissors") {
            userScore++;
            tvYouScore.setText("your Score" + userScore + "/" + 5);
            tvComputerScore.setText("Computer Score"+computerScore+"/"+5);
            tvRoundResult.setText("you win round " + roundCount);
            //return "You Win";
        } else if (userChoice == "rock" && ComputerChoice == "paper") {
            computerScore++;
            tvYouScore.setText("your Score" + userScore + "/" + 5);
            tvComputerScore.setText("Computer Score"+computerScore+"/"+5);
            tvRoundResult.setText("Computer win round " + roundCount);
            //return "Computer win";
        } else if (userChoice == "scissors" && ComputerChoice == "rock") {
            computerScore++;
            tvYouScore.setText("your Score" + userScore + "/" + 5);
            tvComputerScore.setText("Computer Score"+computerScore+"/"+5);
            tvRoundResult.setText("Computer win round " + roundCount);
            //return "Computer win";
        } else if (userChoice == "scissors" && ComputerChoice == "paper") {
            userScore++;
            tvYouScore.setText("your Score" + userScore + "/" + 5);
            tvComputerScore.setText("Computer Score"+computerScore+"/"+5);
            tvRoundResult.setText("you win round " + roundCount);

            //return "You win";
        } else if (userChoice == "paper" && ComputerChoice == "rock") {
            userScore++;
            tvYouScore.setText("your Score" + userScore + "/" + 5);
            tvComputerScore.setText("Computer Score"+computerScore+"/"+5);
            tvRoundResult.setText("you win round " + roundCount);
            //return "You win";

             }
        else if (userChoice == "paper" && ComputerChoice == "scissors") {
            userScore++;
            tvYouScore.setText("your Score" + userScore + "/" + 5);
            tvComputerScore.setText("Computer Score"+computerScore+"/"+5);
            tvRoundResult.setText("Computer round " + roundCount);
            //return "You win";

        }
        //else return "";
    }
    private void gameBreak(){
        if(roundCount == 5){
            tvRoundResult.setText("Round 5 Done");
            Toast.makeText(MainActivity.this,"Done",Toast.LENGTH_SHORT).show();
        }
    }
}