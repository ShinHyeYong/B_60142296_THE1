package com.example.hy.example;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Activity3 extends AppCompatActivity {

    private int minNum;
    private int result;
    private Button minBtn3;
    private Button plusBtn3;
    private Button back3;
    TextView textView3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_3);

        // 텍스트뷰 선언
        TextView textView = (TextView) findViewById(R.id.textView3);

        minBtn3 = (Button) findViewById(R.id.minBtn3);
        plusBtn3 = (Button) findViewById(R.id.plusBtn3);
        back3 = (Button) findViewById(R.id.back3);
        Intent intent = getIntent();

        result = intent.getExtras().getInt("insertNum");

        textView.setText(String.valueOf(result));

        minBtn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // 3에서 - 누르면 2로
                Intent intent1 = new Intent(Activity3.this, Activity2.class);
                intent1.putExtra("insertNum", result - 1);
                startActivity(intent1);
            }
        });

        plusBtn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // 3에서 + 누르면 4로
                Intent intent = new Intent(Activity3.this, Activity4.class);
                intent.putExtra("insertNum", result + 1);
                startActivity(intent);
            }
        });

        back3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Activity3.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }
}
