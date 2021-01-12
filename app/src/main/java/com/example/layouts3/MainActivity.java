package com.example.layouts3;

import androidx.appcompat.app.AppCompatActivity;

import android.media.Image;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    // 0 = X;
    // 1 = O;
    int activePlayer = 0;
    boolean activeapp = true;
    int[] gameState = {2,2,2,2,2,2,2,2,2};
    int[][] winPos = {
                        {0,1,2} , {3,4,5} , {6,7,8},
                        {0,3,6} , {1,4,7} , {2,5,8},
                        {0,4,8} , {2,4,6}
                     };
    public void playerTap(View view)
    {
        ImageView img = (ImageView) view;
        int tappimgtag = Integer.parseInt(img.getTag().toString());
        if(!activeapp)
            gameReset(view);
        if(gameState[tappimgtag] == 2)
        {
            gameState[tappimgtag] = activePlayer;
            img.setTranslationY(-1000f);
            if(activePlayer == 0)
            {
                img.setImageResource(R.drawable.cross);
                activePlayer = 1;
                TextView txt = findViewById(R.id.status);
                txt.setText("o s turn - tap to play");
            }
            else
            {
                img.setImageResource(R.drawable.o);
                activePlayer = 0;
                TextView txt = findViewById(R.id.status);
                txt.setText("x s turn - tap to play");
            }
            img.animate().translationYBy(1000f).setDuration(300);
        }

        for(int[] winPositions : winPos)
        {
            String winstr;
            if(gameState[winPositions[0]] == gameState[winPositions[1]] &&
                    gameState[winPositions[1]] == gameState[winPositions[2]] &&
                        gameState[winPositions[0]] != 2)
            {

                activeapp = false;
                if(gameState[winPositions[0]] == 0)
                    winstr = "x has won the match";
                else
                    winstr = "o has won the match";

                TextView txt = findViewById(R.id.status);
                txt.setText(winstr);
            }


        }

    }

    public void gameReset(View view)
    {
        activePlayer = 0;
        activeapp = true;
        for(int i = 0; i < gameState.length; i++)
        {
            gameState[i] = 2;
        }
        ((ImageView)findViewById(R.id.imageView0)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView1)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView2)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView3)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView4)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView5)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView6)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView7)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView8)).setImageResource(0);

        TextView txt = findViewById(R.id.status);
        txt.setText("x turn - tap to play");
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}