package com.task.dice;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Random;

public class MainActivity extends AppCompatActivity {
    Random random = new Random();

    ArrayList<String> list = new ArrayList<>(); // List는 시도횟수 + 눈의 값을 String으로 만들어 저장
    int count = 1; // Count는 주사위를 굴린 시도 횟수
    int result = 0; // result는 주사위 눈의 값

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if (savedInstanceState != null) {
            list = savedInstanceState.getStringArrayList("list");
            count = savedInstanceState.getInt("count", count); // 기존 값들이 있으면 받아옴
        }
    }

    @Override
    public void onSaveInstanceState(Bundle savedInstanceState) {
        super.onSaveInstanceState(savedInstanceState);
        savedInstanceState.putStringArrayList("list", list);
        savedInstanceState.putInt("count", count);
    }

    @Override
    protected void onResume() {
        super.onResume();
        TextView resultList = (TextView)findViewById(R.id.resultList);
        resultList.setText(""); // resume시 resultList의 text를 초기화한 후
        for (String result : list) {
            resultList.append(result);
        } // list에 있는 값들을 추가
    }
    @Override
    protected void onPause() {
        super.onPause(); // Pause가 없어도 동작에는 문제가 없음 - onPause에서 수행하는 작업이 없으므로
    }

    public void onClickRoll(View view) {
        TextView resultList = (TextView)findViewById(R.id.resultList);

        resultList.append(diceRoll()); // textView의 text에 값 추가
        
        ScrollView scrollView = (ScrollView)findViewById(R.id.resultArea);
        scrollView.post(new Runnable() {
            @Override
            public void run() {
                scrollView.fullScroll(ScrollView.FOCUS_DOWN);
            }
        }); // 자동으로 아래로 스크롤 / 주사위를 굴릴때마다 반복 == 굴릴때마다 스크롤을 제일 아래로 내림 == scrollView 자동 갱신
    }
    
    public void onClickReset(View view) {
        TextView resultList = (TextView)findViewById(R.id.resultList);
        
        count = 1; // Count 초기화
        list.clear(); // list 초기화
        resultList.setText(""); // textView의 text 초기화
    }

    public String diceRoll() {
        result = random.nextInt(5) + 2;
        ImageButton ib = (ImageButton)findViewById(R.id.roll);
        int image = R.drawable.diceresult6; // 성능향상에 도움?

        String text = count + ". " + result + "\n";
        switch (result) {
            case 1:
                image = R.drawable.diceresult1;
                ib.setImageResource(image);
                break;
            case 2:
                image = R.drawable.diceresult2;
                ib.setImageResource(image);
                break;
            case 3:
                image = R.drawable.diceresult3;
                ib.setImageResource(image);
                break;
            case 4:
                image = R.drawable.diceresult4;
                ib.setImageResource(image);
                break;
            case 5:
                image = R.drawable.diceresult5;
                ib.setImageResource(image);
                break;
            default:
                ib.setImageResource(image);
                break;
        }

        count++;
        list.add(text);
        return text;
    }
}