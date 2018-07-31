package kr.ac.cnu.jin.workoutapp;

        import android.app.Activity;
        import android.content.Intent;
        import android.os.Bundle;
        import android.view.View;
        import android.view.inputmethod.EditorInfo;
        import android.widget.Button;
        import android.widget.EditText;
        import android.widget.Toast;

        import java.text.*;
        import java.util.*;

/**
 * Created by Jin on 2015-11-26.
 */
public class WorkOutTime extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.time_workout);

        Button saveTime = (Button)findViewById(R.id.saveInput);

        saveTime.setOnClickListener(new Button.OnClickListener() {
            public void onClick(View v) {
                SimpleDateFormat Date = new SimpleDateFormat("yyyy.MM.dd", Locale.KOREA);
                Date currentTime = new Date();
                String date = Date.format(currentTime);

                int timeSum = 0;
                int i;
                for (i = 0; i < 10; i++) {
                    EditText time01 = (EditText) findViewById(R.id.time01+i);
                    if (time01.getText().toString().length() == 0)
                        timeSum += 0;
                    else
                        timeSum += Integer.valueOf("" + time01.getText());
                }
                //Toast.makeText(WorkOutTime.this, ""+timeSum+" "+Date , Toast.LENGTH_SHORT).show();

                Intent intentTime = new Intent(WorkOutTime.this,pastData.class);
                intentTime.putExtra("time",timeSum);
                intentTime.putExtra("date",date);
                startActivity(intentTime);
            }
        });



    }
}
