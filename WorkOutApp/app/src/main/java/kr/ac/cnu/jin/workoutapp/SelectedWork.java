package kr.ac.cnu.jin.workoutapp;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

/**
 * Created by Jin on 2015-11-22.
 */
public class SelectedWork extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.selected_work);

        Button gotoHome = (Button) findViewById(R.id.Home);
        Button input_time = (Button) findViewById(R.id.input);

        gotoHome.setOnClickListener(new Button.OnClickListener(){
            public void onClick(View v){
                Intent goHome = new Intent(SelectedWork.this, MainActivity.class);
                startActivity(goHome);
            }
        });

        input_time.setOnClickListener(new Button.OnClickListener(){
            public void onClick(View v){
                Intent doInputTime = new Intent(SelectedWork.this, WorkOutTime.class);
                startActivity(doInputTime);
            }
        });

    }
}
