package com.example.xo_game;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Arrays;

public class MainActivity extends AppCompatActivity {
ImageView one,two,three,four,five,sex,seven,eight,nine;
Button playAgain;
int player=0;///// 0 for player one and 1 for player two
boolean gameOver=false;
    int []gameState={2,2,2,2,2,2,2,2,2};
    final int[][] winning_Position = {
            {0, 1, 2}, {3, 4, 5}, {6, 7, 8}, {0, 3, 6}, {1, 4, 7}, {2, 5, 8}
            , {0, 4, 8}, {2, 4, 6}
    };
    boolean Active_play=true;
    boolean sameOne_winne=true;
    LinearLayout layout;
    int roundCoun=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        playAgain=findViewById(R.id.play_again);
        layout=findViewById(R.id.winner_layout);
        playAgain.setOnClickListener(this::PlayAgain);

one=findViewById(R.id.image1);
two=findViewById(R.id.image2);
three=findViewById(R.id.image3);
four=findViewById(R.id.image4);
five=findViewById(R.id.image5);
sex=findViewById(R.id.image6);
seven=findViewById(R.id.image7);
eight=findViewById(R.id.image8);

nine=findViewById(R.id.image9);
        one.setOnClickListener(this::onItemClick);
        two.setOnClickListener(this::onItemClick);
        three.setOnClickListener(this::onItemClick);
       four.setOnClickListener(this::onItemClick);
        five.setOnClickListener(this::onItemClick);
        sex.setOnClickListener(this::onItemClick);
        seven.setOnClickListener(this::onItemClick);
        eight.setOnClickListener(this::onItemClick);
       nine.setOnClickListener(this::onItemClick);
    }

    public void onItemClick(View view) {
        ImageView xoImage=(ImageView) view;
        ///// the tapped var for  who is play
        int tapped_xo= Integer.parseInt((String) xoImage.getTag());
        xoImage.setTranslationY(-100);
        if (gameState[tapped_xo]==2 && Active_play){
            gameState[tapped_xo]=player;
            if (player==0){
                xoImage.setImageResource(R.drawable.ic_baseline_healing_24);
                player=1;
            }
            else {
                xoImage.setImageResource(R.drawable.ic_baseline_brightness_1_24);
                player=0;
            }
            xoImage.animate().translationYBy(100f).rotation(360).setDuration(400);
        }
        for (int []Winner_position:winning_Position
             ) {
            if (gameState[Winner_position[0]]==gameState[Winner_position[1]] &&
            gameState[Winner_position[1]]==gameState[Winner_position[2]]&& gameState[Winner_position[0]]!=2){
Active_play=false;
sameOne_winne=true;
String winner="o";
if (gameState[Winner_position[0]]==0){
    winner="x";
}
                TextView textView=findViewById(R.id.winner_state);
textView.setText("the winner is  "+winner);

                layout.setVisibility(View.VISIBLE);


            }


            if(roundCoun==8){
                TextView textView=findViewById(R.id.winner_state);
                textView.setText(" No winner");

                layout.setVisibility(View.VISIBLE);


            }

            }
        roundCoun++;
        }


    public void PlayAgain(View view){
        Active_play=true;sameOne_winne=false;
        layout.setVisibility(View.INVISIBLE);
        player=0;
        Arrays.fill(gameState, 2);
        one.setImageResource(0);
        two.setImageResource(0);
        three.setImageResource(0);
       four.setImageResource(0);
        five.setImageResource(0);
       sex.setImageResource(0);
        seven.setImageResource(0);
       eight.setImageResource(0);
      nine.setImageResource(0);

    }
}