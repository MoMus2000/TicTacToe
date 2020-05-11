package com.example.rt;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.GridLayout;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    int activeplayer = 0;
    int[] gamestate = {2,2,2,2,2,2,2,2,2}; //represents empty board
    int[][] winningPositions = {{0,1,2},{0,3,6},{1,4,7},{2,5,8}, {3,4,7}, {6,7,8}, {0,4,8},{2,4,8}};
    boolean ongoing = true;
    public void onclick(View view){
        ImageView counter = (ImageView) view;
        counter.setTranslationY(-1500);
        int tapped = Integer.parseInt(counter.getTag().toString());
        if(gamestate[tapped] == 2 && ongoing) {
            gamestate[tapped]= activeplayer;// puts 1's or 0s in the position.




            Log.i("TAG", counter.getTag().toString());
            if (activeplayer == 0) {
                counter.setImageResource(R.drawable.tick);
                activeplayer = 1;

            } else {
                counter.setImageResource(R.drawable.x);
                activeplayer = 0;
            }
            counter.animate().translationYBy(1500).setDuration(750);
            String winner = "";


            for (int[] winningPosition : winningPositions) {
                if (gamestate[winningPosition[0]] == gamestate[winningPosition[1]] && gamestate[winningPosition[1]] == gamestate[winningPosition[2]] && gamestate[winningPosition[0]] != 2) {
                    ongoing = false;
                    if(activeplayer ==1 ){
                        winner = "Tick has won";
                    }
                    else{
                        winner = "cross has won";
                    }
                    Toast.makeText(this, winner, Toast.LENGTH_SHORT).show();
                    Button button = (Button) findViewById(R.id.Play_Again);
                    button.setVisibility(View.VISIBLE);
                }



            }
        }
        Button button = (Button) findViewById(R.id.Play_Again);
        button.setVisibility(View.VISIBLE);


    }

    public void onclick1(View view){
            this.recreate();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}
