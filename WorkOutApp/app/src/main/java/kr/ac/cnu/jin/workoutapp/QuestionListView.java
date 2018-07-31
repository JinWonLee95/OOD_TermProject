package kr.ac.cnu.jin.workoutapp;

/**
 * Created by Jin on 2015-11-14.
 */
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

import java.util.ArrayList;

import android.app.ListActivity;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;

import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

public class QuestionListView extends Activity {

    private int check_item;
    private boolean[] isCheck = new boolean[10];

    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.listview_question);
        check_item = -1;

        ArrayList<String> list = new ArrayList<String>();
        ArrayAdapter<String> question = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_multiple_choice, list);

        ListView lv = (ListView) findViewById(R.id.list);

        lv.setAdapter(question);
        lv.setChoiceMode(ListView.CHOICE_MODE_MULTIPLE);

        list.add("허리가 자주 아프다.");
        list.add("다리를 자주 꼰다.");
        list.add("몸이 뻐근하게 느껴진다.");
        list.add("다리가 자주 붓는다.");
        list.add("오늘 하루 5시간 이상 앉아있었다.");
        list.add("일주일에 세번 이상 변을 보지 못했다.");
        list.add("깊게 잠들지 못한다.");
        list.add("뒷목이 뻐근하다.");
        list.add("피로가 누적 되었다.");
        list.add("눈이 피로하다.");

        // 설문

        Button nextBtn = (Button) findViewById(R.id.next);

        nextBtn.setOnClickListener(new Button.OnClickListener(){
            int i;
            public void onClick(View v){
                if(check_item == -1)
                    Toast.makeText(QuestionListView.this, "체크가 되어있지 않습니다", Toast.LENGTH_SHORT).show();
                else {
                    String checked = "";
                    Intent intent_woData = new Intent(QuestionListView.this, WorkoutData.class);
                    for(int i = 0 ; i <10; i++){
                        if(isCheck[i])
                            checked += "1";
                        else
                            checked += "0";
                    }
                    intent_woData.putExtra("check", checked);
                    startActivity(intent_woData);
                }
            }
        });

        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                isCheck[position] = !isCheck[position];
                check_item = 0;
            }
        });
    }
}