package kr.ac.cnu.jin.workoutapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button recomWO = (Button) findViewById(R.id.recWorkoutBtn);
        Button pastData = (Button) findViewById(R.id.pastDataBtn);

        recomWO.setOnClickListener(new Button.OnClickListener(){
            public void onClick(View v) {
                Intent intent_questions = new Intent(MainActivity.this, QuestionListView.class);
                startActivity(intent_questions);
            }
        });

        pastData.setOnClickListener(new Button.OnClickListener(){
            public void onClick(View v){
                Intent intent_pastData = new Intent(MainActivity.this, pastData.class);
                startActivity(intent_pastData);
            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
