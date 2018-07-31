package kr.ac.cnu.jin.workoutapp;

/**
 * Created by Jin on 2015-11-14.
 */
import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import org.achartengine.ChartFactory;
import org.achartengine.GraphicalView;
import org.achartengine.chart.BarChart;
import org.achartengine.model.CategorySeries;
import org.achartengine.model.XYMultipleSeriesDataset;
import org.achartengine.renderer.SimpleSeriesRenderer;
import org.achartengine.renderer.XYMultipleSeriesRenderer;

import java.util.ArrayList;
import java.util.List;

public class pastData extends Activity{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.data_past);

        Intent intent = getIntent();

        // 값 intent 받아오기
        String Date = intent.getStringExtra("date");
        int Time = intent.getIntExtra("time", 0);

        final TimeDataBase dbManager = new TimeDataBase(getApplicationContext(), "Data.db", null, 1);

        String dbDate = dbManager.DateData();
        //int dbTime = dbManager.TimeData();


        if(Date.equals(dbDate)) {
            Time += Time;
            Toast.makeText(pastData.this, "업데이트 되었습니다.", Toast.LENGTH_SHORT).show();
            dbManager.update("update WorkoutTime set time = " + Time + " where date = '" + Date + "';");
        }

        else {
            Toast.makeText(pastData.this, "새로 추가 되었습니다.", Toast.LENGTH_SHORT).show();
            dbManager.insert("insert into WorkoutTime values('" + Date + "', " + Time+ ");");

        }

        int idx=0;
        List<double[]> values = new ArrayList<double[]>();
        double [] a = new double[7];
        for(idx=0; idx<a.length;) {
            a[idx] = Time;
            idx++;
            break;
        }
        values.add(a);

        // 쿼리 결과 입력
        final TextView tvResult = (TextView) findViewById(R.id.tv_result);
        tvResult.setText(dbManager.PrintData());

        // DB에 저장 될 속성을 입력받는다
        final EditText editDate= (EditText) findViewById(R.id.date);


        // Delete
        Button btnDelete = (Button) findViewById(R.id.btn_delete);
        btnDelete.setOnClickListener(new Button.OnClickListener() {

            @Override
            public void onClick(View v) {
                // delete from 테이블명 where 조건;
                String date = editDate.getText().toString();
                dbManager.delete("delete from WorkoutTime where date = '" + date + "';");

                tvResult.setText( dbManager.PrintData() );
            }
        });

        // 표시할 수치값


        /** 그래프 출력을 위한 그래픽 속성 지정객체 */
        XYMultipleSeriesRenderer renderer = new XYMultipleSeriesRenderer();

        // 분류에 대한 이름
        String[] titles = new String[]{"월별 판매량"};

        // 항목을 표시하는데 사용될 색상값
        int[] colors = new int[] { Color.BLACK };

        // 분류명 글자 크기 및 각 색상 지정
        renderer.setLegendTextSize(20);
        int length = colors.length;
        for (int i = 0; i < length; i++) {
            SimpleSeriesRenderer r = new SimpleSeriesRenderer();
            r.setColor(colors[i]);
            r.setDisplayChartValues(true);
            r.setChartValuesTextSize(40);
            renderer.addSeriesRenderer(r);
        }

        // X,Y축 항목이름과 글자 크기
        renderer.setXTitle("일");
        renderer.setYTitle("운동량");
        renderer.setAxisTitleTextSize(40);

        // 수치값 글자 크기 / X축 최소,최대값 / Y축 최소,최대값
        renderer.setLabelsTextSize(10);
        renderer.setXAxisMin(0.5);
        renderer.setXAxisMax(7.5);
        renderer.setYAxisMin(0);
        renderer.setYAxisMax(500);

        renderer.setMarginsColor(Color.WHITE);

        // X,Y축 라인 색상
        renderer.setAxesColor(Color.YELLOW);
        // 상단제목, X,Y축 제목, 수치값의 글자 색상
        renderer.setLabelsColor(Color.LTGRAY);

        // X축의 표시 간격
        renderer.setXLabels(12);
        // Y축의 표시 간격
        renderer.setYLabels(5);

        // X,Y축 정렬방향
        renderer.setXLabelsAlign(Paint.Align.LEFT);
        renderer.setYLabelsAlign(Paint.Align.LEFT);
        // X,Y축 스크롤 여부 ON/OFF
        renderer.setPanEnabled(true, false);
        // ZOOM기능 ON/OFF
        renderer.setZoomEnabled(false, false);
        // ZOOM 비율
        renderer.setZoomRate(1.0f);
        // 막대간 간격
        renderer.setBarSpacing(0.5f);

        // 설정 정보 설정
        XYMultipleSeriesDataset dataset = new XYMultipleSeriesDataset();
        for (int i = 0; i < titles.length; i++) {
            CategorySeries series = new CategorySeries(titles[i]);
            double[] v = values.get(i);
            int seriesLength = v.length;
            for (int k = 0; k < seriesLength; k++) {
                series.add(v[k]);
            }
            dataset.addSeries(series.toXYSeries());
        }

        // 그래프 객체 생성
        GraphicalView gv = ChartFactory.getBarChartView(this, dataset,
                renderer, BarChart.Type.STACKED);

        // 그래프를 LinearLayout에 추가
        LinearLayout llBody = (LinearLayout) findViewById(R.id.llBody);
        llBody.addView(gv);

        Button gogo = (Button) findViewById(R.id.ok);
        gogo.setOnClickListener(new Button.OnClickListener(){
            public void onClick(View v) {
                Intent gogohome = new Intent(pastData.this, MainActivity.class);
                startActivity(gogohome);
            }
        });
    }
}
