package kr.ac.cnu.jin.workoutapp;

/**
 * Created by Jin on 2015-11-14.
 */
import android.app.Activity;
import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toast;

import java.util.Stack;

public class WorkoutData extends Activity {
    public int[] checkArray = new int[10];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.data_workout);

        final Intent intent = getIntent();
        int checked_item = Integer.valueOf(intent.getStringExtra("check"));

        int currentCheck = checked_item % 10;
        checked_item /= 10;

        Stack<Integer> tempCheck = new Stack<Integer>();
        int checked_index = 0;

        int i;
        for (i = 0; i < 10; i++) {

            if (currentCheck == 1)
                tempCheck.push(checked_index);

            currentCheck = checked_item % 10;
            checked_item /= 10;
            checked_index++;
        }

        int index = 0;

        while (!tempCheck.empty()) {
            checkArray[index] = 10 - tempCheck.pop();
            index++;
        }

        int k;
        for(k=0; k<10; k++)
            findViewById(R.id.imageButton1+k).setVisibility(View.GONE);

        ImageButton imageButton01 = (ImageButton) findViewById(R.id.imageButton1);
        ImageButton imageButton02 = (ImageButton) findViewById(R.id.imageButton2);
        ImageButton imageButton03 = (ImageButton) findViewById(R.id.imageButton3);
        ImageButton imageButton04 = (ImageButton) findViewById(R.id.imageButton4);
        ImageButton imageButton05 = (ImageButton) findViewById(R.id.imageButton5);
        ImageButton imageButton06 = (ImageButton) findViewById(R.id.imageButton6);
        ImageButton imageButton07 = (ImageButton) findViewById(R.id.imageButton7);
        ImageButton imageButton08 = (ImageButton) findViewById(R.id.imageButton8);
        ImageButton imageButton09 = (ImageButton) findViewById(R.id.imageButton9);
        ImageButton imageButton10 = (ImageButton) findViewById(R.id.imageButton10);

        int j;
        for (j = 0; j < checkArray.length; j++) {
            if(checkArray[j] != 0) {
                //Toast.makeText(WorkoutData.this, "체크된 리스트 position : " + checkArray[j], Toast.LENGTH_SHORT).show();
                switch(checkArray[j]){
                    case 1:
                        imageButton01.setVisibility(View.VISIBLE);
                        imageButton01.setOnClickListener(new Button.OnClickListener(){
                                public void onClick(View v) {
                                Intent intent_wo01 = new Intent(WorkoutData.this, SelectedWork.class);
                                startActivity(intent_wo01);
                            }
                        });
                        break;
                    case 2:
                        imageButton02.setVisibility(View.VISIBLE);
                        imageButton02.setOnClickListener(new Button.OnClickListener() {
                            public void onClick(View v) {
                                Intent intent_wo02 = new Intent(WorkoutData.this, SelectedWork02.class);
                                startActivity(intent_wo02);
                            }
                        });
                        break;
                    case 3:
                        imageButton03.setVisibility(View.VISIBLE);
                        imageButton03.setOnClickListener(new Button.OnClickListener() {
                            public void onClick(View v) {
                                Intent intent_wo03 = new Intent(WorkoutData.this, SelectedWork03.class);
                                startActivity(intent_wo03);
                            }
                        });
                        break;
                    case 4:
                        imageButton04.setVisibility(View.VISIBLE);
                        imageButton04.setOnClickListener(new Button.OnClickListener() {
                            public void onClick(View v) {
                                Intent intent_wo04 = new Intent(WorkoutData.this, SelectedWork04.class);
                                startActivity(intent_wo04);
                            }
                        });
                        break;
                    case 5:
                        imageButton05.setVisibility(View.VISIBLE);
                        imageButton05.setOnClickListener(new Button.OnClickListener() {
                            public void onClick(View v) {
                                Intent intent_wo05 = new Intent(WorkoutData.this, SelectedWork05.class);
                                startActivity(intent_wo05);
                            }
                        });
                        break;
                    case 6:
                        imageButton06.setVisibility(View.VISIBLE);
                        imageButton06.setOnClickListener(new Button.OnClickListener() {
                            public void onClick(View v) {
                                Intent intent_wo06 = new Intent(WorkoutData.this, SelectedWork06.class);
                                startActivity(intent_wo06);
                            }
                        });
                        break;
                    case 7:
                        imageButton07.setVisibility(View.VISIBLE);
                        imageButton07.setOnClickListener(new Button.OnClickListener() {
                            public void onClick(View v) {
                                Intent intent_wo07 = new Intent(WorkoutData.this, SelectedWork07.class);
                                startActivity(intent_wo07);
                            }
                        });
                        break;
                    case 8:
                        imageButton08.setVisibility(View.VISIBLE);
                        imageButton08.setOnClickListener(new Button.OnClickListener() {
                            public void onClick(View v) {
                                Intent intent_wo08 = new Intent(WorkoutData.this, SelectedWork08.class);
                                startActivity(intent_wo08);
                            }
                        });
                        break;
                    case 9:
                        imageButton09.setVisibility(View.VISIBLE);
                        imageButton09.setOnClickListener(new Button.OnClickListener() {
                            public void onClick(View v) {
                                Intent intent_wo09 = new Intent(WorkoutData.this, SelectedWork09.class);
                                startActivity(intent_wo09);
                            }
                        });
                        break;
                    case 10:
                        imageButton10.setVisibility(View.VISIBLE);
                        imageButton10.setOnClickListener(new Button.OnClickListener() {
                            public void onClick(View v) {
                                Intent intent_wo10 = new Intent(WorkoutData.this, SelectedWork10.class);
                                startActivity(intent_wo10);
                            }
                        });
                        break;
                }
                //switch문 종료
            }
        }
    }
}
