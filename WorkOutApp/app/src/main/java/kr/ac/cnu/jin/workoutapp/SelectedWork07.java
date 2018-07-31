package kr.ac.cnu.jin.workoutapp;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

/**
 * Created by Jin on 2015-11-26.
 */
public class SelectedWork07 extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.selected_work_07);

        Button gotoHome = (Button) findViewById(R.id.Home);
        Button input_time = (Button) findViewById(R.id.input);
        gotoHome.setOnClickListener(new Button.OnClickListener() {
            public void onClick(View v) {
                Intent goHome = new Intent(SelectedWork07.this, MainActivity.class);
                startActivity(goHome);
            }
        });

        input_time.setOnClickListener(new Button.OnClickListener(){
            public void onClick(View v){
                Intent doInputTime = new Intent(SelectedWork07.this, WorkOutTime.class);
                startActivity(doInputTime);
            }
        });
    }
}